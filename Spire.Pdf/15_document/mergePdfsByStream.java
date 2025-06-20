import com.spire.pdf.*;
import java.io.*;

public class mergePdfsByStream {
    public static void main(String[] args) throws IOException {
        // Create FileInputStream objects for each PDF document file
        FileInputStream stream1 = new FileInputStream(new File("data/mergePdfsTemplate_1.pdf"));
        FileInputStream stream2 = new FileInputStream(new File("data/mergePdfsTemplate_2.pdf"));
        FileInputStream stream3 = new FileInputStream(new File("data/mergePdfsTemplate_3.pdf"));

        // Initialize an array of InputStream objects containing the file input streams
        InputStream[] streams = new FileInputStream[]{stream1, stream2, stream3};

        // Merge the input streams into a single PdfDocumentBase object
        PdfDocumentBase doc = PdfDocument.mergeFiles(streams);

        // Specify the output file path for the merged PDF document
        String output = "output/mergePdfsByStream.pdf";

        // Save the merged document to a new PDF file
        doc.save(output, FileFormat.PDF);

        // Close and dispose of system resources associated with the merged document
        doc.close();
        doc.dispose();

        // Close and dispose of system resources associated with each input stream
        stream1.close();
        stream1.close();
        stream1.close();
    }
}
