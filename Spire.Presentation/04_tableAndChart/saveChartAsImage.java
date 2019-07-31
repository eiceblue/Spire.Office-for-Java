import com.spire.presentation.Presentation;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class saveChartAsImage {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/saveChartAsImage.pptx";
        String outputFile = "output/saveChartAsImage_result.png";

        //Create a ppt document and load file
        Presentation presentation = new Presentation();
        presentation.loadFromFile(inputFile);

        //Save chart as image in .png format
        BufferedImage image = presentation.getSlides().get(0).getShapes().saveAsImage(0);
        ImageIO.write(image,"PNG",new File(outputFile));
    }
}