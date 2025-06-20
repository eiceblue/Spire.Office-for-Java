import com.spire.presentation.*;
import com.spire.presentation.drawing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class setShadowEffectForShape {
    public static void main(String[] args) throws Exception {
        String input = "Data/bg.png";
        String output = "output/setShadowEffectForShape.pptx";

        //create an instance of presentation document
        Presentation ppt = new Presentation();

        //get the first slide
        ISlide slide = ppt.getSlides().get(0);

        //set background image
        Rectangle2D rect = new Rectangle2D.Float();
        rect.setFrame(0, 0, ppt.getSlideSize().getSize().getWidth(), ppt.getSlideSize().getSize().getHeight());
        slide.getShapes().appendEmbedImage(ShapeType.RECTANGLE, input, rect);
        slide.getShapes().get(0).getLine().getFillFormat().getSolidFillColor().setColor(Color.LIGHT_GRAY);

        //add a shape to slide.
        Rectangle2D rect1 = new Rectangle2D.Float(200, 150, 300, 120);
        IAutoShape shape = slide.getShapes().appendShape(ShapeType.RECTANGLE, rect1);
        shape.getFill().setFillType(FillFormatType.SOLID);
        shape.getFill().getSolidColor().setColor(Color.LIGHT_GRAY);
        shape.getLine().setFillType(FillFormatType.NONE);
        shape.getTextFrame().setText("This demo shows how to apply shadow effect to shape.");
        shape.getTextFrame().getTextRange().getFill().setFillType(FillFormatType.SOLID);
        shape.getTextFrame().getTextRange().getFill().getSolidColor().setColor(Color.BLACK);

        //create an inner shadow effect through InnerShadowEffect object.
        InnerShadowEffect innerShadow = new InnerShadowEffect();
        innerShadow.setBlurRadius(20);
        innerShadow.setDirection(0);
        innerShadow.setDistance(0);
        innerShadow.getColorFormat().setColor(Color.BLACK);

        //apply the shadow effect to shape.
        shape.getEffectDag().setInnerShadowEffect(innerShadow);

        //save the document
        ppt.saveToFile(output, FileFormat.PPTX_2013);
    }
}
