import com.spire.pdf.PdfDocument;
import com.spire.pdf.attachments.*;

public class deleteAllAttachments {
    public static void main(String[] args) {
		// Create a new PdfDocument object
        PdfDocument doc = new PdfDocument();

        // Load an existing PDF document from the specified file
        doc.loadFromFile("data/deleteAllAttachments.pdf");

        // Get the collection of attachments in the document
        PdfAttachmentCollection attachments = doc.getAttachments();

        // Delete all attachments by clearing the collection
        attachments.clear();

        // Save the modified document to a file named "deleteAllAttachments.pdf" in the "output" folder
        doc.saveToFile("output/deleteAllAttachments.pdf");

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();

    }
}
