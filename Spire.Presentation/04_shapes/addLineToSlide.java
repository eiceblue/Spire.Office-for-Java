import com.spire.presentation.*;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class addLineToSlide {
    public static void main(String[] args) throws Exception {
        //Create a PPT document
        Presentation presentation = new Presentation();

        //Get the first slide
        ISlide slide = presentation.getSlides().get(0);

        //Add a line in the slide
        IAutoShape line=slide.getShapes().appendShape(ShapeType.LINE, new Rectangle2D.Double(50, 100, 300, 0));

        //Set color of the line
        line.getShapeStyle().getLineColor().setColor(Color.red);

        //Save the document
        String result = "output/addLineToSlide_result.pptx";
        presentation.saveToFile(result, FileFormat.PPTX_2013);
        presentation.dispose();
    }
}
