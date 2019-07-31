import com.spire.presentation.*;

public class removeSlide {
    public static void main(String[] args) throws Exception{
        String inputFile ="data/removeSlide.pptx";
        String outputFile="output/removeSlide_result.pptx";
        Presentation presentation = new Presentation();
        presentation.loadFromFile(inputFile);
        //Remove the second slide
        presentation.getSlides().removeAt(1);
        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
        presentation.dispose();
    }
}
