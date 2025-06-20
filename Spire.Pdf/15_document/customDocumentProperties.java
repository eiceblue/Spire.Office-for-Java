import com.spire.pdf.*;

public class customDocumentProperties {
    public static void main(String[] args) {
        // Input file path
        String input = "data/JavaPDFSample_1.pdf";

        // Output file path
        String result = "output/customDocumentProperties_out.pdf";

        // Create a new PdfDocument instance
        PdfDocument doc = new PdfDocument();

        // Load the PDF document from the input file
        doc.loadFromFile(input);

        // Set custom document properties
        doc.getDocumentInformation().setCustomProperty("Company", "E-iceblue");
        doc.getDocumentInformation().setCustomProperty("Component", "Spire.PDF for .NET");
        doc.getDocumentInformation().setCustomProperty("Name", "Daisy");
        doc.getDocumentInformation().setCustomProperty("Team", "SalesTeam");

        // Save the modified document to the output file
        doc.saveToFile(result, FileFormat.PDF);

        // Close the document
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();
    }
}
