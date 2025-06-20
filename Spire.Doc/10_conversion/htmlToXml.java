import com.spire.doc.*;

public class htmlToXml {
    public static void main(String[] args) {
        // Create a new Document object
        Document document = new Document();

        // Load an HTML file into the document
        document.loadFromFile("data/Template_HtmlFile.html");

        // Specify the output file path and name for the generated XML
        String result = "output/result-HtmlToXml.xml";

        // Save the document to the specified file in XML format
        document.saveToFile(result, FileFormat.Xml);

        // Dispose of the document resources
        document.dispose();
    }
}
