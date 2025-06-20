import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import java.awt.*;

public class insertWordArt {
    public static void main(String[] args) {
        String input="data/insertWordArt.docx";
        String output="output/insertWordArt.docx";

		// Create a new Document object
		Document doc = new Document();

		// Load the document from the input file
		doc.loadFromFile(input);

		// Get the first section of the document and add a new paragraph to it
		Paragraph paragraph = doc.getSections().get(0).addParagraph();

		// Append a shape to the paragraph with specified dimensions and shape type (Text_Wave_4)
		ShapeObject shape = paragraph.appendShape(250, 70, ShapeType.Text_Wave_4);

		// Set the vertical and horizontal position of the shape
		shape.setVerticalPosition(20);
		shape.setHorizontalPosition(80);

		// Set the text content of the WordArt in the shape
		shape.getWordArt().setText("Spire.Doc for JAVA");

		// Set the fill color of the shape to red
		shape.setFillColor(Color.RED);

		// Set the stroke color of the shape to yellow
		shape.setStrokeColor(Color.YELLOW);

		// Save the modified document to the output file
		doc.saveToFile(output, FileFormat.Docx);

		// Clean up resources associated with the document
		doc.dispose();
    }
}
