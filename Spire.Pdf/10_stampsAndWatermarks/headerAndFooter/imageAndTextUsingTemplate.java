import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class imageAndTextUsingTemplate {
    public static void main(String[] args) {
       // Input and output file paths
        String input1 = "data/headerAndFooter.pdf";
        String input2 = "data/E-iceblueLogo.png";
        String output = "output/imageAndTextUsingTemplate.pdf";

        // Load the PDF document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input1);

        // Get the first page of the document
        PdfPageBase page = doc.getPages().get(0);

        // Get the margin settings of the document
        PdfMargins margin = doc.getPageSettings().getMargins();

        // Set the font and brush for the header and footer text
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Impact", Font.PLAIN, 14));
        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.GRAY));

        // Load the image from file
        PdfImage image = PdfImage.fromFile(input2);

        // Calculate the size of the image
        Dimension2D imageSize = new Dimension();
        imageSize.setSize(image.getWidth() / 2, image.getHeight() / 2);

        // Create a template for the header section
        PdfTemplate headerTemplate = new PdfTemplate(page.getActualSize().getWidth() - margin.getLeft() - margin.getRight(), imageSize.getHeight());

        // Draw the image onto the header template
        headerTemplate.getGraphics().drawImage(image, new Point2D.Float(0, 0), imageSize);

        // Create a rectangle for the header text
        Rectangle2D rect = new Rectangle2D.Float();
        rect.setFrame(headerTemplate.getBounds());

        // Define the string format for the header text
        PdfStringFormat format1 = new PdfStringFormat(PdfTextAlignment.Right, PdfVerticalAlignment.Middle);

        // Draw the header text onto the header template
        headerTemplate.getGraphics().drawString("Header", font, brush, rect, format1);

        // Create a template for the footer section
        PdfTemplate footerTemplate = new PdfTemplate(page.getActualSize().getWidth() - margin.getLeft() - margin.getRight(), imageSize.getHeight());

        // Define the string format for the footer text
        PdfStringFormat format2 = new PdfStringFormat(PdfTextAlignment.Center, PdfVerticalAlignment.Middle);

        // Draw the footer text onto the footer template
        footerTemplate.getGraphics().drawString("Footer", font, brush, rect, format2);

        // Position the header template on the page and draw it
        float x = margin.getLeft();
        float y = 0;
        page.getCanvas().drawTemplate(headerTemplate, new Point2D.Float(x, y));

        // Position the footer template on the page and draw it
        y = (float) page.getActualSize().getHeight() - footerTemplate.getHeight() - 10;
        page.getCanvas().drawTemplate(footerTemplate, new Point2D.Float(x, y));

        // Save the modified PDF document to the output file
        doc.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
