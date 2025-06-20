import com.spire.presentation.*;
import com.spire.presentation.drawing.*;

import java.awt.*;

public class bordersAndShading {
    public static void main(String[] args) throws Exception {
        //Load a PPT document
        Presentation presentation = new Presentation();
        presentation.loadFromFile("data/bordersAndShading.pptx");

        IAutoShape shape = (IAutoShape)presentation.getSlides().get(0).getShapes().get(0);

        //Set line color and width of the border
        shape.getLine().setFillType(FillFormatType.SOLID);
        shape.getLine().setWidth(3);
        shape.getLine().getSolidFillColor().setColor(Color.yellow);

        //Set the gradient fill color of shape
        shape.getFill().setFillType(FillFormatType.GRADIENT);
        shape.getFill().getGradient().setGradientShape(GradientShapeType.LINEAR);
        shape.getFill().getGradient().getGradientStops().append(1f, KnownColors.LIGHT_BLUE);
        shape.getFill().getGradient().getGradientStops().append(0, KnownColors.LIGHT_SKY_BLUE);

        //Set the shadow for the shape
        OuterShadowEffect shadow = new OuterShadowEffect();
        shadow.setBlurRadius(20);
        shadow.setDirection (30);
        shadow.setDistance (8);
        shadow.getColorFormat().setColor( Color.green);
        shape.getEffectDag().setOuterShadowEffect(shadow);

        //Save the document
        String output = "output/bordersAndShading.pptx";
        presentation.saveToFile(output, FileFormat.PPTX_2013);
    }
}
