import com.spire.doc.*;
import com.spire.doc.documents.*;
import com.spire.doc.fields.*;
import java.awt.*;

public class addShapeGroup {
    public static void main(String[] args) {
        String output="output/addShapeGroup.docx";
        //create a document and add a section
        Document doc = new Document();
        Section sec = doc.addSection();

        //add a new paragraph
        Paragraph para = sec.addParagraph();
        //add a shape group with the height and width
        ShapeGroup shapegroup = para.appendShapeGroup(375, 462);
        shapegroup.setHorizontalPosition(180);
        //calculate the scale ratio
        float X = (shapegroup.getWidth() / 1000.0f);
        float Y = (shapegroup.getHeight() / 1000.0f);

        TextBox txtBox = new TextBox(doc);
        txtBox.setShapeType(ShapeType.Round_Rectangle);
        txtBox.setWidth(125 / X);
        txtBox.setHeight(54 / Y);
        Paragraph paragraph = txtBox.getBody().addParagraph();
        paragraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
        paragraph.appendText("Start");
        txtBox.setHorizontalPosition(19 / X);
        txtBox.setVerticalPosition(27 / Y);
        txtBox.getFormat().setLineColor(Color.green);
        shapegroup.getChildObjects().add(txtBox);

        ShapeObject arrowLineShape = new ShapeObject(doc, ShapeType.Down_Arrow);
        arrowLineShape.setWidth(16 / X);
        arrowLineShape.setHeight(40 / Y);
        arrowLineShape.setHorizontalPosition(69 / X);
        arrowLineShape.setVerticalPosition(87 / Y);
        arrowLineShape.setStrokeColor(Color.red);
        shapegroup.getChildObjects().add(arrowLineShape);

        txtBox = new TextBox(doc);
        txtBox.setShapeType(ShapeType.Rectangle);
        txtBox.setWidth(125 / X);
        txtBox.setHeight(54 / Y);
        paragraph = txtBox.getBody().addParagraph();
        paragraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
        paragraph.appendText("Step 1");
        txtBox.setHorizontalPosition(19 / X);
        txtBox.setVerticalPosition(131 / Y);
        txtBox.getFormat().setLineColor(Color.blue);
        shapegroup.getChildObjects().add(txtBox);

        arrowLineShape = new ShapeObject(doc, ShapeType.Down_Arrow);
        arrowLineShape.setWidth(16 / X);
        arrowLineShape.setHeight(40 / Y);
        arrowLineShape.setHorizontalPosition(69 / X);
        arrowLineShape.setVerticalPosition(192 / Y);
        arrowLineShape.setStrokeColor(Color.red);
        shapegroup.getChildObjects().add(arrowLineShape);

        txtBox = new TextBox(doc);
        txtBox.setShapeType(ShapeType.Parallelogram);
        txtBox.setWidth(149 / X);
        txtBox.setHeight(59 / Y);
        paragraph = txtBox.getBody().addParagraph();
        paragraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
        paragraph.appendText("Step 2");
        txtBox.setHorizontalPosition(7 / X);
        txtBox.setVerticalPosition(236 / Y);
        txtBox.getFormat().setLineColor(Color.pink);
        shapegroup.getChildObjects().add(txtBox);

        arrowLineShape = new ShapeObject(doc, ShapeType.Down_Arrow);
        arrowLineShape.setWidth(16 / X);
        arrowLineShape.setHeight(40 / Y);
        arrowLineShape.setHorizontalPosition(66 / X);
        arrowLineShape.setVerticalPosition(300 / Y);
        arrowLineShape.setStrokeColor(Color.red);
        shapegroup.getChildObjects().add(arrowLineShape);

        txtBox = new TextBox(doc);
        txtBox.setShapeType(ShapeType.Rectangle);
        txtBox.setWidth(125 / X);
        txtBox.setHeight(54 / Y);
        paragraph = txtBox.getBody().addParagraph();
        paragraph.getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
        paragraph.appendText("Step 3");
        txtBox.setHorizontalPosition(19 / X);
        txtBox.setVerticalPosition(345 / Y);
        txtBox.getFormat().setLineColor(Color.orange);
        shapegroup.getChildObjects().add(txtBox);

        //save the document
        doc.saveToFile(output, FileFormat.Docx_2010);
    }
}
