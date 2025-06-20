import com.spire.doc.*;

public class WPSToDoc {
    public static void main(String[] args) {
        // Create a new Document object
        Document document = new Document();

        // Load the WPS document from the specified file ("data/Sample.wps")
        document.loadFromFile("data/Sample.wps");

        // Save the loaded document to the specified output file ("output/WPSToDoc.doc") in Doc format
        document.saveToFile("output/WPSToDoc.doc", FileFormat.Doc);

        // Clean up resources and release memory used by the Document object
        document.dispose();
    }
}
