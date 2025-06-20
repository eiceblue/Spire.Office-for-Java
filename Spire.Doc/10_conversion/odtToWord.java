import com.spire.doc.*;

public class odtToWord {
    public static void main(String[] args) {
        // Create a new Document object
        Document document = new Document();

        // Load an ODT file into the document
        document.loadFromFile("data/Template_OdtFile.odt");

        // Specify the output file path and name for the converted DOCX
        String result = "output/result-OdtToDocOrDocx.docx";

        // Save the document to the specified file in DOCX format
        document.saveToFile(result, FileFormat.Docx);

        // Dispose of the document resources
        document.dispose();
    }
}
