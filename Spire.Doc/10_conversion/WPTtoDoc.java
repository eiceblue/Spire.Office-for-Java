import com.spire.doc.*;

public class WPTtoDoc {
    public static void main(String[] args) {
        // Create a new Document object
        Document document = new Document();

        // Load the WPT document from the specified file ("data/Sample.wpt")
        document.loadFromFile("data/Sample.wpt");

        // Save the loaded document to the specified output file ("output/WPTtoDoc.doc") in Doc format
        document.saveToFile("output/WPTtoDoc.doc", FileFormat.Doc);

        // Clean up resources and release memory used by the Document object
        document.dispose();
    }
}
