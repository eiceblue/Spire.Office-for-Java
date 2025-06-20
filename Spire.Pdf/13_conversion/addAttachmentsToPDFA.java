import com.spire.pdf.*;
import com.spire.pdf.attachments.PdfAttachment;
import com.spire.pdf.graphics.PdfMargins;
import java.awt.geom.Dimension2D;
import java.io.*;

public class addAttachmentsToPDFA {
    public static void main(String[] args) throws IOException {
        // Input file path
        String input = "data/JavaPDFSample_1.pdf";
        // Output file path with added attachments
        String output = "output/addAttachmentsToPDFA.pdf";

        // Load the input PDF document
        PdfDocument doc = new PdfDocument();
        doc.loadFromFile(input);

        // Create a new PDF document with PDF/A-1b conformance level
        PdfNewDocument newDoc = new PdfNewDocument();
        newDoc.setConformance(PdfConformanceLevel.Pdf_A_1_B);

        // Iterate through each page of the input document
        for (PdfPageBase page : (Iterable<PdfPageBase>) doc.getPages()) {
            // Get the size of the current page
            Dimension2D size = page.getSize();
            // Add a new page to the new document with the same size as the current page
            PdfPageBase p = newDoc.getPages().add(size, new PdfMargins(0));
            // Draw the content of the current page onto the new page
            page.createTemplate().draw(p, 0, 0);
        }

        // Read the data from the attachment files
        byte[] data1 = readBytesFromFile("data/scenery.jpg");
        byte[] data2 = readBytesFromFile("data/Sample.pdf");

        // Create two PDF attachments
        PdfAttachment attach1 = new PdfAttachment("attachment1.png", data1);
        PdfAttachment attach2 = new PdfAttachment("attachment2.pdf", data2);

        // Add the attachments to the new document
        newDoc.getAttachments().add(attach1);
        newDoc.getAttachments().add(attach2);

        // Save the new document with added attachments to the output file
        newDoc.save(output, FileFormat.PDF);

        // Close and release resources of the input document
        doc.close();
        doc.dispose();

        // Close and release resources of the new document
        newDoc.close();
        newDoc.dispose();
    }
	
	
    private static byte[] readBytesFromFile(String filePath) throws IOException {
        // Create a FileInputStream object to read the file.
        FileInputStream input = new FileInputStream(filePath);

        // Create a byte array with the size equal to the number of available bytes in the input stream.
        byte[] b = new byte[input.available()];

        // Read the contents of the file into the byte array.
        input.read(b);

        // Close the FileInputStream.
        input.close();

        // Return the byte array containing the file contents.
        return b;
    }
}
