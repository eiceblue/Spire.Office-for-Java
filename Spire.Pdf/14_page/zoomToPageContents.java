import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.geom.*;

public class zoomToPageContents {
    public static void main(String[] args) {
        // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load the PDF template from the specified file
        doc.loadFromFile("data/pdfTemplate_N.pdf");

        // Create a new PdfDocument object to store the modified document
        PdfDocument newDoc = new PdfDocument();

        // Iterate over each page in the original document
        for (int i = 0; i < doc.getPages().getCount(); i++) {
            // Get the current page from the original document
            PdfPageBase page = doc.getPages().get(i);

            // Add a new page to the new document with A3 size and zero margins
            PdfPageBase newPage = newDoc.getPages().add(PdfPageSize.A3, new PdfMargins(0, 0));

            // Scale the content of the new page to fit the dimensions of the original page
            newPage.getCanvas().scaleTransform(newPage.getActualSize().getWidth() / page.getActualSize().getWidth(),
                    (newPage.getActualSize().getHeight() / page.getActualSize().getHeight()));

            // Draw the content of the original page onto the new page's canvas
            newPage.getCanvas().drawTemplate(page.createTemplate(), new Point2D.Float(0, 0));
        }

        // Specify the output file path for the modified document
        String output = "output/zoomToPageContents.pdf";

        // Save the modified document to the specified output file in PDF format
        newDoc.saveToFile(output, FileFormat.PDF);

        // Close both the input and output documents
        doc.close();
        newDoc.close();

        // Dispose of the PDF documents to free up system resources
        doc.dispose();
        newDoc.dispose();
    }
}
