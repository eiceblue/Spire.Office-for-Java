import com.spire.pdf.*;

public class deletePage {
    public static void main(String[] args) {
        // Specify the input and output file paths
        String inputFile = "data/deletePage.pdf";
        String outputFile = "output/deletePage_out.pdf";

        // Load the PDF document
        PdfDocument doc = new PdfDocument(inputFile);

        // Delete the third page
        doc.getPages().removeAt(2);

        // Save the modified document to the output file
        doc.saveToFile(outputFile);

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}

