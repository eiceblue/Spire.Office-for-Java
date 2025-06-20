import com.spire.doc.*;
import java.io.IOException;

public class setGutterPosition {
    public static void main(String[] args) throws IOException {
        String input = "data/Sample.docx";
        String output = "output/SetGutterPosition.docx";

		// Create a new Document object
		Document document = new Document();

		// Load the document from the specified input file
		document.loadFromFile(input);

		// Get the first section of the document
		Section section = document.getSections().get(0);

		// Set the top gutter to true for the section's page setup
		section.getPageSetup().isTopGutter(true);

		// Set the gutter size to 100f for the section's page setup
		section.getPageSetup().setGutter(100f);

		// Save the document to the specified output file in Docx format
		document.saveToFile(output, FileFormat.Docx);

		// Dispose of the document object to free up resources
		document.dispose();
    }
}
