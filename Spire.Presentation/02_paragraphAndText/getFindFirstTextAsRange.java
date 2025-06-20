import com.spire.presentation.*;
import com.spire.presentation.drawing.FillFormatType;
import java.awt.*;


public class getFindFirstTextAsRange {
    public static void main(String[] args) throws Exception {

        String inputFile = "data/ExtractText.pptx";
        String outputFile =  "getFindFirstTextAsRange_out.pptx";

        // Load a PowerPoint presentation from the specified file
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);

        // Fine the specified text in the first shape
        String text = "Spire.Presentation";
        PortionEx textRange=ppt.getSlides().get(0).getFindFirstTextAsRange(text);

        // Set text formart
        textRange.getFill().setFillType(FillFormatType.SOLID);
        textRange.getFill().getSolidColor().setColor(Color.red);
        textRange.setFontHeight(28);
        textRange.setLatinFont(new TextFont("Arial"));
        textRange.isItalic(TriState.TRUE);
        textRange.setTextUnderlineType(TextUnderlineType.DOUBLE);

        // Save the modified presentation
        ppt.saveToFile(outputFile, FileFormat.PPTX_2016);

        // Dispose of the Presentation object
        ppt.dispose();
    }


}
