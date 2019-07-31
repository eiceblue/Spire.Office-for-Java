import com.spire.presentation.*;
import com.spire.presentation.drawing.FillFormatType;
import java.awt.geom.Rectangle2D;

public class addImageInMaster {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/addImageInMaster.pptx";
        String imageFile="data/Logo.png";
        String outputFile = "output/addImageInMaster_result.pptx";
        Presentation presentation = new Presentation();
        presentation.loadFromFile(inputFile);
        //Get the master collection
        IMasterSlide master = presentation.getMasters().get(0);
        //Append image to slide master
        Rectangle2D.Double rff = new Rectangle2D.Double(40, 40, 90, 90);
        IEmbedImage pic = master.getShapes().appendEmbedImage(ShapeType.RECTANGLE, imageFile, rff);
        pic.getLine().getFillFormat().setFillType(FillFormatType.NONE);
        //Add new slide to presentation
        presentation.getSlides().append();
        presentation.saveToFile(outputFile, FileFormat.PPTX_2013);
        presentation.dispose();
    }
}

