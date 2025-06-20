import com.spire.pdf.*;
import com.spire.pdf.graphics.*;
import java.awt.*;


public class overlay {
    public static void main(String[] args) {
        // Load the first PDF document
        PdfDocument doc1 = new PdfDocument();
        doc1.loadFromFile("data/overlay1.pdf");

        // Load the second PDF document
        PdfDocument doc2 = new PdfDocument();
        doc2.loadFromFile("data/overlay2.pdf");

        // Create a template from the first page of doc1
        PdfTemplate template = doc1.getPages().get(0).createTemplate();

        // Iterate through each page in doc2
        for (PdfPageBase page : (Iterable<PdfPageBase>) doc2.getPages()) {

            // Set transparency for the page's canvas using overlay blending mode
            page.getCanvas().setTransparency(0.25f, 0.25f, PdfBlendMode.Overlay);

            // Draw the template onto the page's canvas at the top-left corner
            page.getCanvas().drawTemplate(template, new Point());
        }

        // Save the modified PDF document to a file
        doc2.saveToFile("output/overlay.pdf");

        // Close and dispose of the documents
        doc1.close();
        doc2.close();
        doc1.dispose();
        doc2.dispose();
    }
}
