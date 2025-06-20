import com.spire.presentation.*;

public class addDifferentLayoutSlides {
    public static void main(String[] args) throws Exception {
        //Create a PPT document
        Presentation presentation = new Presentation();

        //Remove the default slide
        presentation.getSlides().removeAt(0);

        //Loop through slide layouts
        for (SlideLayoutType type : SlideLayoutType.values())
        {
            //Append slide by specifing slide layout
            presentation.getSlides().append(type);
        }

        //Save the document
        String result = "output/addDifferentLayoutSlides_result.pptx";
        presentation.saveToFile(result, FileFormat.PPTX_2013);
        presentation.dispose();
    }
}
