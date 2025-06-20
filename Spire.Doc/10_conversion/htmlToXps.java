import com.spire.doc.*;
import com.spire.doc.documents.*;

public class htmlToXps {
    public static void main(String[] args) {
        // Create a new Document object
        Document document = new Document();

        // Load an HTML file into the document, specifying the file format as Html and XHTML validation type as None
        document.loadFromFile("data/Template_HtmlFile.html", FileFormat.Html, XHTMLValidationType.None);

        // Specify the output file path and name for the generated XPS
        String result = "output/result-HtmlToXps.xps";

        // Save the document to the specified file in XPS format
        document.saveToFile(result, FileFormat.XPS);

        // Dispose of the document resources
        document.dispose();
    }
}
