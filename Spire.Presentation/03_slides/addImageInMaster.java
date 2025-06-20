import com.spire.presentation.*;
import com.spire.presentation.drawing.*;

import java.awt.geom.*;

public class addImageInMaster {
    public static void main(String[] args) throws Exception {
        Presentation presentation = new Presentation();
        presentation.loadFromFile("data/pptSample_N.pptx");
        //Get the master collection
        IMasterSlide master = presentation.getMasters().get(0);

        //Append image to slide master
        Rectangle2D.Double rff = new Rectangle2D.Double(40, 40, 90, 90);
        String imageFile = "data/logo.png";
        IEmbedImage pic = master.getShapes().appendEmbedImage(ShapeType.RECTANGLE, imageFile, rff);
        pic.getLine().getFillFormat().setFillType(FillFormatType.NONE);
        //Add new slide to presentation
        presentation.getSlides().append();

        String output = "output/addImageInMaster.pptx";
        presentation.saveToFile(output, FileFormat.PPTX_2013);
    }
}
