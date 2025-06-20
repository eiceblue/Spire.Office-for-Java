import com.spire.doc.*;

public class DocToWPS {
    public static void main(String[] args) {
        // Create a new Document object
        Document document = new Document();

        // Load a document from the specified file
        document.loadFromFile("data/Sample.docx");

        // Save the document to a WPS file format
        document.saveToFile("output/DocToWPS.wps", FileFormat.Wps);

        // Dispose of the document resources
        document.dispose();
    }
}
