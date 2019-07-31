import com.spire.pdf.PdfDocument;
import com.spire.pdf.attachments.*;

public class deleteAllAttachments {
    public static void main(String[] args) {
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile("data/deleteAllAttachments.pdf");

        PdfAttachmentCollection attachments = doc.getAttachments();
        //Delete all attachments
        attachments.clear();

        doc.saveToFile("output/deleteAllAttachments.pdf");
        doc.close();

    }
}
