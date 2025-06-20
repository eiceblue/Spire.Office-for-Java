import com.spire.presentation.*;
import com.spire.presentation.drawing.FillFormatType;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class fillShapeWithSolidColor {
    public static void main(String[] args) throws Exception {
        //Create a PPT document
        Presentation presentation = new Presentation();

        //Get the first slide
        ISlide slide = presentation.getSlides().get(0);

        //Add a rectangle
        Rectangle2D rect = new Rectangle2D.Double(presentation.getSlideSize().getSize().getWidth()/ 2 - 50, 100, 100, 100);
        IAutoShape shape = slide.getShapes().appendShape(ShapeType.RECTANGLE, rect);

        //Fill shape with solid color
        shape.getFill().setFillType( FillFormatType.SOLID);
        shape.getFill().getSolidColor().setColor(Color.yellow);

        //Set the fill format of line
        shape.getLine().setFillType(FillFormatType.SOLID);
        shape.getLine().getSolidFillColor().setColor(Color.GRAY);

        //Save the document
        String result = "output/fillShapeWithSolidColor_result.pptx";
        presentation.saveToFile(result, FileFormat.PPTX_2013);
        presentation.dispose();
    }
}
