
import com.spire.pdf.*;
import com.spire.pdf.attachments.*;

import java.io.*;

public class getPdfAttachmentInfo {
    public static void main(String[] args) throws IOException {
		// Create a new PDF document
        PdfDocument doc = new PdfDocument();

        // Load the PDF document from the specified file
        doc.loadFromFile("data/deleteAllAttachments.pdf");

        // Get the collection of attachments in the PDF document
        PdfAttachmentCollection attachments = doc.getAttachments();

        // Get the first attachment from the collection
        PdfAttachment attachment = attachments.get(0);

        // Create a StringBuilder to build the content string
        StringBuilder content = new StringBuilder();

        // Append the attachment's filename to the content string
        content.append("Filename: ").append(attachment.getFileName());

        // Append the attachment's description to the content string
        content.append("Description: ").append(attachment.getDescription());

        // Append the attachment's creation date to the content string
        content.append("Creation Date: ").append(attachment.getCreationDate());

        // Append the attachment's modification date to the content string
        content.append("Modification Date: ").append(attachment.getModificationDate());

        // Write the content string to a text file
        writeStringToTxt(content.toString(), "output/getPdfAttachmentInfo.txt");

        // Close the PDF document to release resources
        doc.close();

        // Dispose of the PDF document to free up system resources
        doc.dispose();

    }

    // This method writes the provided content to a text file.
    public static void writeStringToTxt(String content, String txtFileName) throws IOException {
        // Create a FileWriter object with the specified text file name and append mode (true)
        FileWriter fWriter = new FileWriter(txtFileName, true);

        try {
            // Write the content to the file
            fWriter.write(content);
        } catch (IOException ex) {
            // Print the stack trace if an exception occurs during writing
            ex.printStackTrace();
        } finally {
            try {
                // Flush and close the FileWriter
                fWriter.flush();
                fWriter.close();
            } catch (IOException ex) {
                // Print the stack trace if an exception occurs while closing the FileWriter
                ex.printStackTrace();
            }
        }
    }
}
