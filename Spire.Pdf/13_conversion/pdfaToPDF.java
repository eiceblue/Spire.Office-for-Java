import com.spire.pdf.*;
import com.spire.pdf.graphics.PdfMargins;
import java.awt.geom.Dimension2D;

public class pdfaToPDF {
    public static void main(String[] args) {
        // Path to the input PDF/A file
        String input = "data/SamplePDFA.pdf";
        // Path to the output regular PDF file
        String output = "output/PDFAToPdf.pdf";

        // Create a new instance of PdfDocument
        PdfDocument doc = new PdfDocument(); 

        // Load the PDF/A file into the PdfDocument object
        doc.loadFromFile(input);

        // Create a new instance of PdfNewDocument
        PdfNewDocument newDoc = new PdfNewDocument();

        // Set the compression level to None
        newDoc.setCompressionLevel(PdfCompressionLevel.None); 

        // Iterate over each page in the loaded document
        for (PdfPageBase page : (Iterable<PdfPageBase>) doc.getPages()) {

            // Get the size of the current page
            Dimension2D size = page.getSize(); 

            // Add a new page to the new document with the same size and zero margins
            PdfPageBase p = newDoc.getPages().add(size, new PdfMargins(0));

            // Draw the contents of the current page onto the new page using a template
            page.createTemplate().draw(p, 0, 0);
        }
        // Save the new document as a regular PDF file
        newDoc.save(output); 
        
        // Close the new document
        newDoc.close(); 

        // Dispose of the resources used by the new document
        newDoc.dispose(); 

    }
}
