import com.spire.presentation.*;
import com.spire.presentation.drawing.FillFormatType;
import java.awt.geom.Rectangle2D;

public class insertImage {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/insertImage.pptx";
        String outputFile = "output/insertImage_result.pptx";
        String imageFile = "data/insertImage.png";

        //Load a PPT document
        Presentation presentation = new Presentation();
        presentation.loadFromFile(inputFile);

        //Insert image to PPT
        Rectangle2D.Double rect1 = new   Rectangle2D.Double(presentation.getSlideSize().getSize().getWidth() / 2 - 280, 140, 120, 120);
        IEmbedImage image = presentation.getSlides().get(0).getShapes().appendEmbedImage(ShapeType.RECTANGLE, imageFile, rect1);
        image.getLine().setFillType(FillFormatType.NONE);

        //Save the document
        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
    }
}
