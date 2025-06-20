import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.geom.*;

public class modifyPageMargins {
    public static void main(String[] args) {
        // Create a PdfDocument object to load the original document
        PdfDocument doc = new PdfDocument();

        // Load the PDF document from the file "data/modifyPageMargins.pdf"
        doc.loadFromFile("data/modifyPageMargins.pdf");

        // Create a new PdfDocument object to hold the modified document
        PdfDocument newDoc = new PdfDocument();

        // Define the desired top, bottom, left, and right margins
        float top = 50;
        float bottom = 50;
        float left = 50;
        float right = 50;

        // Iterate through each page of the original document
        for (int i = 0; i < doc.getPages().getCount(); i++) {
            // Get the current page from the original document
            PdfPageBase page = doc.getPages().get(i);

            // Create a new page in the modified document with adjusted margins
            PdfPageBase newPage = newDoc.getPages().add(page.getSize(), new PdfMargins(0));

            // Scale the content of the original page to fit within the adjusted margins
            newPage.getCanvas().scaleTransform((page.getActualSize().getWidth() - left - right) / page.getActualSize().getWidth(),
                    (page.getActualSize().getHeight() - top - bottom) / page.getActualSize().getHeight());

            // Draw the scaled content onto the new page
            newPage.getCanvas().drawTemplate(page.createTemplate(), new Point2D.Float(left, top));
        }

        // Specify the output file path for the modified PDF document
        String output = "output/modifyPageMargins.pdf";

        // Save the modified document to a new PDF file
        newDoc.saveToFile(output, FileFormat.PDF);

        // Close and dispose of system resources associated with the original document
        doc.close();
        doc.dispose();

        // Close and dispose of system resources associated with the modified document
        newDoc.close();
        newDoc.dispose();
    }
}
