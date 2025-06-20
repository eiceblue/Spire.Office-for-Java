import com.spire.presentation.IAutoShape;
import com.spire.presentation.ISlide;
import com.spire.presentation.Presentation;

public class getStartPositionAtMaxWidthOfTextArea {
    public static void main(String[] args) throws Exception {
        String input="data/position.pptx";
        Presentation ppt = new Presentation();
        ppt.loadFromFile(input);
        ISlide slide = ppt.getSlides().get(0);
        IAutoShape shape = (IAutoShape)slide.getShapes().get(0);
        double x = shape.getTextFrame().getStartLocationAtMaxWidth().getX();
        double y = shape.getTextFrame().getStartLocationAtMaxWidth().getY();
        System.out.println("The start position at the maximum width of the text area of shape: ");
        System.out.println("x(in shape) = "+x+", y(in slide) = "+y);

    }
}
