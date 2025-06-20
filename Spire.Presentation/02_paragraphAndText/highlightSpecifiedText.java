import com.spire.presentation.*;

import java.awt.*;

public class highlightSpecifiedText {
    public static void main(String[] args) throws Exception {
        String inputFile="data/somePresentation.pptx";
        String outputFile = "output/highlightSpecifiedText_result.pptx";

        //Create PPT document and load file
        Presentation presentation = new Presentation();
        presentation.loadFromFile(inputFile);

        //Get the specified shape
        IAutoShape shape = (IAutoShape)presentation.getSlides().get(0).getShapes().get(1);

        //Set highlight options
        TextHighLightingOptions options = new TextHighLightingOptions();
        options.setWholeWordsOnly(true);
        options.setCaseSensitive(true);

        //Highlight text
        shape.getTextFrame().highLightText("Spire", Color.yellow, options);

        //Save to file.
        presentation.saveToFile(outputFile, FileFormat.PPTX_2013);
    }
}
