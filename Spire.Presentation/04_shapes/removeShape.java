import com.spire.presentation.*;

public class removeShape {
    public static void main(String[] args) throws Exception {
        String input="data/findShapeByAltText.pptx";
        String output = "output/removeShape_result.pptx";

        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load doucment from disk
        presentation.loadFromFile(input);

        //Loop through slides
        for (int i = 0; i < presentation.getSlides().getCount(); i++)
        {
            ISlide slide = presentation.getSlides().get(i);
            //Loop through shapes
            for (int j = 0; j < slide.getShapes().getCount(); j++)
            {
                IShape shape = slide.getShapes().get(j);
                //Find the shapes whose alternative text contain "Shape"
                if(shape.getAlternativeText().contains("Shape"))
                {
                    slide.getShapes().remove(shape);
                    j--;
                }
            }
        }

        //Save the document
        presentation.saveToFile(output, FileFormat.PPTX_2013);
        presentation.dispose();
    }
}
