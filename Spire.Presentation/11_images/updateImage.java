
import com.spire.presentation.*;
import com.spire.presentation.drawing.IImageData;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class updateImage {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/UpdateImage.pptx";
        String outputFile = "output/updateImage result.pptx";

        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);

        //Get the first slide
        ISlide slide = ppt.getSlides().get(0);

        //Append a new image to replace an existing image
        BufferedImage bufferedImage = (BufferedImage) ImageIO.read(new File("data/InsertImage.png"));
        IImageData imageData = ppt.getImages().append(bufferedImage);

        //Replace the image which title is "image1" with the new image
        for (int j = 0; j < slide.getShapes().getCount(); j++) {
            IShape shape = slide.getShapes().get(j);
            if (shape instanceof SlidePicture) {
                if (shape.getAlternativeTitle().equals("image1")) {
                    SlidePicture pic = (SlidePicture)shape;
                    pic.getPictureFill().getPicture().setEmbedImage(imageData);
                }
            }
        }

        ppt.saveToFile(outputFile, FileFormat.PPTX_2013);
    }
}
