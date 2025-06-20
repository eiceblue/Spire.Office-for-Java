import com.spire.presentation.*;

public class replaceTextRetentionStyle {
    public static void main(String[] args) throws Exception {
        String inputFile="data/somePresentation.pptx";
        String outputFile = "output/replaceTextRetentionStyle_result.pptx";

        //Create PPT document and load file
        Presentation presentation = new Presentation();
        presentation.loadFromFile(inputFile);

        presentation.getSlides().get(0).replaceFirstText("use", "test", true);

        presentation.getSlides().get(1).replaceAllText("Spire", "new spire", true);

        //Save to file
        presentation.saveToFile(outputFile, FileFormat.PPTX_2013);
    }
}
