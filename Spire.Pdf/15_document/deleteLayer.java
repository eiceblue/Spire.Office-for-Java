import com.spire.pdf.*;

public class deleteLayer {
    public static void main(String[] args) {
        // Create a new PdfDocument instance
        PdfDocument doc = new PdfDocument();

        // Load the PDF document from the input file
        doc.loadFromFile("data/deleteLayer.pdf");

        // Remove a layer by its name
        doc.getLayers().removeLayer("red line1");

        // Output file path
        String output = "output/deleteLayer.pdf";

        // Save the modified document to the output file
        doc.saveToFile(output, FileFormat.PDF);

        // Close the document
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
