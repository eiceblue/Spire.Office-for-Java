import com.spire.presentation.*;
import com.spire.presentation.drawing.*;

import java.awt.*;

public class setTextFontProperties {
    public static void main(String[] args) throws Exception {
        //Create a PPT document
        Presentation presentation = new Presentation();

        //Add a new shape to the PPT document
        Rectangle rec = new Rectangle((int) presentation.getSlideSize().getSize().getWidth() / 2 - 250, 80, 500, 150);
        IAutoShape shape = presentation.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, rec);

        shape.getShapeStyle().getLineColor().setColor(Color.white);
        shape.getFill().setFillType(FillFormatType.NONE);

        //Add text to the shape
        shape.appendTextFrame("Welcome to use Spire.Presentation");

        PortionEx textRange = shape.getTextFrame().getTextRange();
        //Set the font
        textRange.setLatinFont(new TextFont("Times New Roman"));
        //Set bold property of the font
        textRange.isBold(TriState.TRUE);

        //Set italic property of the font
        textRange.isItalic(TriState.TRUE);

        //Set underline property of the font
        textRange.setTextUnderlineType(TextUnderlineType.SINGLE);

        //Set the height of the font
        textRange.setFontHeight(50);

        //Set the color of the font
        textRange.getFill().setFillType(FillFormatType.SOLID);
        textRange.getFill().getSolidColor().setColor(Color.cyan);

        String result = "output/setTextFontProperties.pptx";
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
