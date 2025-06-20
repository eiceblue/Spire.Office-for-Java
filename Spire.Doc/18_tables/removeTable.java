import com.spire.doc.*;

public class removeTable {
    public static void main(String[] args) {
        String input = "data/JAVATemplate_N.docx";

        // Create a new document object
        Document doc = new Document();

        // Load the document from the specified input file
        doc.loadFromFile(input);

        // Get the first section of the document and remove the first table in it
        doc.getSections().get(0).getTables().removeAt(0);

        // Specify the output file path
        String output = "output/RemoveTable.docx";

        // Save the modified document to the output file in DOCX format
        doc.saveToFile(output, FileFormat.Docx);

        // Dispose the document resources
        doc.dispose();
    }
}
