import com.spire.presentation.*;

import java.awt.geom.Rectangle2D;

public class getSlideByIndexOrID {
    public static void main(String[] args) throws Exception {
        String inputFile="data/BlankSample_N.pptx";
        String outputFile = "output/getSlideByIndexOrID_result.pptx";

        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load document from disk
        presentation.loadFromFile(inputFile);

        //Get slide by index 0
        ISlide slide1 = presentation.getSlides().get(0);
        //Append a shape in the slide
        IAutoShape shape1=slide1.getShapes().appendShape(ShapeType.RECTANGLE, new Rectangle2D.Double(100, 100, 200, 100));
        //Add text in the shape
        shape1.getTextFrame().setText("Get slide by index");

        //Get slide by slide ID
        ISlide slide2 = presentation.findSlide((int)presentation.getSlides().get(1).getSlideID());
        //Append a shape in the slide
        IAutoShape shape2 = slide2.getShapes().appendShape(ShapeType.RECTANGLE, new Rectangle2D.Double(100, 100, 200, 100));
        //Add text in the shape
        shape2.getTextFrame().setText("Get slide by slide id");

        //Save the document
        presentation.saveToFile(outputFile, FileFormat.PPTX_2013);
        presentation.dispose();
    }
}
