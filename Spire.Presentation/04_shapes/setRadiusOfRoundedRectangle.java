import com.spire.presentation.*;
import com.spire.presentation.drawing.*;
import java.awt.*;

public class setRadiusOfRoundedRectangle {
    public static void main(String[] args) throws Exception {
        String output = "output/setRadiusOfRoundedRectangle.pptx";

        //create a PPT document
        Presentation presentation = new Presentation();

        //insert a rounded rectangle and set its radious
        presentation.getSlides().get(0).getShapes().insertRoundRectangle(0, 160, 180, 100, 200, 10);

        //append a rounded rectangle and set its radius
        IAutoShape shape = presentation.getSlides().get(0).getShapes().appendRoundRectangle(380, 180, 100, 200, 100);

        //set the color and fill style of shape
        shape.getFill().setFillType( FillFormatType.SOLID);
        shape.getFill().getSolidColor().setColor(Color.green);
        shape.getShapeStyle().getLineColor().setColor(Color.white);

        //rotate the shape to 90 degree
        shape.setRotation(90);

        //save the document to Pptx file
        presentation.saveToFile(output, FileFormat.PPTX_2013);
    }
}
