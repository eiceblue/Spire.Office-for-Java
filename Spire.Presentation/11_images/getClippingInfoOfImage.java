import com.spire.presentation.*;
import java.awt.geom.Rectangle2D;

public class getClippingInfoOfImage {
    public static void main(String[] args) throws Exception {
        String input="data/GetClippingInfoOfImage.pptx";
        Presentation ppt=new Presentation();
        ppt.loadFromFile(input);
        IShape shape=ppt.getSlides().get(0).getShapes().get(0);
        if (shape instanceof SlidePicture)
        {
            SlidePicture picture=(SlidePicture)shape;
            //Get the cropped position
            Rectangle2D cropPosition= picture.getPictureFill().getCropPosition();
            System.out.println(cropPosition.getX());
            System.out.println(cropPosition.getY());
            //Get the position of picture
            Rectangle2D picPosition= picture.getPictureFill().getPicturePosition();
            System.out.println(picPosition.getX());
            System.out.println(picPosition.getY());
        }
    }
}
