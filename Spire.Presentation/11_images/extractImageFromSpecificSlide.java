
import com.spire.presentation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class extractImageFromSpecificSlide {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/Images.pptx";
        String outputPath = "output/";

        //Load a PPT document
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);

        //Traverse all shapes in the second slide
        for (int j =0; j < ppt.getSlides().get(1).getShapes().getCount(); j ++)
        {
            IShape shape = ppt.getSlides().get(1).getShapes().get(j);
            //It is the SlidePicture object
            if (shape instanceof SlidePicture)
            {
                //Save to image
                String ImageName = outputPath  + j + ".png";
                SlidePicture ps = (SlidePicture)shape ;
                BufferedImage image =  ps.getPictureFill().getPicture().getEmbedImage().getImage();
                ImageIO.write(image, "PNG",  new File(ImageName));
            }
             //It is the PictureShape object
            if (shape instanceof PictureShape)
            {
                //Save to image
                String ImageName = outputPath  + j + ".png";
                PictureShape ps = (PictureShape)shape;
                BufferedImage image =  ps.getEmbedImage().getImage();
                ImageIO.write(image, "PNG",  new File(ImageName));
            }
        }
    }
}

