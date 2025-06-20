import com.spire.pdf.*;

public class toDoc {
    public static void main(String[] args) {
        String input = "data/JavaPDFSample_1.pdf";
        String output = "output/toDoc_out.doc";

        // Create a new PdfDocument
        PdfDocument doc = new PdfDocument();

        // Load the PDF document from the input file
        doc.loadFromFile(input);

        // Save the loaded document as a Word document to the specified output file
        doc.saveToFile(output, FileFormat.DOC);

        // Close the document
        doc.close();

        // Dispose of the resources used by the document
        doc.dispose();
    }
}
