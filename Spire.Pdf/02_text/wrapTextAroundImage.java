import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.*;
import java.util.EnumSet;

public class wrapTextAroundImage{
    public static void main(String[] args) throws Exception{
        // Creates a pdf document
        PdfDocument doc = new PdfDocument();

        // Creates a page
        PdfPageBase page = doc.getPages().add();

        // Gets the width of the page canvas
        double pageWidth = page.getCanvas().getClientSize().getWidth();

        // Initializes the vertical position variable
        double y = 0;

        // Adjusts the vertical position
        y = y + 8;

        // Creates a brush
        PdfBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.black));

        // Defines a font
        PdfFont font1 = new PdfFont(PdfFontFamily.Helvetica, 20, EnumSet.of(PdfFontStyle.Bold));

        // Defines a text center alignment format
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Center);

        // Set character spacing
        format1.setCharacterSpacing(1);

        String text = "Spire.PDF for Java";

        // Draws the specified text on the page canvas at the position (pageWidth / 2, y) using the specified font, brush, and format.
        page.getCanvas().drawString(text, font1, brush, pageWidth / 2, y, format1);


        // Measures the size of the text using the specified font and format, and assigns it to the variable 'size'.
        Dimension2D size = font1.measureString(text, format1);

        // Adjusts the vertical position (y) by adding the height of the text along with an additional 6 units.
        y = y + size.getHeight() + 6;

        // Creates a PdfImage object by loading an image from the specified file.
        PdfImage image = PdfImage.fromFile("data/PdfImage.png");

        // Draws the loaded image on the page canvas at the position (pageWidth - imageWidth, y).
        page.getCanvas().drawImage(image, new Point2D.Double(pageWidth - image.getPhysicalDimension().getWidth(), y));

        // Calculates the remaining space available on the left side of the image by subtracting the image width and 2 units from the page width.
        double imageLeftSpace = pageWidth - image.getPhysicalDimension().getWidth() - 2;

        // Calculates the vertical bottom position of the image by adding the image height to the current vertical position.
        double imageBottom = image.getPhysicalDimension().getHeight() + y;

        // Creates a new PdfStringFormat object
        PdfStringFormat format2 = new PdfStringFormat();

        // Loads the text around the image
        File file = new File("data/text.txt");
        text = readText(file, null);

        // Creates a new font to draw text
        PdfFont font2 = new PdfFont(PdfFontFamily.Helvetica, 16, EnumSet.of(PdfFontStyle.Italic));

        // Set the line spacing for the text layout
        format2.setLineSpacing(font2.getSize() * 1.5f);

        // Initializes a PdfStringLayouter object for laying out text in a PDF document
        PdfStringLayouter textLayouter = new PdfStringLayouter();

        // Calculates the height of the block where the image is positioned on the page
        double imageLeftBlockHeight = imageBottom - y;

        // Splits the text around into multiple lines based on the draw area
        PdfStringLayoutResult result = textLayouter.layout(text, font2, format2, new Dimension((int) imageLeftSpace, (int) imageLeftBlockHeight));

        // Checks if the actual height of the text is smaller than the remaining space in the block
        if (result.getActualSize().getHeight() < imageLeftBlockHeight) {

            // Adjusts the block height to accommodate an additional line of text
            imageLeftBlockHeight = imageLeftBlockHeight + result.getLineHeight();

            // Recalculates the text layout with the updated block height
            result = textLayouter.layout(text, font2, format2, new Dimension((int) imageLeftSpace, (int) imageLeftBlockHeight));
        }

        //  Draws each line of text onto the page
        for (LineInfo line : result.getLines()) {

            // Draw the text
            page.getCanvas().drawString(line.getText(), font2, brush, 0, y, format2);

            // Updates the vertical position for the next line
            y = y + result.getLineHeight();
        }

        // Create a PdfTextWidget object with the remaining text, specified font (font2), and brush
        PdfTextWidget textWidget = new PdfTextWidget(result.getRemainder(), font2, brush);

        // Create a PdfTextLayout object
        PdfTextLayout textLayout = new PdfTextLayout();

        // Set the layout break type to Fit_Page, which breaks the text when it reaches the end of the page
        textLayout.setBreak(PdfLayoutBreakType.Fit_Page);

        // Set the layout type to Paginate, which paginates the text across multiple pages if needed
        textLayout.setLayout(PdfLayoutType.Paginate);

        // Create a Rectangle2D.Double object (bounds) that represents the area where the text will be drawn
        Rectangle2D.Double bounds = new Rectangle2D.Double(0, y, page.getCanvas().getClientSize().getWidth(), page.getCanvas().getClientSize().getHeight());

        // Set the string format (format2) for the text widget
        textWidget.setStringFormat(format2);

        // Draw the text widget on the page within the specified bounds and with the specified text layout
        textWidget.draw(page, bounds, textLayout);

        // Specify the output file path for the resulting PDF file that wraps text around an image
        String output = "output/wrapTextAroundImage.pdf";

        // Save the document
        doc.saveToFile(output);

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
