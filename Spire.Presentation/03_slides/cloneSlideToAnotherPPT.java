import com.spire.presentation.*;

public class cloneSlideToAnotherPPT {
    public static void main(String[] args) throws Exception {
        String inputFile_1 = "data/pptSample_N.pptx";
        String inputFile_2 = "data/templateA.pptx";

        Presentation presentation = new Presentation();
        presentation.loadFromFile(inputFile_1);
        //Load the another document and choose the first slide to be cloned
        Presentation ppt1 = new Presentation();
        ppt1.loadFromFile(inputFile_2);
        ISlide slide1 = ppt1.getSlides().get(0);
        //Insert the slide to the specified index in the source presentation
        int index = 1;
        presentation.getSlides().insert(index, slide1);
        //Save the document
        String output = "output/cloneSlideToAnotherPPT.pptx";
        presentation.saveToFile(output, FileFormat.PPTX_2013);
    }
}
