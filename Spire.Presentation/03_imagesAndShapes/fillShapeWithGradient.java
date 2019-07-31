import com.spire.presentation.*;
import com.spire.presentation.drawing.FillFormatType;
import java.awt.*;

public class fillShapeWithGradient {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/FillShapeWithGradient.pptx";
        String outputFile = "output/FillShapeWithGradient_result.pptx";

        //Load a PPT document
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);

        //Get the first shape and set the style to be Gradient
        IAutoShape GradientShape = (IAutoShape) ppt.getSlides().get(0).getShapes().get(0);
        GradientShape.getFill().setFillType(FillFormatType.GRADIENT);
        GradientShape.getFill().getGradient().getGradientStops().append(0, Color.blue);
        GradientShape.getFill().getGradient().getGradientStops().append(1, Color.lightGray);

        ppt.saveToFile(outputFile, FileFormat.PPTX_2010);
    }
}
