import com.spire.presentation.*;
import com.spire.presentation.drawing.FillFormatType;
import com.spire.presentation.drawing.animation.AnimationEffectType;
import com.spire.presentation.drawing.transition.TransitionType;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class animations {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/animations.pptx";
        String outputFile = "output/animations_result.pptx";
        Presentation presentation = new Presentation();
        presentation.loadFromFile(inputFile);

        //Add title
        Rectangle2D.Double rec_title = new Rectangle2D.Double(50, 200, 200, 50);
        IAutoShape shape_title = presentation.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, rec_title);
        shape_title.getLine().setFillType(FillFormatType.NONE);

        shape_title.getFill().setFillType(FillFormatType.NONE);
        ParagraphEx para_title = new ParagraphEx();
        para_title.setText("Animations:");
        para_title.setAlignment(TextAlignmentType.CENTER);
        para_title.getTextRanges().get(0).setLatinFont(new TextFont("Myriad Pro Light"));
        para_title.getTextRanges().get(0).setFontHeight(32);
        para_title.getTextRanges().get(0).isBold(TriState.TRUE);
        para_title.getTextRanges().get(0).getFill().setFillType(FillFormatType.SOLID);
        para_title.getTextRanges().get(0).getFill().getSolidColor().setColor(Color.gray);
        shape_title.getTextFrame().getParagraphs().append(para_title);

        //Set the animation of slide to Circle
        presentation.getSlides().get(0).getSlideShowTransition().setType(TransitionType.CIRCLE);
        //Append new shape - Triangle
        IAutoShape shape = presentation.getSlides().get(0).getShapes().appendShape(ShapeType.TRIANGLE, new Rectangle2D.Double(100, 280, 80, 80));
        //Set the color of shape
        shape.getFill().setFillType(FillFormatType.SOLID);
        shape.getFill().getSolidColor().setColor(Color.orange);
        shape.getShapeStyle().getLineColor().setColor(Color.white);
        //Set the animation of shape
        shape.getSlide().getTimeline().getMainSequence().addEffect(shape, AnimationEffectType.PATH_4_POINT_STAR);
        //Append new shape - Rectangle and set animation
        shape = presentation.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, new Rectangle2D.Double(210, 280, 150, 80));
        shape.getFill().setFillType(FillFormatType.SOLID);
        shape.getFill().getSolidColor().setColor(Color.orange);
        shape.getShapeStyle().getLineColor().setColor(Color.white);
        shape.appendTextFrame("Animated Shape");
        shape.getSlide().getTimeline().getMainSequence().addEffect(shape, AnimationEffectType.FADED_SWIVEL);

        //Append new shape - Cloud and set the animation
        shape = presentation.getSlides().get(0).getShapes().appendShape(ShapeType.CLOUD, new Rectangle2D.Double(390, 280, 80, 80));
        shape.getFill().setFillType(FillFormatType.SOLID);
        shape.getFill().getSolidColor().setColor(Color.white);
        shape.getShapeStyle().getLineColor().setColor(Color.orange);
        shape.getSlide().getTimeline().getMainSequence().addEffect(shape, AnimationEffectType.FADED_ZOOM);
        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
        presentation.dispose();
    }
}
