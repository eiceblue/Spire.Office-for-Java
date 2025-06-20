import com.spire.presentation.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.File;

public class convertGroupShapeToImage {
    public static void main(String[] args) throws Exception {
        String input="data/ConvertGroupShapeToImage.pptx";
        String outputPath ="output/images/";
        Presentation ppt=new Presentation();
        ppt.loadFromFile(input);

        for (int i = 0; i < ppt.getSlides().get(0).getShapes().getCount(); i++){
            String fileName = outputPath + "shapeToImage_"+i+".png";
            //Convert shape to image
            BufferedImage image = ppt.getSlides().get(0).getShapes().saveAsImage(i);
            ImageIO.write(image, "PNG", new File(fileName));
        }
    }
}
