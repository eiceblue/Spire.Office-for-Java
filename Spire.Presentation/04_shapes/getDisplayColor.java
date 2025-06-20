import com.spire.presentation.IAutoShape;
import com.spire.presentation.Presentation;

public class getDisplayColor {

    public static void main(String[] args) throws Exception {
        // Create Presentation Object and load file
        Presentation ppt = new Presentation();
        ppt.loadFromFile("data/getDisplayColor.pptx");
        // Get the first shape
        IAutoShape shape = (IAutoShape)ppt.getSlides().get(0).getShapes().get(0);
        // Print the fill type and color of the shape
        System.out.println(shape.getDisplayFill().getFillType().getName());
        System.out.println(shape.getDisplayFill().getSolidColor().getColor());
    }
}
