import com.spire.presentation.*;

public class removeSlide {
    public static void main(String[] args) throws Exception{
        String inputFile ="data/removeSlide.pptx";
        String outputFile="output/removeSlide_result.pptx";
        Presentation presentation = new Presentation();
        presentation.loadFromFile(inputFile);

        //Remove slide by index
        presentation.getSlides().removeAt(0);

        //Remove the slide by its reference
        ISlide slide = presentation.getSlides().get(1);
        presentation.getSlides().remove(slide);

        //Save the document
        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
        presentation.dispose();
    }
}
