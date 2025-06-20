import com.spire.presentation.*;
import com.spire.presentation.drawing.FillFormatType;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class setLineJoinStyles {
    public static void main(String[] args) throws Exception {
        //Create a PPT document
        Presentation presentation = new Presentation();

        //Get the first slide
        ISlide slide = presentation.getSlides().get(0);

        //Add three shapes
        IAutoShape shape1 = slide.getShapes().appendShape(ShapeType.RECTANGLE, new Rectangle2D.Double(50, 150, 150, 50));
        IAutoShape shape2 = slide.getShapes().appendShape(ShapeType.RECTANGLE, new Rectangle2D.Double(250, 150, 150, 50));
        IAutoShape shape3 = slide.getShapes().appendShape(ShapeType.RECTANGLE, new Rectangle2D.Double(450, 150, 150, 50));

        //Fill shapes
        shape1.getFill().setFillType(FillFormatType.SOLID);
        shape1.getFill().getSolidColor().setColor(Color.pink);
        shape2.getFill().setFillType(FillFormatType.SOLID);
        shape2.getFill().getSolidColor().setColor(Color.pink);
        shape3.getFill().setFillType(FillFormatType.SOLID);
        shape3.getFill().getSolidColor().setColor(Color.pink);

        //Fill lines of shapes
        shape1.getLine().setFillType(FillFormatType.SOLID);
        shape1.getLine().getSolidFillColor().setColor(Color.gray);
        shape2.getLine().setFillType(FillFormatType.SOLID);
        shape2.getLine().getSolidFillColor().setColor(Color.gray);
        shape3.getLine().setFillType(FillFormatType.SOLID);
        shape3.getLine().getSolidFillColor().setColor(Color.gray);

        //Set the line width
        shape1.getLine().setWidth(10);
        shape2.getLine().setWidth(10);
        shape3.getLine().setWidth(10);

        //Set the join styles of lines
        shape1.getLine().setJoinStyle(LineJoinType.BEVEL);
        shape2.getLine().setJoinStyle(LineJoinType.MITER);
        shape3.getLine().setJoinStyle(LineJoinType.ROUND);

        //Add text in shapes
        shape1.getTextFrame().setText("Bevel Join Style");
        shape2.getTextFrame().setText("Miter Join Style");
        shape3.getTextFrame().setText("Round Join Style");

        //Save the document
        String result = "output/setLineJoinStyles_result.pptx";
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
