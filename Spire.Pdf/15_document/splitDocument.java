import com.spire.pdf.*;

public class splitDocument {
    public static void main(String[] args) {
        // Create a PdfDocument object and load the PDF document from the file "data/splitDocument.pdf"
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/splitDocument.pdf");

        // Specify the output file pattern for the split pages. The "{0}" placeholder will be replaced with page numbers.
        String output = "output/splitDocument-{0}.pdf";

        // Split the document into individual pages using the specified output file pattern
        doc.split(output, 0);

        // Close and dispose of system resources associated with the document
        doc.close();
        doc.dispose();

    }
}
