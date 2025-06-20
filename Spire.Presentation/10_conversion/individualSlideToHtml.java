import com.spire.presentation.*;

public class individualSlideToHtml {
    public static void main(String[] args) throws Exception {
        //Create PPT document
        Presentation presentation = new Presentation();

        //Load the PPT document from disk.
        presentation.loadFromFile("data/changeSlidePosition.pptx");

        //Get the first slide
        ISlide slide = presentation.getSlides().get(0);

        //String for output file
        String result = "output/individualSlideToHtml_result.html";

        //Save the first slide to HTML
        slide.SaveToFile(result, FileFormat.HTML);
    }
}
