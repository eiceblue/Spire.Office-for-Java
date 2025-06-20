
import com.spire.presentation.*;
import java.awt.geom.*;

public class addHyperlinkToImage {
    public static void main(String[] args) throws Exception {
        String outputFile = "output/addHyperlinkToImage_result.pptx";
        String imageFile = "data/insertImage.png";

        //Create a PPT document
        Presentation presentation = new Presentation();

        //Get the first slide
        ISlide slide = presentation.getSlides().get(0);

        //Add image to slide
        Rectangle2D.Double rect = new Rectangle2D.Double(480, 350, 160, 160);
        IEmbedImage image = slide.getShapes().appendEmbedImage(ShapeType.RECTANGLE, imageFile, rect);

        //Add hyperlink to the image
        ClickHyperlink hyperlink = new ClickHyperlink("https://www.e-iceblue.com");
        image.setClick(hyperlink);

        //Save the document
        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
    }
}
