import com.spire.presentation.*;
import com.spire.presentation.drawing.*;

import java.awt.*;

public class setTextDirection {
    public static void main(String[] args) throws Exception {
        //Create an instance of presentation document
        Presentation ppt = new Presentation();

        //Append a shape with text to the first slide
        IAutoShape textboxShape = ppt.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, new Rectangle(250, 70, 100, 400));
        textboxShape.getShapeStyle().getLineColor().setColor(Color.white);
        textboxShape.getFill().setFillType(FillFormatType.SOLID);
        textboxShape.getFill().getSolidColor().setColor(Color.cyan);
        textboxShape.getTextFrame().setText("You Are Welcome Here");
        //Set the text direction to vertical
        textboxShape.getTextFrame().setVerticalTextType(VerticalTextType.VERTICAL);

        //Append another shape with text to the slide
        textboxShape = ppt.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, new Rectangle(350, 70, 100, 400));
        textboxShape.getShapeStyle().getLineColor().setColor(Color.white);
        textboxShape.getFill().setFillType(FillFormatType.SOLID);
        textboxShape.getFill().getSolidColor().setColor(Color.lightGray);
        //Append some asian characters
        textboxShape.getTextFrame().setText("欢迎光临");
        //Set the VerticalTextType as EastAsianVertical to aviod rotating text 90 degrees
        textboxShape.getTextFrame().setVerticalTextType(VerticalTextType.EAST_ASIAN_VERTICAL);

        //Save the document
        String result = "output/setTextDirection.pptx";
        ppt.saveToFile(result, FileFormat.PPTX_2013);
    }
}
