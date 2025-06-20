import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class addDifferentHeaders {
    public static void main(String[] args) {
     // Specify the input PDF file path
        String input = "data/deletePage.pdf";

        // Specify the output PDF file path
        String output = "output/addDifferentHeaders.pdf";

        // Create a new PDF document
        PdfDocument doc = new PdfDocument();

        // Load the existing PDF document from the input file
        doc.loadFromFile(input);

        // Define the header texts
        String header1 = "Header 1";
        String header2 = "Header 2";

        // Set the font for the headers
        PdfTrueTypeFont font = new PdfTrueTypeFont(new Font("Arial", Font.BOLD, 15));

        // Set the brush color for drawing the headers
        PdfBrush brush = PdfBrushes.getRed();

        // Define the rectangle for the header area
        Rectangle2D rect = new Rectangle2D.Float();

        // Get the page size of the document
        Dimension2D dimension2D = new Dimension();
        dimension2D.setSize(doc.getPageSettings().getSize().getWidth(), 50f);

        // Set the position and size of the header rectangle
        rect.setFrame(new Point2D.Float(0, 20), dimension2D);

        // Set the text alignment for the header
        PdfStringFormat format = new PdfStringFormat();
        format.setAlignment(PdfTextAlignment.Center);

        // Draw the first header on the first page of the document
        doc.getPages().get(0).getCanvas().drawString(header1, font, brush, rect, format);

        // Change the font and brush for the second header
        font = new PdfTrueTypeFont(new Font("Aleo", Font.PLAIN, 15));
        brush = PdfBrushes.getBlack();

        // Change the text alignment for the second header
        format.setAlignment(PdfTextAlignment.Left);

        // Draw the second header on the second page of the document
        doc.getPages().get(1).getCanvas().drawString(header2, font, brush, rect, format);

        // Save the modified document to the output file in PDF format
        doc.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
