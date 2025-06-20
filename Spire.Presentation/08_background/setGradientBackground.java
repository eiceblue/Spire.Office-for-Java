import com.spire.presentation.*;
import com.spire.presentation.drawing.*;
import java.awt.*;

public class setGradientBackground {
    public static void main(String[] args) throws Exception {
        String input = "data/pptSample_N.pptx";
        String output = "output/setGradientBackground.pptx";

        //create a PPT document
        Presentation presentation = new Presentation();

        //load document from disk
        presentation.loadFromFile(input);

        //get the first slide
        ISlide slide = presentation.getSlides().get(0);

        //set the background to gradient
        slide.getSlideBackground().setType( BackgroundType.CUSTOM);
        slide.getSlideBackground().getFill().setFillType(FillFormatType.GRADIENT);

        //add gradient stops
        slide.getSlideBackground().getFill().getGradient().getGradientStops().append(0.1f, Color.CYAN);
        slide.getSlideBackground().getFill().getGradient().getGradientStops().append(0.7f, Color.LIGHT_GRAY);

        //set gradient shape type
        slide.getSlideBackground().getFill().getGradient().setGradientShape(GradientShapeType.LINEAR);

        //set the angle
        slide.getSlideBackground().getFill().getGradient().getLinearGradientFill().setAngle(45);

        //save the document
        presentation.saveToFile(output, FileFormat.PPTX_2013);
    }
}
