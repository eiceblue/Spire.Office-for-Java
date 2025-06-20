import com.spire.presentation.*;
import com.spire.presentation.drawing.*;
import com.spire.presentation.drawing.animation.*;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class addExitAnimationForShape {
    public static void main(String[] args) throws Exception {
        String imageFile = "data/bg.png";
        String outputFile = "output/addExitAnimationForShape.pptx";

        //Create PPT document
        Presentation presentation = new Presentation();

        //Set background Image
        Rectangle2D.Double rect = new Rectangle2D.Double(0, 0, presentation.getSlideSize().getSize().getWidth(), presentation.getSlideSize().getSize().getHeight());
        presentation.getSlides().get(0).getShapes().appendEmbedImage(ShapeType.RECTANGLE, imageFile, rect);
        presentation.getSlides().get(0).getShapes().get(0).getLine().getSolidFillColor().setColor(Color.white);

        //Get the first slide
        ISlide slide=presentation.getSlides().get(0);

        //Add a shape to the slide
        IShape starShape = slide.getShapes().appendShape(ShapeType.FIVE_POINTED_STAR, new Rectangle2D.Double(250, 100, 200, 200));
        starShape.getFill().setFillType(FillFormatType.SOLID);
        starShape.getFill().getSolidColor().setKnownColor(KnownColors.POWDER_BLUE);

        //Add random bars effect to the shape
        AnimationEffect effect = slide.getTimeline().getMainSequence().addEffect(starShape, AnimationEffectType.RANDOM_BARS);

        //Change effect type from entrance to exit
        effect.setPresetClassType(TimeNodePresetClassType.EXIT);

        //Save the document
        presentation.saveToFile(outputFile, FileFormat.PPTX_2013);
        presentation.dispose();
    }
}
