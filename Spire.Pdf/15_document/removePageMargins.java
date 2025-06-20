import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;
import java.awt.geom.*;

public class removePageMargins {
    public static void main(String[] args) {
        // Create a PdfDocument object to load the original document
        PdfDocument doc = new PdfDocument();

        // Load the PDF document from the file "data/pdfTemplate-Az.pdf"
        doc.loadFromFile("data/pdfTemplate-Az.pdf");

        // Create a new document to store the modified pages
        PdfDocument newDoc = new PdfDocument();

        // Get the page margins of the source PDF page
        PdfMargins margins = doc.getPageSettings().getMargins();
        float top = margins.getTop();
        float bottom = margins.getBottom();
        float left = margins.getLeft();
        float right = margins.getRight();

        // Iterate through each page of the source document
        for (int i = 0; i < doc.getPages().getCount(); i++) {
            PdfPageBase page = doc.getPages().get(i);

            // Calculate the size of the trimmed page based on the margins
            Dimension newSize = new Dimension((int) (page.getSize().getWidth() - left - right),
                    (int) (page.getSize().getHeight() - top - bottom));

            // Add a new page to the new document with the trimmed size and no margins
            PdfPageBase newPage = newDoc.getPages().add(newSize, new PdfMargins(0));

            // Draw the content of the source page onto the new document page, adjusting for the removed margins
            newPage.getCanvas().drawTemplate(page.createTemplate(), new Point2D.Float(-left, -top));
        }

        // Specify the output file path for the modified PDF document
        String output = "output/removePageMargins.pdf";

        // Save the modified document to a new PDF file
        newDoc.saveToFile(output);

        // Close and dispose of system resources associated with the documents
        doc.close();
        doc.dispose();
        newDoc.close();
        newDoc.dispose();
    }
}
