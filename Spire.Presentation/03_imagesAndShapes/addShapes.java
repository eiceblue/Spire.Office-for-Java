import com.spire.presentation.*;
import com.spire.presentation.drawing.FillFormatType;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class addShapes {
    public static void main(String[] args) throws Exception {
        String outputFile = "output/addShapes_result.pptx";
        String imageFile = "data/bg.png";

        //Create PPT document
        Presentation presentation = new Presentation();

        //Set background Image
        Rectangle2D.Double rect = new Rectangle2D.Double(0, 0, presentation.getSlideSize().getSize().getWidth(), presentation.getSlideSize().getSize().getHeight());
        presentation.getSlides().get(0).getShapes().appendEmbedImage(ShapeType.RECTANGLE, imageFile, rect);
        presentation.getSlides().get(0).getShapes().get(0).getLine().getSolidFillColor().setColor(Color.white);

        //Append new shape - Triangle and set style
        IAutoShape shape = presentation.getSlides().get(0).getShapes().appendShape(ShapeType.TRIANGLE, new Rectangle2D.Double(115, 130, 100, 100));

        shape.getFill().setFillType(FillFormatType.SOLID);
        shape.getFill().getSolidColor().setColor(Color.green);
        shape.getShapeStyle().getLineColor().setColor(Color.white);

        //Append new shape - Ellipse
        shape = presentation.getSlides().get(0).getShapes().appendShape(ShapeType.ELLIPSE, new Rectangle2D.Double(290, 130, 150, 100));
        shape.getFill().setFillType(FillFormatType.SOLID);
        shape.getFill().getSolidColor().setColor(Color.blue);
        shape.getShapeStyle().getLineColor().setColor(Color.white);

        //Append new shape - Heart
        shape = presentation.getSlides().get(0).getShapes().appendShape(ShapeType.HEART, new Rectangle2D.Double(470, 130, 130, 100));
        shape.getFill().setFillType(FillFormatType.SOLID);
        shape.getFill().getSolidColor().setColor(Color.red);
        shape.getShapeStyle().getLineColor().setColor(Color.gray);


        //Append new shape - FivePointedStar
        shape = presentation.getSlides().get(0).getShapes().appendShape(ShapeType.FIVE_POINTED_STAR, new Rectangle2D.Double(90, 270, 150, 150));
        shape.getFill().setFillType(FillFormatType.GRADIENT);
        shape.getFill().getSolidColor().setColor(Color.black);
        shape.getShapeStyle().getLineColor().setColor(Color.white);

        //Append new shape - Rectangle
        shape = presentation.getSlides().get(0).getShapes().appendShape(ShapeType.TRIANGLE, new Rectangle2D.Double(320, 290, 100, 120));
        shape.getFill().setFillType(FillFormatType.SOLID);
        shape.getFill().getSolidColor().setColor(Color.pink);
        shape.getShapeStyle().getLineColor().setColor(Color.lightGray);


        //Append new shape - BentUpArrow
        shape = presentation.getSlides().get(0).getShapes().appendShape(ShapeType.BENT_UP_ARROW, new Rectangle2D.Double(470, 300, 150, 100));
        //Set the color of the shape
        shape.getFill().setFillType(FillFormatType.GRADIENT);
        shape.getFill().getGradient().getGradientStops().append(1f, KnownColors.OLIVE);
        shape.getFill().getGradient().getGradientStops().append(0, KnownColors.POWDER_BLUE);
        shape.getShapeStyle().getLineColor().setColor(Color.white);

        //Save the document
        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
    }
}
