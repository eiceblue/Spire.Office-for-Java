import com.spire.presentation.Presentation;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class toImage {
    public static void main(String[] args) throws Exception{
        String inputFile ="data/toImage.pptx";
        String outputFile="output";
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);
        //Save PPT document to images
        for (int i = 0; i < ppt.getSlides().getCount(); i++) {
            BufferedImage image = ppt.getSlides().get(i).saveAsImage();
            String fileName = outputFile + "/" + String.format("ToImage-%1$s.png", i);
            ImageIO.write(image, "PNG",new File(fileName));
        }
        ppt.dispose();
    }
}
