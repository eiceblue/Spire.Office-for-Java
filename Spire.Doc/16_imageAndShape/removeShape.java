import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class removeShape {
    public static void main(String[] args) {
        String input="data/shapes.docx";
        String output="output/removeShape.docx";

		// Load a Word document
		Document doc = new Document();

		// Load the document from the input file
		doc.loadFromFile(input);

		// Get the first section of the document
		Section section = doc.getSections().get(0);

		// Traverse all child objects of each paragraph in the section
		for (int j = 0; j < section.getParagraphs().getCount(); j++) {
			Paragraph para = section.getParagraphs().get(j);
			for (int i = 0; i < para.getChildObjects().getCount(); i++) {
				// Check if the child object is a ShapeObject
				if (para.getChildObjects().get(i) instanceof ShapeObject) {
					// Remove the ShapeObject from the paragraph's child objects
					para.getChildObjects().removeAt(i);
				}
			}
		}

		// Save the modified document to the output file
		doc.saveToFile(output, FileFormat.Docx);

		// Clean up resources associated with the document
		doc.dispose();
    }
}
