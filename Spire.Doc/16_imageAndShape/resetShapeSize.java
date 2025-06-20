import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;

public class resetShapeSize {
    public static void main(String[] args) {
        String input="data/shapes.docx";
        String output="output/resetShapeSize.docx";

		// Create a new Document object
		Document doc = new Document();

		// Load the document from the input file
		doc.loadFromFile(input);

		// Get the first section of the document
		Section section = doc.getSections().get(0);

		// Get the first paragraph of the section
		Paragraph para = section.getParagraphs().get(0);

		// Get the second child object of the paragraph and cast it to ShapeObject
		ShapeObject shape = (ShapeObject) para.getChildObjects().get(1);

		// Set the width and height of the shape
		shape.setWidth(200);
		shape.setHeight(200);

		// Save the modified document to the output file
		doc.saveToFile(output, FileFormat.Docx);

		// Clean up resources associated with the document
		doc.dispose();
    }
}
