import com.spire.pdf.PdfDocument;
import com.spire.pdf.attachments.*;
import java.io.*;

public class getAllAttachments {
    public static void main(String[] args) throws Exception {
		// Create a new PDF document
        PdfDocument pdf = new PdfDocument();

        // Load the PDF document from the specified file
        pdf.loadFromFile("data/template_Pdf_2.pdf");

        // Get the collection of attachments in the PDF document
        PdfAttachmentCollection collection = pdf.getAttachments();

        // Iterate over each attachment in the collection
        for (int i = 0; i < collection.getCount(); i++) {
            // Get the filename of the current attachment
            String fileName = collection.get(i).getFileName();

            // Create a new File object with the filename
            File file = new File(fileName);

            // Create an OutputStream to write the attachment data to the file
            OutputStream output = new FileOutputStream(file);

            // Create a BufferedOutputStream for efficient writing
            BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);

            // Write the attachment data to the file
            bufferedOutput.write(collection.get(i).getData());

            // Close the BufferedOutputStream
            bufferedOutput.close();
        }

        // Close the PDF document to release resources
        pdf.close();

        // Dispose of the PDF document to free up system resources
        pdf.dispose();
    }
}
