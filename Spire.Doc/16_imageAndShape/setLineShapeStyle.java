import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.ShapeObject;
import java.awt.*;
import java.awt.*;

public class setLineShapeStyle {
    public static void main(String[] args) {
	// Create a new Document object
	Document document = new Document();

	// Add a section to the document
	Section section = document.addSection();

	// Add a paragraph to the section
	Paragraph paragraph = section.addParagraph();

	// Append a shape (line) to the paragraph with specified dimensions and type
	ShapeObject shape = paragraph.appendShape(100, 100, ShapeType.Action_Button_Blank);

	// Set the fill color of the shape to orange
	shape.getFill().setColor(Color.orange);

	// Set the stroke color of the shape to black
	shape.setStrokeColor(Color.black);

	// Set the line style of the shape to single
	shape.setLineStyle(ShapeLineStyle.Single);

	// Set the line dashing style of the shape to long dash dot dot GEL
	shape.setLineDashing(LineDashing.Long_Dash_Dot_Dot_GEL);

	// Save the document to the output file in Docx format
	document.saveToFile("output/setLineShapeStyle.docx", FileFormat.Docx);

	// Dispose of the document object to release resources
	document.dispose();
    }
}
