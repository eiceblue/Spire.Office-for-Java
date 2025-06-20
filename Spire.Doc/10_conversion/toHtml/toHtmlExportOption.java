import com.spire.doc.*;

public class toHtmlExportOption {
    public static void main(String[] args) {
        // Create a new Document object
        Document document = new Document();

        // Load a Word document from a file
        document.loadFromFile("data/ToHtmlTemplate.docx");

        // Enable embedding images in the HTML output
        document.getHtmlExportOptions().setImageEmbedded(true);

        // Set the CSS style sheet type to internal
        document.getHtmlExportOptions().setCssStyleSheetType(CssStyleSheetType.Internal);

        // Save the document as HTML with the specified file name and format
        document.saveToFile("output/toHtmlExportOption.html", FileFormat.Html);

        // Dispose of the Document object to release resources
        document.dispose();
    }
}
