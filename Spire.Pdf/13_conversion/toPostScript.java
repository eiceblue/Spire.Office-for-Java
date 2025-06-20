import com.spire.pdf.*;

public class toPostScript {
    public static void main(String[] args) {
        String input = "data/JavaPDFSample_1.pdf";
        String output = "output/toPostScript_out.ps";

        // Create a new PdfDocument
        PdfDocument doc = new PdfDocument();

        // Load the PDF document from the input file
        doc.loadFromFile(input);

        // Convert Pdf to PostScript file
        doc.saveToFile(output, FileFormat.POSTSCRIPT);

        // Close the original document
        doc.close();

        // Dispose of the resources used by the document
        doc.dispose();
    }
}
