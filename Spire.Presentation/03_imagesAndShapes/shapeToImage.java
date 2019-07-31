import com.spire.presentation.Presentation;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class shapeToImage {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/shapeToImage.pptx";
        String outputPath = "output/";

        //Create a PPT document
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);

        for (int i = 0; i < ppt.getSlides().get(0).getShapes().getCount(); i++) {
            String fileName = outputPath + String.format("shapeToImage-%1$s.png", i);
            //Extract image
            BufferedImage image = ppt.getSlides().get(0).getShapes().saveAsImage(i);
            ImageIO.write(image, "PNG",  new File(fileName));
        }
    }
}
