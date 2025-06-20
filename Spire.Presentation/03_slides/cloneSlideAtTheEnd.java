import com.spire.presentation.*;

public class cloneSlideAtTheEnd {
    public static void main(String[] args) throws Exception {
        //Load PPT document from disk
        Presentation presentation = new Presentation();
        presentation.loadFromFile("data/changeSlidePosition.pptx");

        //Get the first slide
        ISlide slide = presentation.getSlides().get(0);

        //Append the slide at the end of the document
        presentation.getSlides().append(slide);

        //Save the document
        String result = "output/clonePPTAtTheEnd.pptx";
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
