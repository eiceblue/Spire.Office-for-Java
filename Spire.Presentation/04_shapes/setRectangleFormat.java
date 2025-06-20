import com.spire.presentation.*;
import com.spire.presentation.drawing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class setRectangleFormat {
    public static void main(String[] args) throws Exception{
        String output = "output/setRectangleFormat.pptx";

        //create a PPT document
        Presentation presentation = new Presentation();

        //add a shape
        Rectangle2D rect = new Rectangle2D.Float((float) presentation.getSlideSize().getSize().getWidth()/ 2 - 100, 100, 200, 100);
        IAutoShape shape = presentation.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, rect);

        //set the fill format of shape
        shape.getFill().setFillType(FillFormatType.SOLID);
        shape.getFill().getSolidColor().setColor(Color.BLUE);

        //set the fill format of line
        shape.getLine().setFillType(FillFormatType.SOLID);
        shape.getLine().getSolidFillColor().setColor(Color.DARK_GRAY);

        //save the document
        presentation.saveToFile(output, FileFormat.PPTX_2013);
    }
}
