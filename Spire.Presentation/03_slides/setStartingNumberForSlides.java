import com.spire.presentation.*;

public class setStartingNumberForSlides {
    public static void main(String[] args) throws Exception {
        String input="data/JAVAPPTSample_1.pptx";
        String result = "output/setStartingNumberForSlides.pptx";

        //Create PPT document
        Presentation presentation = new Presentation();

        //Load the PPT document from disk.
        presentation.loadFromFile(input);

        //Set 5 as the starting number
        presentation.setFirstSlideNumber(5);

        //Save file
        presentation.saveToFile(result, FileFormat.PPTX_2013);
        presentation.dispose();
    }
}
