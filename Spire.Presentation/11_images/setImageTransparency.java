
import com.spire.presentation.*;
import com.spire.presentation.drawing.*;

import java.awt.geom.Rectangle2D;

public class setImageTransparency {
    public static void main(String[] args) throws Exception {
        String imageFile = "data/insertImage.png";
        String outputFile = "output/SetImageTransparency_result.pptx";

        Presentation presentation = new Presentation();
        //Insert image to PPT
        Rectangle2D.Double rect1 = new   Rectangle2D.Double(200, 140, 120, 120);
        IAutoShape shape =  presentation.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, rect1);

        shape.getLine().setFillType(FillFormatType.NONE);
        shape.getFill().setFillType(FillFormatType.PICTURE);
        shape.getFill().getPictureFill().getPicture().setUrl(imageFile);
        shape.getFill().getPictureFill().setFillType(PictureFillType.STRETCH);
        //Set transparency on image
        shape.getFill().getPictureFill().getPicture().setTransparency(50);

        //Save the document
        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
    }
}
