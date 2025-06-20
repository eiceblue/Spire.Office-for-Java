import com.spire.presentation.*;
import com.spire.presentation.drawing.FillFormatType;
import java.awt.*;

public class replaceAndFormatText {
    public static void main(String[] args) throws Exception {

        String inputFile = "data/extractText.pptx";
        String outputFile =  "replaceAndFormatText_out.pptx";

        // Load a PowerPoint presentation from the specified file
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);

        // Create a new object to store the default text range formatting properties.
        PortionFormatEx format = new PortionFormatEx();

        // Set the IsBold property of the text range formatting to true, making the text bold.
        format.isBold(TriState.TRUE);

        // Set the FillType property of the text range fill to Solid, indicating a solid fill color.
        format.getFill().setFillType(FillFormatType.SOLID);

        // Set the Color property of the solid fill color to red.
        format.getFill().getSolidColor().setColor(Color.red);

        // Set the FontHeight property of the text range formatting to 45, indicating the font size.
        format.setFontHeight(45);

        // Replace all occurrences of the text "Spire.Presentation" with "Spire.PPT" and apply the specified formatting.
        ppt.ReplaceAndFormatText("Spire.Presentation", "Spire.PPT", format);

        // Save the modified presentation
        ppt.saveToFile(outputFile, FileFormat.PPTX_2016);

        // Dispose of the Presentation object
        ppt.dispose();
    }


}
