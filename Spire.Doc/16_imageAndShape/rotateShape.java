import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class rotateShape {
    public static void main(String[] args) {
        String input="data/shapes.docx";
        String output="output/rotateShape.docx";

		// Create a new Document object
		Document doc = new Document();

		// Load the document from the input file
		doc.loadFromFile(input);

		// Get the first section of the document
		Section section = doc.getSections().get(0);

		// Iterate through each paragraph in the section
		for (int i = 0; i < section.getParagraphs().getCount(); i++) {
			// Get the current paragraph
			Paragraph para = section.getParagraphs().get(i);
		  
			// Iterate through each child object in the paragraph
			for (int j = 0; j < para.getChildObjects().getCount(); j++) {
				// Get the current child object
				DocumentObject obj = para.getChildObjects().get(j);
				
				// Check if the child object is a ShapeObject
				if (obj instanceof ShapeObject) {
					// Set the rotation of the ShapeObject to 20.0
					((ShapeObject) obj).setRotation(20.0);
				}
			}
		}

		// Save the modified document to the output file in Docx format
		doc.saveToFile(output, FileFormat.Docx);

		// Dispose of the document object to release resources
		doc.dispose();
    }
}
