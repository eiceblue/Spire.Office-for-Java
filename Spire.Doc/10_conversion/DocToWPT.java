import com.spire.doc.*;

public class DocToWPT {
    public static void main(String[] args) {
        // Create a new Document object
        Document document = new Document();

        // Load a document from the specified file
        document.loadFromFile("data/Sample.docx");

        // Save the document to a WPT file format
        document.saveToFile("output/DocToWPT.wpt", FileFormat.Wpt);

        // Dispose of the document resources
        document.dispose();
    }
}
