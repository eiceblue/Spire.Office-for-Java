import com.spire.pdf.*;

public class changePdfVersion {
    public static void main(String[] args) {
        // Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load an existing PDF document from the specified file
        doc.loadFromFile("data/changePdfVersion.pdf");

        // Set the PDF version to be 1.6
        doc.getFileInfo().setVersion(PdfVersion.Version_1_6);

        // Specify the output file path and name
        String output = "output/changePdfVersion.pdf";

        // Save the modified PDF document to the specified output file
        doc.saveToFile(output, FileFormat.PDF);

        // Close the input document
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
