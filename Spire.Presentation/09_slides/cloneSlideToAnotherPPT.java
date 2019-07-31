import com.spire.presentation.*;

public class cloneSlideToAnotherPPT {
    public static void main(String[] args) throws Exception{
        String inputFile_1 = "data/cloneSlideToAnotherPPT-2.pptx";
        String inputFile_2 = "data/cloneSlideToAnotherPPT-1.pptx";
        String outputFile = "output/cloneSlideToAnotherPPT_result.pptx";
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
        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
        presentation.dispose();
    }
}
