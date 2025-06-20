import com.spire.pdf.*;

public class insertEmptyPage {
    public static void main(String[] args) {
        // Specify the input and output file paths
        String input = "data/Sample.pdf";
        String output = "output/insertEmptyPage.pdf";

        // Create a PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load an existing PDF document from disk
        doc.loadFromFile(input);

        // Insert a blank page as the second page
        doc.getPages().insert(1);

        // Save the modified document to the output file
        doc.saveToFile(output);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();

    }
}
