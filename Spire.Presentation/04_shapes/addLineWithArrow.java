import com.spire.presentation.*;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class addLineWithArrow {
    public static void main(String[] args) throws Exception {
        String ImageFile = "data/bg.png";
        String outputFile = "output/addLineWithArrow.pptx";

        //Create an instance of presentation document
        Presentation ppt = new Presentation();

        //Set background image
        Rectangle2D rect = new Rectangle2D.Float(0, 0, (float) ppt.getSlideSize().getSize().getWidth(), (float) ppt.getSlideSize().getSize().getHeight());
        ppt.getSlides().get(0).getShapes().appendEmbedImage(ShapeType.RECTANGLE, ImageFile, rect);
        ppt.getSlides().get(0).getShapes().get(0).getLine().getFillFormat().getSolidFillColor().setColor(Color.white);

        //Add a line to the slides and set its color to red
        IAutoShape shape = ppt.getSlides().get(0).getShapes().appendShape(ShapeType.LINE, new Rectangle2D.Float(150, 100, 100, 100));
        shape.getShapeStyle().getLineColor().setColor(Color.red);
        //Set the line end type as StealthArrow
        shape.getLine().setLineEndType(LineEndType.STEALTH_ARROW);

        //Add a line to the slides and use default color
        shape = ppt.getSlides().get(0).getShapes().appendShape(ShapeType.LINE, new Rectangle2D.Float(300, 150, 100, 100));
        shape.setRotation(-45);
        //Set the line end type as TriangleArrowHead
        shape.getLine().setLineEndType(LineEndType.TRIANGLE_ARROW_HEAD);;

        //Add a line to the slides and set its color to green
        shape = ppt.getSlides().get(0).getShapes().appendShape(ShapeType.LINE, new Rectangle2D.Float(450, 100, 100, 100));
        shape.getShapeStyle().getLineColor().setColor(Color.green);
        shape.setRotation(90);
        //Set the line begin type as TriangleArrowHead
        shape.getLine().setLineEndType(LineEndType.STEALTH_ARROW);;

        //Save the document
        ppt.saveToFile(outputFile, FileFormat.PPTX_2013);
        ppt.dispose();
    }
}
