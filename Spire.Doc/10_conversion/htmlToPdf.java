import com.spire.doc.*;
import com.spire.doc.documents.*;

public class htmlToPdf {
    public static void main(String[] args) {
        // Create a new Document object
        Document document = new Document();

        // Load an HTML file into the document, specifying the file format as Html and XHTML validation type as None
        document.loadFromFile("data/Template_HtmlFile.html", FileFormat.Html, XHTMLValidationType.None);

        // Specify the output file path and name for the generated PDF
        String result = "output/result-HtmlToPdf.pdf";

        // Save the document to the specified file in PDF format
        document.saveToFile(result, FileFormat.PDF);

        // Dispose of the document resources
        document.dispose();
    }
}
