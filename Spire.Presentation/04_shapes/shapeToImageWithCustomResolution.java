import com.spire.presentation.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.File;

public class shapeToImageWithCustomResolution  {
    public static void main(String[] args) throws Exception {
        String input="data/shapeToImage.pptx";
        String outputPath="output/images/";
        Presentation ppt = new Presentation();
        ppt.loadFromFile(input);
        ISlide slide = ppt.getSlides().get(0);
        String fileName="";
        for (int i = 0; i < slide.getShapes().getCount(); i++){
            fileName = outputPath + "shapeToImage_demo"+i+".png";
            BufferedImage image = slide.getShapes().saveAsImage(i,300,300);
            ImageIO.write(image, "PNG", new File(fileName));
        }
        ppt.dispose();
    }

}
