import com.spire.presentation.*;
import com.spire.presentation.drawing.FillFormatType;
import com.spire.presentation.drawing.animation.*;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class applyAnimationOnText {
    public static void main(String[] args) throws Exception {
        String ImageFile = "data/bg.png";
        String result = "output/applyAnimationOnText.pptx";

        //Create an instance of presentation document
        Presentation ppt = new Presentation();

        //Get the first slide
        ISlide slide = ppt.getSlides().get(0);

        //Set background image
        Rectangle2D.Double rect = new Rectangle2D.Double(0, 0, ppt.getSlideSize().getSize().getWidth(), ppt.getSlideSize().getSize().getHeight());
        ppt.getSlides().get(0).getShapes().appendEmbedImage(ShapeType.RECTANGLE, ImageFile, rect);
        ppt.getSlides().get(0).getShapes().get(0).getLine().getSolidFillColor().setColor(Color.white);

        //Add a shape to the slide
        IAutoShape shape = slide.getShapes().appendShape(ShapeType.RECTANGLE, new Rectangle2D.Double(250, 150, 200, 100));
        shape.getFill().setFillType(FillFormatType.SOLID);
        shape.getFill().getSolidColor().setColor(Color.gray);
        shape.getShapeStyle().getLineColor().setColor(Color.white);
        shape.appendTextFrame("This demo shows how to apply animation on text in PPT document.");

        //Apply animation to the text in shape
        AnimationEffect animation = shape.getSlide().getTimeline().getMainSequence().addEffect(shape, AnimationEffectType.FLOAT);
        animation.setStartEndParagraphs(0, 0);

        //Save the document
        ppt.saveToFile(result, FileFormat.PPTX_2013);
        ppt.dispose();
    }
}
