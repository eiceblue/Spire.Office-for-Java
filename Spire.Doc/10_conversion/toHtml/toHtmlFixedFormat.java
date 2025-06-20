import com.spire.doc.*;

public class toHtmlFixedFormat {
    public static void main(String[] args) {
        // Set the input file path 
        String input = "data/ToHtmlTemplate.docx";

        // Set the output file path
        String output = "output/toHtmlFontEmbedded.html";
        
        // Create a new Document object
        Document document = new Document();

        // Load a Word document from a file
        document.loadFromFile(input);

        // Enable embedding images in the HTML output
        document.getHtmlExportOptions().setImageEmbedded(true);

        // Set the CSS style sheet type to internal
        document.getHtmlExportOptions().setCssStyleSheetType(CssStyleSheetType.Internal);

        // Embed font file
        document.getHtmlExportOptions().setFontEmbedded(true);

        // Saves the document in the HTML format using absolutely positioned elements
        document.saveToFile(output, com.spire.doc.FileFormat.HtmlFixed);

        // Dispose of the Document object to release resources
        document.dispose();
    }
}
