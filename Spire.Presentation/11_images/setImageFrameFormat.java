
import com.spire.presentation.*;
import com.spire.presentation.drawing.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;

public class setImageFrameFormat {
    public static void main(String[] args) throws Exception {

        String imageFile = "data/insertImage.png";
        String outputFile = "output/setImageFrameFormat_result.pptx";

        Presentation presentation = new Presentation();

        //Insert image to PPT
        BufferedImage bufferedImage = (BufferedImage) ImageIO.read(new File(imageFile));
        IImageData imageData = presentation.getImages().append(bufferedImage);

        Rectangle2D.Double rect1 = new   Rectangle2D.Double(presentation.getSlideSize().getSize().getWidth() / 2 - 280, 140, 120, 120);
        IEmbedImage image = presentation.getSlides().get(0).getShapes().appendEmbedImage(ShapeType.RECTANGLE, imageData, rect1);

        //Set the formatting of the image frame
        image.getLine().setFillType(FillFormatType.SOLID);
        image.getLine().getSolidFillColor().setColor(Color.lightGray);
        image.getLine().setWidth(5);
        image.setRotation(45);

        //Save the document
        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
    }
}
