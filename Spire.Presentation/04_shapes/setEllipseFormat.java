import com.spire.presentation.*;
import com.spire.presentation.drawing.FillFormatType;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class setEllipseFormat {
    public static void main(String[] args) throws Exception {
        //Create a PPT document
        Presentation presentation = new Presentation();

        //Get the first slide
        ISlide slide = presentation.getSlides().get(0);

        //Add a rectangle
        Rectangle2D rect = new Rectangle2D.Double(presentation.getSlideSize().getSize().getWidth() / 2 - 100, 100, 200, 100);
        IAutoShape shape = slide.getShapes().appendShape(ShapeType.ELLIPSE, rect);

        //Set the fill format of shape
        shape.getFill().setFillType(FillFormatType.SOLID);
        shape.getFill().getSolidColor().setColor(Color.PINK);

        //Set the fill format of line
        shape.getLine().setFillType(FillFormatType.SOLID);
        shape.getLine().getSolidFillColor().setColor(Color.gray);

        //Save the document
        String result = "output/setEllipseFormat_result.pptx";
        presentation.saveToFile(result, FileFormat.PPTX_2013);
        presentation.dispose();
    }
}
