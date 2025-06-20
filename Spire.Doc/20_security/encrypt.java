import com.spire.doc.*;

public class encrypt {
    public static void main(String[] args) {
        String inputFile = "data/encrypt.docx";
        String outputFile = "output/encrypt_out.docx";

        // Create a new document object
        Document document = new Document();

        // Load the document from the specified input file
        document.loadFromFile(inputFile);

        // Encrypt the document with the specified password
        document.encrypt("E-iceblue");

        // Save the encrypted document to the specified output file in DOCX format
        document.saveToFile(outputFile, FileFormat.Docx);

        // Dispose the document resources
        document.dispose();
    }
}
