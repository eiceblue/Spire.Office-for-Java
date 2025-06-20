import com.spire.presentation.*;

public class specificSlideToPDF {
    public static void main(String[] args) throws Exception {
        //Create PPT document
        Presentation presentation = new Presentation();

        //Load the PPT document from disk.
        presentation.loadFromFile("data/ChangeSlidePosition.pptx");

        //Get the second slide
        ISlide slide= presentation.getSlides().get(1);

        //String for output file
        String result = "output/specificSlideToPDF_result.pdf";

        //Save the second slide to PDF
        slide.SaveToFile(result, FileFormat.PDF);
    }
}
