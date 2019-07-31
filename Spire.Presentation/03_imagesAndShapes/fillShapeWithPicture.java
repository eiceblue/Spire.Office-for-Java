import com.spire.presentation.*;
import com.spire.presentation.drawing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class fillShapeWithPicture {
    public static void main(String[] args) throws Exception{
        String inputFile = "data/fillShapeWithPicture.pptx";
        String outputFile = "output/fillShapeWithPicture_result.pptx";
        String imageURL = "data/backgroundImg.png";

        //Load a PPT document
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);

        //Get the first shape and set the style to be Gradient
        IAutoShape shape = (IAutoShape) ppt.getSlides().get(0).getShapes().get(0);

        //Fill the shape with picture
        shape.getFill().setFillType(FillFormatType.PICTURE);
        BufferedImage image = ImageIO.read( new File(imageURL));
        shape.getFill().getPictureFill().getPicture().setEmbedImage(ppt.getImages().append(image));

        shape.getFill().getPictureFill().setFillType(PictureFillType.STRETCH);

        ppt.saveToFile(outputFile, FileFormat.PPTX_2010);
    }
}
