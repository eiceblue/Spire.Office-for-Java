import com.spire.presentation.*;
import com.spire.presentation.drawing.*;

public class setBackground {
    public static void main(String[] args) throws Exception{
        String inputFile ="data/setBackground.pptx";
        String imageFile ="data/setbackground.png";
        String outputFile="output/setBackground_result.pptx";
        Presentation pt = new Presentation();
        pt.loadFromFile(inputFile);
        pt.getSlides().get(0).getSlideBackground().setType(BackgroundType.CUSTOM);
        pt.getSlides().get(0).getSlideBackground().getFill().setFillType(FillFormatType.PICTURE);
        pt.getSlides().get(0).getSlideBackground().getFill().getPictureFill().setAlignment(RectangleAlignment.NONE);
        pt.getSlides().get(0).getSlideBackground().getFill().getPictureFill().setFillType(PictureFillType.TILE);
        pt.getSlides().get(0).getSlideBackground().getFill().getPictureFill().getPicture().setUrl((new java.io.File(imageFile)).getAbsolutePath());
        pt.saveToFile(outputFile, FileFormat.PPTX_2010);
        pt.dispose();
    }
}
