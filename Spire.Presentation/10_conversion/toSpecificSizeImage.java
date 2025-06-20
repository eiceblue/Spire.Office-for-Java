
import com.spire.presentation.Presentation;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class toSpecificSizeImage {
    public static void main(String[] args) throws Exception {
        String inputFile ="data/toImage.pptx";
        String outputFile="output";
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);
        //Save PPT document to images
        for (int i = 0; i < ppt.getSlides().getCount(); i++) {
            BufferedImage image = ppt.getSlides().get(i).saveAsImage(600,400);
            String fileName = outputFile + "/" + i + ".png";
            ImageIO.write(image, "PNG",new File(fileName));
        }
        ppt.dispose();
    }
}
