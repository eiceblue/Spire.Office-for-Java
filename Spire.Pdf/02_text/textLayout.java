import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.util.EnumSet;
import java.awt.geom.*;
import java.io.*;

public class textLayout {
    public static void main(String[] args){
        // Create a new PDF document
        PdfDocument doc = new PdfDocument();

        // Add a new page to the document
        PdfPageBase page = doc.getPages().add();
        double pageWidth = page.getCanvas().getClientSize().getWidth();
        double y = 0;

        // Define color, pen, brush, font, and string format for the first text
        PdfRGBColor lightGray = new PdfRGBColor(new Color(211, 211, 211));
        PdfPen pen1 = new PdfPen(lightGray, 1f);
        PdfBrush brush1 = new PdfSolidBrush(lightGray);
        PdfFont font1 = new PdfFont(PdfFontFamily.Helvetica, 8, EnumSet.of(PdfFontStyle.Bold));
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Right);

        // Draw the first text on the page -- Page header
        String text = "Demo of Spire.pdf";
        page.getCanvas().drawString(text, font1, brush1, pageWidth, y, format1);

        // Measure the size of the first text
        Dimension2D size = font1.measureString(text, format1);

        // Update the vertical position for the next drawing operation
        y = y + size.getHeight() + 1;

        // Draw a line below the first text
        page.getCanvas().drawLine(pen1, 0, y, pageWidth, y);

        // Update the vertical position
        y = y + 5;

        // Define brush, font, and string format for the second text
        PdfBrush brush2 = PdfBrushes.getBlack();
        PdfFont font2 = new PdfFont(PdfFontFamily.Helvetica, 16, EnumSet.of(PdfFontStyle.Bold));
        PdfStringFormat format2 = new PdfStringFormat(PdfTextAlignment.Center);
        format2.setCharacterSpacing(1f);

        // Draw the second text on the page -- Title
        text = "Summary of Science";
        page.getCanvas().drawString(text, font2, brush2, pageWidth / 2, y, format2);

        // Measure the size of the second text
        size = font2.measureString(text, format2);

        // Update the vertical position
        y = y + size.getHeight() + 6;

        // Load an image from file -- Icon
        PdfImage image = PdfImage.fromFile("data/Wikipedia_Science.png");

        // Set the position for drawing the image
        Point2D.Float point1 = new Point2D.Float();
        point1.setLocation(pageWidth - image.getPhysicalDimension().getWidth(), y);

        // Draw the image on the page
        page.getCanvas().drawImage(image, point1);

        // Calculate the remaining space on the left side of the image
        double imageLeftSpace = pageWidth - image.getPhysicalDimension().getWidth() - 2;

        // Calculate the bottom position of the image
        double imageBottom = image.getPhysicalDimension().getHeight() + y;

        // Define font and string format for the third text
        PdfFont font3 = new PdfFont(PdfFontFamily.Helvetica, 9);
        PdfStringFormat format3 = new PdfStringFormat();
        format3.setParagraphIndent(font3.getSize() * 2);
        format3.setMeasureTrailingSpaces(true);
        format3.setLineSpacing(font3.getSize() * 1.5f);

        // Draw the third text on the page -- Refenrence content
        String text1 = "(All text and picture from ";
        String text2 = "Wikipedia";
        String text3 = ", the free encyclopedia)";
        page.getCanvas().drawString(text1, font3, brush2, 0, y, format3);

        // Measure the size of the third text
        size = font3.measureString(text1, format3);
        double x1 = size.getWidth();

        // Update the paragraph indent for the second part of the third text
        format3.setParagraphIndent(0);

        // Define font and brush for the underlined text
        PdfFont font4 = new PdfFont(PdfFontFamily.Helvetica, 9, EnumSet.of(PdfFontStyle.Underline));
        PdfBrush brush3 = PdfBrushes.getBlue();

        // Draw the second part of the third text
        page.getCanvas().drawString(text2, font4, brush3, x1, y, format3);

        // Measure the size of the second part of the third text
        size = font4.measureString(text2, format3);
        x1 = x1 + size.getWidth();

        // Draw the third part of the third text
        page.getCanvas().drawString(text3, font3, brush2, x1, y, format3);

        // Update the vertical position
        y = y + size.getHeight();

        // Define string format for the content
        PdfStringFormat format4 = new PdfStringFormat();

        // Create a file object to read the content from -- Content
        File file = new File("data/Summary_of_Science.txt");

        // Read the text from the file
        text = readText(file, null);

        // Define font for the content
        PdfFont font5 = new PdfFont(PdfFontFamily.Helvetica, 10);

        // Set line spacing in the string format
        format4.setLineSpacing(font5.getSize() * 1.5f);

        // Create a layouter to arrange the text
        PdfStringLayouter textLayouter = new PdfStringLayouter();

        // Calculate the available height for the content block
        double imageLeftBlockHeight = imageBottom - y;

        // Create a dimension object with the available space for the content block
        Dimension2D size1 = new Dimension();
        size1.setSize(imageLeftSpace, imageLeftBlockHeight);

        // Layout the text within the available space
        PdfStringLayoutResult result = textLayouter.layout(text, font5, format4, size1);

        // Check if the actual height of the layout is less than the available space
        if (result.getActualSize().getHeight() < imageBottom - y) {
            // Increase the height of the content block to accommodate the remaining lines
            imageLeftBlockHeight = imageLeftBlockHeight + result.getLineHeight();
            size1.setSize(size1.getWidth(), imageLeftBlockHeight);
            result = textLayouter.layout(text, font5, format4, size1);
        }

        // Draw each line of the layout on the page
        for (LineInfo line : result.getLines()) {
            page.getCanvas().drawString(line.getText(), font5, brush2, 0, y, format4);
            y = y + result.getLineHeight();
        }

        // Create a text widget for the remaining text
        PdfTextWidget textWidget = new PdfTextWidget(result.getRemainder(), font5, brush2);

        // Define the layout options for the remaining text
        PdfTextLayout textLayout = new PdfTextLayout();
        textLayout.setBreak(PdfLayoutBreakType.Fit_Page);
        textLayout.setLayout(PdfLayoutType.Paginate);

        // Set the position for drawing the remaining text
        Point2D.Float point = new Point2D.Float();
        point.setLocation(0, y);

        // Get the size of the canvas
        Dimension2D size2 = page.getCanvas().getClientSize();

        // Define the bounds for drawing the remaining text
        Rectangle2D.Float bounds = new Rectangle2D.Float();
        bounds.setRect(point.x, point.y, size2.getWidth(), size2.getHeight());

        // Set the string format for the remaining text widget
        textWidget.setStringFormat(format4);

        // Draw the remaining text on the page using the specified bounds and layout
        textWidget.draw(page, bounds, textLayout);

        // Save the PDF document to a file
        doc.saveToFile("output/textLayout.pdf");

        // Close the PDF document
        doc.close();

        // Dispose of the PDF document (frees up system resources)
        doc.dispose();

    }


    // Read text from txt file
    public static String readText(File file, String charset) {
        FileInputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            // Open the file for reading
            in = new FileInputStream(file);

            // Create a byte array output stream to store the read data
            out = new ByteArrayOutputStream();

            byte[] data = new byte[1024];
            int bytesRead;

            // Read data from the file into the output stream
            while ((bytesRead = in.read(data)) != -1) {
                out.write(data, 0, bytesRead);
            }

            // Convert the read data to a String using the specified character encoding
            if (charset == null) {
                return out.toString();
            } else {
                return new String(out.toByteArray(), charset);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        } finally {
            // Close the input stream
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // Close the output stream
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
