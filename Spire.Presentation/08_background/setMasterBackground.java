import com.spire.presentation.*;
import com.spire.presentation.drawing.*;
import java.awt.*;

public class setMasterBackground {
    public static void main(String[] args) throws Exception {
        String input = "data/pptSample_N.pptx";
        String output = "output/setMasterBackground.pptx";

        //create a PPT document
        Presentation presentation = new Presentation();

        //set the slide background of master
        presentation.getMasters().get(0).getSlideBackground().setType(BackgroundType.CUSTOM);
        presentation.getMasters().get(0).getSlideBackground().getFill().setFillType(FillFormatType.SOLID);
        presentation.getMasters().get(0).getSlideBackground().getFill().getSolidColor().setColor(Color.LIGHT_GRAY);

        //save the document
        presentation.saveToFile(output, FileFormat.PPTX_2013);
    }
}
