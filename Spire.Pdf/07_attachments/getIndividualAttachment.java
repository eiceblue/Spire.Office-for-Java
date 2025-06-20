
import com.spire.pdf.*;
import com.spire.pdf.attachments.*;

import javax.imageio.stream.FileImageOutputStream;
import java.io.*;

public class getIndividualAttachment {
    public static void main(String[] args) throws IOException {
        // Create a new PDF document
        PdfDocument doc = new PdfDocument();

        // Load the PDF document from the specified file
        doc.loadFromFile("data/deleteAllAttachments.pdf");

        // Get the collection of attachments in the PDF document
        PdfAttachmentCollection attachments = doc.getAttachments();

        // Get the first attachment from the collection
        PdfAttachment attachment = attachments.get(0);

        // Create a FileImageOutputStream with the filename of the attachment
        FileImageOutputStream imageOutput = new FileImageOutputStream(new File(attachment.getFileName()));

        // Write the attachment data to the output stream
        imageOutput.write(attachment.getData(), 0, attachment.getData().length);

        // Close the FileImageOutputStream
        imageOutput.close();

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();

    }
}
