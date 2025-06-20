import com.spire.presentation.*;

import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

public class pictureCustomBulletStyle {
    public static void main(String[] args) throws Exception {
        //Create an instance of presentation document
        Presentation ppt = new Presentation();
        //Load file
        ppt.loadFromFile("data/bulltes.pptx");

        //Get the second shape on the first slide
        IAutoShape shape = (IAutoShape) ppt.getSlides().get(0).getShapes().get(1);

        //Traverse through the paragraphs in the shape
        for (Object para : shape.getTextFrame().getParagraphs()) {
            //Set the bullet style of paragraph as picture
            ParagraphEx paragraph = (ParagraphEx) para;
            paragraph.setBulletType(TextBulletType.PICTURE);
            //Load a picture
            BufferedImage bulletPicture = ImageIO.read(new File("data/icon.png"));
            //Add the picture as the bullet style of paragraph
            paragraph.getBulletPicture().setEmbedImage(ppt.getImages().append(bulletPicture));
        }

        //Save the document
        String result = "output/pictureCustomBulletStyle.pptx";
        ppt.saveToFile(result, FileFormat.PPTX_2013);
    }
}
