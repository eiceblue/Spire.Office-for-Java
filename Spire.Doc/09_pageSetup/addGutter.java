import com.spire.doc.*;
import java.io.IOException;

public class addGutter {
    public static void main(String[] args) throws IOException {
        // Specify the input file path
        String input = "data/addGutter.docx";

        // Specify the output file path
        String output = "output/addGutter_output.docx";

        // Create a new Document object
        Document document = new Document();

        // Load an existing document from the specified input file path
        document.loadFromFile(input);

        // Get the first section of the document
        Section section = document.getSections().get(0);

        // Set the gutter size to 100f (units in points)
        section.getPageSetup().setGutter(100f);

        // Save the modified document to the specified output file path in Docx format
        document.saveToFile(output, FileFormat.Docx);

        // Dispose the document object to release resources
        document.dispose();
    }
}
