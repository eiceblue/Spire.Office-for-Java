import com.spire.presentation.*;

public class cloneSlideWithinAPPT {
    public static void main(String[] args) throws Exception {
        //Create an instance of presentation document
        Presentation ppt = new Presentation();
        //Load file
        ppt.loadFromFile("data/inputTemplate.pptx");

        //Get a list of slides and choose the first slide to be cloned
        ISlide slide = ppt.getSlides().get(0);

        //Insert the desired slide to the specified index in the same presentation
        int index = 1;
        ppt.getSlides().insert(index, slide);

        //Save the document
        String result = "output/cloneSlideWithinAPPT.pptx";
        ppt.saveToFile(result, FileFormat.PPTX_2013);
    }
}
