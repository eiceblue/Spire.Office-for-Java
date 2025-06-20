import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.*;

public class createPDFA1WithSpirePDF {
    public static void main(String[] args) {
        // Create a new PdfNewDocument object
        PdfNewDocument doc = new PdfNewDocument();

        // Set the conformance level to Pdf_A_1_B
        doc.setConformance(PdfConformanceLevel.Pdf_A_1_B);

        // Add a new page to the document with A4 size and 40 units margins
        PdfPageBase page = doc.getPages().add(PdfPageSize.A4, new PdfMargins(40));

        // Invoke the drawPage() method to draw the content on the page
        drawPage(page);

        // Specify the output path for the generated PDF file
        String output = "output/createPDFA1WithSpirePDF.pdf";

        // Save the document as a PDF file
        doc.save(output, FileFormat.PDF);

        // Close the document
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }

    public static void drawPage(PdfPageBase page) {
        // Get the width of the page canvas
        double pageWidth = page.getCanvas().getClientSize().getWidth();

        // Initialize the starting y-coordinate
        double y = 0;

        // Add a vertical offset
        y = y + 5;

        // Set up the brush, font, and format for the text
        PdfBrush brush2 = new PdfSolidBrush(new PdfRGBColor(Color.BLACK));
        PdfTrueTypeFont font2 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 16));
        PdfStringFormat format2 = new PdfStringFormat(PdfTextAlignment.Center);
        format2.setCharacterSpacing(1f);
        String text = "Summary of Science";

        // Draw the text on the page canvas
        page.getCanvas().drawString(text, font2, brush2, pageWidth / 2, y, format2);

        // Measure the size of the text
        Dimension2D size = font2.measureString(text, format2);

        // Add a vertical spacing
        y = y + size.getHeight() + 6;

        // Load an image from the specified file
        PdfImage image = PdfImage.fromFile("data/wikipedia_Science.png");

        // Draw the image on the page canvas
        page.getCanvas().drawImage(image, new Point2D.Double(pageWidth - image.getPhysicalDimension().getWidth(), y));

        // Calculate the position of the image's bottom-left corner
        double imageLeftSpace = pageWidth - image.getPhysicalDimension().getWidth() - 2;
        double imageBottom = image.getPhysicalDimension().getWidth() + y;

        // Set up the font and format for additional text lines
        PdfTrueTypeFont font3 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 9));
        PdfStringFormat format3 = new PdfStringFormat();
        format3.setParagraphIndent(font3.getSize() * 2);
        format3.setMeasureTrailingSpaces(true);
        format3.setLineSpacing(font3.getSize() * 1.5f);
        String text1 = "(All text and picture from ";
        String text2 = "Wikipedia";
        String text3 = ", the free encyclopedia)";

        // Draw the first part of the text
        page.getCanvas().drawString(text1, font3, brush2, 0, y, format3);

        // Measure the size of the first part of the text
        size = font3.measureString(text1, format3);
        double x1 = size.getWidth();

        // Adjust the paragraph indent and set up font and brush for the second part of the text
        format3.setParagraphIndent(0);
        PdfTrueTypeFont font4 = new PdfTrueTypeFont(new Font("Arial", Font.CENTER_BASELINE, 9));
        PdfBrush brush3 = PdfBrushes.getBlue();

        // Draw the second part of the text
        page.getCanvas().drawString(text2, font4, brush3, x1, y, format3);

        // Measure the size of the second part of the text
        size = font4.measureString(text2, format3);
        x1 = x1 + size.getWidth();

        // Draw the third part of the text
        page.getCanvas().drawString(text3, font3, brush2, x1, y, format3);

        // Update the y-coordinate
        y = y + size.getHeight();

        // Set up the format for the main body of text
        PdfStringFormat format4 = new PdfStringFormat();
        text = txt2String(new File("data/summary_of_Science.txt"));
        PdfTrueTypeFont font5 = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 10));
        format4.setLineSpacing(font5.getSize() * 1.5f);

        // Layout the text within a specified area
        PdfStringLayouter textLayouter = new PdfStringLayouter();
        double imageLeftBlockHeight = imageBottom - y;
        PdfStringLayoutResult result = textLayouter.layout(text, font5, format4, new Dimension((int)imageLeftSpace, (int)imageLeftBlockHeight));

        // Adjust the layout if the calculated height is smaller than the available space
        if (result.getActualSize().getHeight() < imageBottom - y) {
            imageLeftBlockHeight = imageLeftBlockHeight + result.getLineHeight();
            result = textLayouter.layout(text, font5, format4, new Dimension((int)imageLeftSpace, (int)imageLeftBlockHeight));
        }
        // Draw each line of the layout result
        for (int i = 0; i < result.getLines().length; i++) {
            LineInfo line = result.getLines()[i];
            page.getCanvas().drawString(line.getText(), font5, brush2, 0, y, format4);
            y = y + result.getLineHeight();
        }

        // Create a text widget for the remaining text
        PdfTextWidget textWidget = new PdfTextWidget(result.getRemainder(), font5, brush2);

        // Set up the text layout options
        PdfTextLayout textLayout = new PdfTextLayout();
        textLayout.setBreak(PdfLayoutBreakType.Fit_Page);
        textLayout.setLayout(PdfLayoutType.Paginate);

        // Define the bounds for the text widget
        Rectangle2D bounds = new Rectangle2D.Double(0, y, page.getCanvas().getClientSize().getWidth(), page.getCanvas().getClientSize().getHeight());

        // Apply the string format to the text widget
        textWidget.setStringFormat(format4);

        // Draw the text widget on the page using specified bounds and layout options
        textWidget.draw(page, bounds, textLayout);
    }

    public static String txt2String(File file) {
        // Create a StringBuilder object to store the file contents
        StringBuilder result = new StringBuilder();

        try {
            // Create a BufferedReader object to read the file
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            // Read each line from the file until the end is reached
            while ((s = br.readLine()) != null) {
                // Append the line to the StringBuilder object, including the system line separator
                result.append(System.lineSeparator() + s);
            }
            // Close the BufferedReader
            br.close();
        } catch (Exception e) {
            // Print the stack trace if an exception occurs during reading the file
            e.printStackTrace();
        }
        // Return the file contents as a string
        return result.toString();
    }
}
