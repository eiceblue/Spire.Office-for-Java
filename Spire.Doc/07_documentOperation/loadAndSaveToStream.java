import com.spire.doc.*;
import java.io.*;

public class loadAndSaveToStream {
    public static void main(String[] args) throws Exception {
        // Specify the input file path
        String input = "data/Template.docx";

        // Specify the output file path
        String result = "output/loadAndSaveToStream_out.rtf";

        // Create an input stream to read the input file
        InputStream stream = new FileInputStream(input);

        // Create a Document object using the input stream
        Document doc = new Document(stream);

        // Load the document from the input stream in Docx format
        doc.loadFromStream(stream, FileFormat.Docx);
        stream.close();

        // Perform some operations on the document

        // Create a new File object for the output file
        File outFile = new File(result);

        // Create an output stream to write the document to the output file
        OutputStream newStream = new FileOutputStream(outFile);

        // Save the document to the output stream in Rtf format
        doc.saveToStream(newStream, FileFormat.Rtf);

        // Dispose the doc object to release resources
        doc.dispose();
    }
}
