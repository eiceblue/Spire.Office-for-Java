import com.spire.presentation.*;
import java.awt.*;

public class changeHyperlinkColor {
    public static void main(String[] args) throws Exception {
        //Create a PowerPoint document
        Presentation presentation = new Presentation();
        //Load file from disk
        presentation.loadFromFile("data/ChangeHyperlinkColor.pptx");
        //Get the first slide
        ISlide slide=presentation.getSlides().get(0);
        //Get the theme of the slide
        Theme theme= slide.getTheme();
        //Change the color of hyperlink to red
        theme.getColorScheme().getHyperlinkColor().setColor(Color.red);
        String result="Result-ChangeHyperlinkColor.pptx";
        //Save the file
        presentation.saveToFile(result,FileFormat.PPTX_2013);
    }
}
