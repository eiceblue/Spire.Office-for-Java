import com.spire.presentation.*;
import java.awt.geom.Point2D;

public class getPositionOfText {

    public static void main(String[] args) throws Exception {
        String input="data/extractText.pptx";
        Presentation ppt = new Presentation();
        ppt.loadFromFile(input);
        ISlide slide = ppt.getSlides().get(0);
        IAutoShape shape = (IAutoShape)slide.getShapes().get(0);
        Point2D location =shape.getTextFrame().getTextLocation();
        String  point1="Text's position in Slide: x= "+location.getX()+" y = "+location.getY();
        System.out.println(point1);
        String point2 = "Text's position in shape: x= " + (location.getX() - shape.getLeft()) + "  y = " + (location.getY() - shape.getTop());
        System.out.println(point2);
    }
}
