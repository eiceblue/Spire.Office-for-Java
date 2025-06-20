import com.spire.doc.*;

public class toOdt {
    public static void main(String[] args) {
        // Define the input file path for the Word document to be converted
        String input = "data/Sample.docx";

        // Define the output file path for the converted document in the ODT format
        String output = "output/toOdt.odt";

        // Create a new instance of the Document class
        Document document = new Document();

        // Load the Word document from the specified input file path
        document.loadFromFile(input);

        // Save the loaded document to the specified output file path in the ODT format
        document.saveToFile(output, FileFormat.Odt);

        // Dispose of the document object to release system resources
        document.dispose();
    }
}
