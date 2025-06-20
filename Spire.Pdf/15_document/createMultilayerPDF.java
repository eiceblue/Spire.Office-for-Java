import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class createMultilayerPDF {
    public static void main(String[] args) {
        // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Add a new page to the document
        PdfPageBase page = doc.getPages().add();

        // Specify the text to be displayed
        String text = "Welcome to evaluate Spire.PDF for Java!";

        // Specify the text format (alignment)
        PdfStringFormat format = new PdfStringFormat(PdfTextAlignment.Left);

        // Specify the brush (color) for the text
        PdfSolidBrush brush = new PdfSolidBrush(new PdfRGBColor(Color.BLACK));

        // Specify the font for the text
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Calibri", Font.BOLD, 15));

        // Specify the coordinates (x, y) where the text will be drawn on the page
        float x = 50;
        float y = 50;

        // Draw the text on the page using the specified font, brush, coordinates, and format
        page.getCanvas().drawString(text, font, brush, new Point2D.Float(x, y), format);

        // Measure the size of two separate portions of the text
        Dimension2D size1 = font.measureString("Welcome to evaluate", format);
        Dimension2D size2 = font.measureString("Spire.PDF for Java", format);

        // Load an image from the specified file
        PdfImage image = PdfImage.fromFile("data/multilayerImage.png");

        // Draw the image on the page, positioned next to the first portion of the text
        page.getCanvas().drawImage(image, new Point2D.Float((float)(x + size1.getWidth()), y), size2);

        // Specify the output file path and name
        String output = "output/createMultilayerPDF.pdf";

        // Save the generated PDF document to the specified output file
        doc.saveToFile(output, FileFormat.PDF);

        // Close the document
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
