import com.spire.presentation.Presentation;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class extractImage {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/extractImage.pptx";
        String outputPath = "output/";

        //Load a PPT document
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);

        for (int i = 0; i < ppt.getImages().getCount(); i++) {
            String ImageName = outputPath + String.format("extractImage-%1$s.png", i);
            //Extract image
            BufferedImage image = ppt.getImages().get(i).getImage();
            ImageIO.write(image, "PNG",  new File(ImageName));
        }
    }
}

