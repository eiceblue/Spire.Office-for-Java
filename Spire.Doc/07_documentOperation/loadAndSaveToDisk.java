import com.spire.doc.*;
public class loadAndSaveToDisk {
    public static void main(String[] args) {
        // Specify the input file path.
        String input = "data/Template.docx";

        // Create a new Document object.
        Document doc = new Document();

        // Load the document content from the specified input file.
        doc.loadFromFile(input);

        // Specify the output file path.
        String result = "output/loadAndSaveToDisk_out.docx";

        // Save the loaded document to the specified output file in the Docx format.
        doc.saveToFile(result, FileFormat.Docx);

        // Dispose the doc object to release resources
        doc.dispose();
    }
}
