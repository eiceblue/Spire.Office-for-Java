import com.spire.presentation.*;

public class hideSlide {
    public static void main(String[] args) throws Exception{
        String inputFile = "data/hideSlide.pptx";
        String outputFile = "output/hideSlide_result.pptx";
        //Create a PPT document and load PPT file from disk
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);
        //Hide the second slide
        ppt.getSlides().get(1).setHidden(true);
        //Save the document
        ppt.saveToFile(outputFile, FileFormat.PPTX_2010);
        ppt.dispose();
    }
}
