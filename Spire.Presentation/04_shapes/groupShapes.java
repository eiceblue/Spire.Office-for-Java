import com.spire.presentation.*;
import com.spire.presentation.drawing.FillFormatType;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class groupShapes {
    public static void main(String[] args) throws Exception {
        String ImageFile = "data/bg.png";
        String result = "output/groupShapes_result.pptx";

        //Create an instance of presentation document
        Presentation ppt = new Presentation();

        //Get the first slide
        ISlide slide = ppt.getSlides().get(0);

        //Set background image

        Rectangle2D rect = new Rectangle2D.Double(0, 0, ppt.getSlideSize().getSize().getWidth(), ppt.getSlideSize().getSize().getHeight());
        slide.getShapes().appendEmbedImage(ShapeType.RECTANGLE, ImageFile, rect);
        slide.getShapes().get(0).getLine().getFillFormat().getSolidFillColor().setColor(Color.white);

        //Create two shapes in the slide
        IShape rectangle = slide.getShapes().appendShape(ShapeType.RECTANGLE, new Rectangle2D.Double(250, 180, 200, 40));
        rectangle.getFill().setFillType(FillFormatType.SOLID);
        rectangle.getFill().getSolidColor().setKnownColor(KnownColors.LIGHT_BLUE);
        rectangle.getLine().setWidth(0.1f);
        IShape ribbon = slide.getShapes().appendShape(ShapeType.RIBBON_2, new Rectangle2D.Double(290, 155, 120, 80));
        ribbon.getFill().setFillType(FillFormatType.SOLID);
        ribbon.getFill().getSolidColor().setKnownColor(KnownColors.LIGHT_PINK);
        ribbon.getLine().setWidth(0.1f);

        //Add the two shape objects to an array list
        ArrayList list = new ArrayList();
        list.add(rectangle);
        list.add(ribbon);

        //Group the shapes in the list
        ppt.getSlides().get(0).groupShapes(list);

        //Save the document
        ppt.saveToFile(result, FileFormat.PPTX_2013);
        ppt.dispose();
    }
}
