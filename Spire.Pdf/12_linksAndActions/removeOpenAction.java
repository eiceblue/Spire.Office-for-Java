import com.spire.pdf.*;

public class removeOpenAction {
    public static void main(String[] args) {
        // Specify the file paths for the input and output PDF files.
        String input = "data/OpenAction.pdf";
        String output = "output/removeOpenAction.pdf";

        // Create a new instance of the PdfDocument class.
        PdfDocument document = new PdfDocument();

        // Load the PDF document from the input file path.
        document.loadFromFile(input);

        // Set the "AfterOpenAction" property of the document object to null,
        // effectively removing any action that is performed when the PDF document is opened.
        document.setAfterOpenAction(null);

        // Save the modified PDF document to the specified output file path.
        document.saveToFile(output, FileFormat.PDF);

        // Close the PDF document to release resources.
        document.close();

        // Dispose of the PDF document to free up system resources.
        document.dispose();
    }
}
