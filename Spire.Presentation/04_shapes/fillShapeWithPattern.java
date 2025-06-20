import com.spire.presentation.*;
import com.spire.presentation.drawing.*;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class fillShapeWithPattern {
    public static void main(String[] args) throws Exception {
        //Create a PPT document
        Presentation presentation = new Presentation();

        //Get the first slide
        ISlide slide = presentation.getSlides().get(0);

        //Add a rectangle
        Rectangle2D rect = new Rectangle2D.Double(presentation.getSlideSize().getSize().getWidth() / 2 - 50, 100, 100, 100);
        IAutoShape shape = slide.getShapes().appendShape(ShapeType.RECTANGLE, rect);

        //Set the pattern fill format
        shape.getFill().setFillType( FillFormatType.PATTERN);
        shape.getFill().getPattern().setPatternType( PatternFillType.TRELLIS);
        shape.getFill().getPattern().getBackgroundColor().setColor( Color.darkGray);
        shape.getFill().getPattern().getForegroundColor().setColor( Color.yellow);

        //Set the fill format of line
        shape.getLine().setFillType(FillFormatType.SOLID);
        shape.getLine().getSolidFillColor().setColor(Color.white);

        //Save the document
        String result = "output/fillShapeWithPattern_result.pptx";
        presentation.saveToFile(result, FileFormat.PPTX_2013);
        presentation.dispose();
    }
}
