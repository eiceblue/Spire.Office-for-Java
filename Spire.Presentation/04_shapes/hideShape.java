import com.spire.presentation.*;

public class hideShape {
    public static void main(String[] args) throws Exception {
        String input="data/findShapeByAltText.pptx";
        String result = "output/hideShape_result.pptx";

        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load document from disk
        presentation.loadFromFile(input);

        //Loop through slides
        for (ISlide slide : (Iterable<ISlide>) presentation.getSlides())
        {
            //Loop through shapes in the slide
            for (IShape shape :(Iterable<IShape>) slide.getShapes())
            {
                //Find the shape whose alternative text is Shape1
                if (shape.getAlternativeText().compareTo("Shape1") == 0)
                {
                    //Hide the shape
                    shape.isHidden(true);
                }
            }
        }

        //Save the document
        presentation.saveToFile(result, FileFormat.PPTX_2013);
        presentation.dispose();
    }
}
