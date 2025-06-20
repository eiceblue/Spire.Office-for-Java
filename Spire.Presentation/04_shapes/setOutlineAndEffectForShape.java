import com.spire.presentation.*;
import com.spire.presentation.drawing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;


public class setOutlineAndEffectForShape {
    public static void main(String[] args) throws Exception {
        String  input = "data/bg.png";
        String output = "output/setOutlineAndEffectForShape.pptx";

        //create an instance of presentation document
        Presentation ppt = new Presentation();

        //get the first slide
        ISlide slide = ppt.getSlides().get(0);

        //set background Image
        Rectangle2D rect = new Rectangle2D.Float();
        rect.setFrame(0, 0, ppt.getSlideSize().getSize().getWidth(), ppt.getSlideSize().getSize().getHeight());
        slide.getShapes().appendEmbedImage(ShapeType.RECTANGLE, input, rect);
        slide.getShapes().get(0).getLine().getFillFormat().getSolidFillColor().setColor( Color.LIGHT_GRAY);

        //draw a Rectangle shape
        IAutoShape shape = slide.getShapes().appendShape(ShapeType.RECTANGLE, new Rectangle2D.Float(150, 180, 100, 50));
        shape.getFill().setFillType(FillFormatType.SOLID);
        shape.getFill().getSolidColor().setColor(Color.BLUE);

        //set outline color
        shape.getShapeStyle().getLineColor().setColor(Color.red);

        //set shadow effect
        PresetShadow shadow = new PresetShadow();
        shadow.getColorFormat().setColor(Color.MAGENTA);
        shadow.setPreset( PresetShadowValue.FRONT_RIGHT_PERSPECTIVE);
        shadow.setDistance(10.0);
        shadow.setDirection(225.0f);
        shape.getEffectDag().setPresetShadowEffect(shadow);

        //draw a Ellipse shape
        shape = slide.getShapes().appendShape(ShapeType.ELLIPSE, new Rectangle2D.Float(400, 150, 100, 100));
        shape.getFill().setFillType(FillFormatType.SOLID);
        shape.getFill().getSolidColor().setColor(Color.BLUE);

        //set outline color
        shape.getShapeStyle().getLineColor().setColor(Color.YELLOW);

        //set shadow effect
        GlowEffect glow = new GlowEffect();
        glow.getColorFormat().setColor(Color.PINK);
        glow.setRadius(20.0);
        shape.getEffectDag().setGlowEffect(glow);

        //save the document
        ppt.saveToFile(output, FileFormat.PPTX_2013);
    }
}
