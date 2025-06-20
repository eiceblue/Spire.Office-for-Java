import com.spire.presentation.*;
import com.spire.presentation.drawing.FillFormatType;
import com.spire.presentation.drawing.animation.AnimationEffectType;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class applyAnimationOnShape {
    public static void main(String[] args) throws Exception {
        String ImageFile = "data/bg.png";
        String result = "output/applyAnimationOnShape.pptx";

        //Create an instance of presentation document
        Presentation ppt = new Presentation();

        //Get the first slide
        ISlide slide = ppt.getSlides().get(0);

        //Set background Image
        Rectangle2D.Double rect = new Rectangle2D.Double(0, 0, ppt.getSlideSize().getSize().getWidth(), ppt.getSlideSize().getSize().getHeight());
        ppt.getSlides().get(0).getShapes().appendEmbedImage(ShapeType.RECTANGLE, ImageFile, rect);
        ppt.getSlides().get(0).getShapes().get(0).getLine().getSolidFillColor().setColor(Color.white);

        //Insert a rectangle in the slide and fill the shape
        IAutoShape shape = slide.getShapes().appendShape(ShapeType.RECTANGLE, new Rectangle2D.Double(100, 150, 200, 80));
        shape.getFill().setFillType(FillFormatType.SOLID);
        shape.getFill().getSolidColor().setColor(Color.gray);
        shape.getShapeStyle().getLineColor().setColor(Color.white);
        shape.appendTextFrame("Animated Shape");

        //Apply FadedSwivel animation effect to the shape
        shape.getSlide().getTimeline().getMainSequence().addEffect(shape, AnimationEffectType.FADED_SWIVEL);

        //Save the document
        ppt.saveToFile(result, FileFormat.PPTX_2013);
        ppt.dispose();
    }
}
