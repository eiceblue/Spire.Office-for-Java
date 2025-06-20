import com.spire.doc.*;

public class toEpub {
    public static void main(String[] args) {
        // Create a new instance of the Document class
        Document doc = new Document();

        // Load a Word document from the specified file path
        doc.loadFromFile("data/ToEpub.doc");

        // Specify the output file path for the converted document
        String result = "output/toEpub.epub";

        // Save the document to the specified file path in EPUB format
        doc.saveToFile(result, FileFormat.E_Pub);

        // Clean up system resources associated with the Document object
        doc.dispose();
    }
}
