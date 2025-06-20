import com.spire.pdf.*;

public class removeDocumentJavaScript {
    public static void main(String[] args) {
        // Specify the input PDF file path
        String input = "data/documentJavascript.pdf";

        // Specify the output PDF file path after removing JavaScript
        String output = "output/removeDocumentJavascript.pdf";

        // Create a new instance of PdfDocument
        PdfDocument doc = new PdfDocument();

        // Load the PDF document from the specified input file
        doc.loadFromFile(input);

        // Remove any JavaScript code present in the document
        doc.removeDocumentJavaScript();

        // Save the modified PDF document to the specified output file with the PDF format
        doc.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
