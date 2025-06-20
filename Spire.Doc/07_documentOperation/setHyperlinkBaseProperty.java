import com.spire.doc.*;

public class setHyperlinkBaseProperty {
    public static void main(String[] args) {
        // Specify the input file path
        String input = "data/setHyperlinkBaseProperty.docx";

        // Create a new Document object
        Document doc = new Document();

        // Load an existing document from the specified input file path
        doc.loadFromFile(input);

        // Set the HyperlinkBase property of the document's built-in document properties
        doc.getBuiltinDocumentProperties().setHyperLinkBase("HyperLinkBaseTest");

        // Specify the output file path
        String output = "output/setHyperlinkBaseProperty_result.docx";

        // Save the modified document to the specified output file path in Docx format
        doc.saveToFile(output, FileFormat.Docx);

        // Dispose the doc object to release resources
        doc.dispose();
    }
}
