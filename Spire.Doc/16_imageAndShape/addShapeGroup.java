import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import java.awt.*;

public class addShapeGroup {
    public static void main(String[] args) {
        String output = "output/addShapeGroup.docx";

		// Create a new Document object
		Document doc = new Document();

		// Add a new Section to the document
		Section sec = doc.addSection();

		// Add a Paragraph to the Section
		Paragraph para = sec.addParagraph();

		// Append a ShapeGroup to the Paragraph with specified width and height
		ShapeGroup shapegroup = para.appendShapeGroup(375, 462);
		shapegroup.setHorizontalPosition(180);

		// Calculate X scaling factor
		float X = (float)(shapegroup.getWidth() / 1000.0f);

		// Calculate Y scaling factor
		float Y = (float)(shapegroup.getHeight() / 1000.0f);

		// Create a TextBox with the document
		TextBox txtBox = new TextBox(doc);

		// Set the shape type of the TextBox to Round_Rectangle
		txtBox.setShapeType(ShapeType.Round_Rectangle);

		// Set the width of the TextBox
		txtBox.setWidth(125 / X);

		// Set the height of the TextBox
		txtBox.setHeight(54 / Y);

		// Add a paragraph to the TextBox body
		Paragraph paragraph = txtBox.getBody().addParagraph();

		// Set the horizontal alignment of the TextBox paragraph
		paragraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);

		// Append text to the TextBox paragraph
		paragraph.appendText("Start");

		// Set the horizontal position of the TextBox
		txtBox.setHorizontalPosition(19/ X);

		// Set the vertical position of the TextBox
		txtBox.setVerticalPosition(27 / Y);

		// Set the line color of the TextBox
		txtBox.getFormat().setLineColor(Color.GREEN);

		// Add the TextBox to the child objects of the ShapeGroup
		shapegroup.getChildObjects().add(txtBox);

		// Create a ShapeObject with the document using Down_Arrow shape type
		ShapeObject arrowLineShape = new ShapeObject(doc, ShapeType.Down_Arrow);

		// Set the width of the arrow shape
		arrowLineShape.setWidth(16 / X);

		// Set the height of the arrow shape
		arrowLineShape.setHeight(40 / Y);

		// Set the horizontal position of the arrow shape
		arrowLineShape.setHorizontalPosition(69 / X);

		// Set the vertical position of the arrow shape
		arrowLineShape.setVerticalPosition(87 / Y);

		// Set the stroke color of the arrow shape
		arrowLineShape.setStrokeColor(Color.PINK);

		// Add the arrow shape to the child objects of the ShapeGroup
		shapegroup.getChildObjects().add(arrowLineShape);

		// Repeat the above steps with different values to create additional TextBoxes and shapes
        txtBox = new TextBox(doc);
        txtBox.setShapeType(ShapeType.Rectangle);
        txtBox.setWidth(125 / X);
        txtBox.setHeight(54 / Y);
        paragraph = txtBox.getBody().addParagraph();
        paragraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
        paragraph.appendText("Step 1");
        txtBox.setHorizontalPosition(19/ X);
        txtBox.setVerticalPosition( 131/ Y);
        txtBox.getFormat().setLineColor(Color.BLUE);
        shapegroup.getChildObjects().add(txtBox);

        arrowLineShape = new ShapeObject(doc, ShapeType.Down_Arrow);
        arrowLineShape.setWidth(16 / X);
        arrowLineShape.setHeight(40 / Y);
        arrowLineShape.setHorizontalPosition(69 / X);
        arrowLineShape.setVerticalPosition(192 / Y);
        arrowLineShape.setStrokeColor(Color.PINK);
        shapegroup.getChildObjects().add(arrowLineShape);

        txtBox = new TextBox(doc);
        txtBox.setShapeType(ShapeType.Parallelogram);
        txtBox.setWidth(149 / X);
        txtBox.setHeight(59/ Y);
        paragraph = txtBox.getBody().addParagraph();
        paragraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
        paragraph.appendText("Step 2");
        txtBox.setHorizontalPosition(7 / X);
        txtBox.setVerticalPosition(236/ Y);
        txtBox.getFormat().setLineColor(Color.MAGENTA);
        shapegroup.getChildObjects().add(txtBox);

        arrowLineShape = new ShapeObject(doc, ShapeType.Down_Arrow);
        arrowLineShape.setWidth(16 / X);
        arrowLineShape.setHeight(40/ Y);
        arrowLineShape.setHorizontalPosition(66 / X);
        arrowLineShape.setVerticalPosition(300 / Y);
        arrowLineShape.setStrokeColor(Color.PINK);
        shapegroup.getChildObjects().add(arrowLineShape);

        txtBox = new TextBox(doc);
        txtBox.setShapeType(ShapeType.Rectangle);
        txtBox.setWidth( 125 / X);
        txtBox.setHeight(54 / Y);
        paragraph = txtBox.getBody().addParagraph();
        paragraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
        paragraph.appendText("Step 3");
        txtBox.setHorizontalPosition(19 / X);
        txtBox.setVerticalPosition(345 / Y);
        txtBox.getFormat().setLineColor(Color.BLUE);
        shapegroup.getChildObjects().add(txtBox);

		// Save the modified document to the specified output file in Docx format
        doc.saveToFile(output, FileFormat.Docx);

		// Clean up resources associated with the document
		doc.dispose();
    }
}
