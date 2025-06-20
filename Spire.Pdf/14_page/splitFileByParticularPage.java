import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.geom.*;

public class splitFileByParticularPage {
    public static void main(String[] args) {
        // Load the original PDF document
        PdfDocument oldPdf = new PdfDocument();
        oldPdf.loadFromFile("data/sample.pdf");

        // Create a new PDF document for storing the selected pages
        PdfDocument newPdf = new PdfDocument();

        PdfPageBase page;

        // Iterate through the desired page range (1 to 2 in this example)
        for (int i = 1; i < 3; i++) {
            // Add a new page to the new document with the same size as the original page
            page = newPdf.getPages().add(oldPdf.getPages().get(i).getSize(), new PdfMargins(0));

            // Draw the content of the original page onto the new page using a template
            oldPdf.getPages().get(i).createTemplate().draw(page, new Point2D.Float(0, 0));
        }

        // Specify the output file path
        String output = "output/splitFileByParticularPage.pdf";

        // Save the modified document to the specified output file in PDF format
        newPdf.saveToFile(output, FileFormat.PDF);

        // Close both the input and output documents
        oldPdf.close();
        newPdf.close();

        // Dispose of the PDF documents to free up system resources
        oldPdf.dispose();
        newPdf.dispose();
    }
}
