import com.spire.doc.*;
import java.io.*;

public class convertDocToByte {
    public static void main(String[] args) {
        // Define the input file path
        String input = "data/Template.docx";

        // Create a new instance of the Document class
        Document doc = new Document();

        // Load the document from the specified input file
        doc.loadFromFile(input);

        // Create a ByteArrayOutputStream to store the document contents
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // Save the document to the OutputStream in Docx format
        doc.saveToStream(outputStream, FileFormat.Docx);

        // Get the byte array representation of the document content
        byte[] docBytes = outputStream.toByteArray();

        // The bytes are now ready to be stored/transmitted.

        // Create a ByteArrayInputStream from the byte array
        ByteArrayInputStream inputStream = new ByteArrayInputStream(docBytes);

        // Create a new Document object from the ByteArrayInputStream
        Document newDoc = new Document(inputStream);
    }
}
