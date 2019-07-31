import com.spire.presentation.*;
import com.spire.presentation.drawing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class addImageInTableCell {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/addImageInTableCell.pptx";
        String outputFile = "output/addImageInTableCell_result.pptx";
        String imageFile = "data/presentationIcon.png";

        //Load a PPT document
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);

        //Get the first shape
        ITable table = (ITable) ((ppt.getSlides().get(0).getShapes().get(0) instanceof ITable) ? ppt.getSlides().get(0).getShapes().get(0) : null);

        BufferedImage image = ImageIO.read(new File(imageFile));
        //Load the image and insert it into table cell
        IImageData pptImg = ppt.getImages().append(image);
        table.get(1, 1).getFillFormat().setFillType(FillFormatType.PICTURE);
        table.get(1, 1).getFillFormat().getPictureFill().getPicture().setEmbedImage(pptImg);
        table.get(1, 1).getFillFormat().getPictureFill().setFillType(PictureFillType.STRETCH);

        //Save the document
        ppt.saveToFile(outputFile, FileFormat.PPTX_2010);
    }
}

