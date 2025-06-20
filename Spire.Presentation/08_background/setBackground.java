import com.spire.presentation.*;
import com.spire.presentation.drawing.*;

public class setBackground {
    public static void main(String[] args) throws Exception {
        String input1 = "data/setBackground.pptx";
        String input2 = "data/setbackground.png";
        String output = "output/setBackground _output.pptx";

        //create a PowerPoint document.
        Presentation presentation = new Presentation();

        //load the file from disk.
        presentation.loadFromFile(input1);

        //Set the background of the first slide to Gradient color
        presentation.getSlides().get(0).getSlideBackground().setType(BackgroundType.CUSTOM);
        presentation.getSlides().get(0).getSlideBackground().getFill().setFillType(FillFormatType.PICTURE);
        presentation.getSlides().get(0).getSlideBackground().getFill().getPictureFill().setAlignment(RectangleAlignment.NONE);
        presentation.getSlides().get(0).getSlideBackground().getFill().getPictureFill().setFillType(PictureFillType.TILE);
        presentation.getSlides().get(0).getSlideBackground().getFill().getPictureFill().getPicture().setUrl((new java.io.File(input2)).getAbsolutePath());

        //save the file
        presentation.saveToFile(output, FileFormat.PPTX_2013);
        presentation.dispose();
    }
}
