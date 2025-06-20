import com.spire.presentation.*;
import com.spire.presentation.drawing.FillFormatType;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class addRoundCornerRectangle {
    public static void main(String[] args) throws Exception {
        String ImageFile = "data/bg.png";
        String outputFile = "output/addRoundCornerRectagle.pptx";

        //Create an instance of presentation document
        Presentation ppt = new Presentation();

        //Set background image
        Rectangle2D rect = new Rectangle2D.Double(0, 0, ppt.getSlideSize().getSize().getWidth(), ppt.getSlideSize().getSize().getHeight());
        ppt.getSlides().get(0).getShapes().appendEmbedImage(ShapeType.RECTANGLE, ImageFile, rect);
        ppt.getSlides().get(0).getShapes().get(0).getLine().getFillFormat().getSolidFillColor().setColor(Color.WHITE);

        //Append a round corner rectangle and set its radius
        IAutoShape shape = ppt.getSlides().get(0).getShapes().appendRoundRectangle(300, 90, 100, 200, 80);
        //Set the color and fill style of shape
        shape.getFill().setFillType(FillFormatType.SOLID);
        shape.getFill().getSolidColor().setColor(Color.PINK);
        shape.getShapeStyle().getLineColor().setColor(Color.LIGHT_GRAY);
        //Rotate the shape to 90 degree
        shape.setRotation(90);

        //Save the document
        ppt.saveToFile(outputFile, FileFormat.PPTX_2013);
    }
}
