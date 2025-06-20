import com.spire.presentation.*;
import com.spire.presentation.drawing.*;

import java.awt.*;

public class applySlideMaster {
    public static void main(String[] args) throws Exception {
        //Create an instance of presentation document
        Presentation ppt = new Presentation();
        //Load file
        ppt.loadFromFile("data/inputTemplate.pptx");

        //Get the first slide master from the presentation
        IMasterSlide masterSlide = ppt.getMasters().get(0);

        //Customize the background of the slide master
        String backgroundPic = "data/bg.png";
        Rectangle rect = new Rectangle(0, 0, (int) ppt.getSlideSize().getSize().getWidth(), (int) ppt.getSlideSize().getSize().getHeight());
        masterSlide.getSlideBackground().getFill().setFillType(FillFormatType.PICTURE);
        masterSlide.getShapes().appendEmbedImage(ShapeType.RECTANGLE, backgroundPic, rect);
        masterSlide.getSlideBackground().getFill().getPictureFill().getPicture().setUrl(backgroundPic);

        //Change the color scheme
        masterSlide.getTheme().getColorScheme().getAccent1().setColor(Color.red);
        masterSlide.getTheme().getColorScheme().getAccent2().setColor(Color.cyan);
        masterSlide.getTheme().getColorScheme().getAccent3().setColor(Color.orange);
        masterSlide.getTheme().getColorScheme().getAccent4().setColor(Color.BLACK);

        //Save the document
        String result = "output/applySlideMaster.pptx";
        ppt.saveToFile(result, FileFormat.PPTX_2013);
    }
}
