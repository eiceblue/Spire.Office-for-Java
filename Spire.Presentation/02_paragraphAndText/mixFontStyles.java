import com.spire.presentation.*;
import com.spire.presentation.drawing.*;

import java.awt.*;

public class mixFontStyles {
    public static void main(String[] args) throws Exception {
        //Create an instance of presentation document
        Presentation ppt = new Presentation();
        //Load file
        ppt.loadFromFile("data/fontStyle.pptx");

        //Get the second shape of the first slide
        IAutoShape shape = (IAutoShape) ppt.getSlides().get(0).getShapes().get(0);

        //Remove the paragraph from TextRange
        ParagraphEx tp = shape.getTextFrame().getTextRange().getParagraph();

        //Append normal text that is in front of 'bold' to the paragraph
        PortionEx tr = new PortionEx("\r\nHere is testing text. Only a few words are in ");
        tp.getTextRanges().append(tr);
        //Set font style of the text 'bold' as bold
        tr = new PortionEx("bold");
        tr.isBold(TriState.TRUE);
        tp.getTextRanges().append(tr);

        //Append normal text that is in front of 'red' to the paragraph
        tr = new PortionEx(", some are in ");
        tp.getTextRanges().append(tr);
        //Set the color of the text 'red' as red
        tr = new PortionEx("red");
        tr.getFill().setFillType(FillFormatType.SOLID);
        tr.getFormat().getFill().getSolidColor().setColor(Color.RED);
        tp.getTextRanges().append(tr);

        //Append normal text that is in front of 'underlined' to the paragraph
        tr = new PortionEx(" color, some are ");
        tp.getTextRanges().append(tr);
        //Underline the text 'undelined'
        tr = new PortionEx("underlined");
        tr.setTextUnderlineType(TextUnderlineType.SINGLE);
        tp.getTextRanges().append(tr);

        //Append normal text that is in front of 'bigger font size' to the paragraph
        tr = new PortionEx(", and some are in ");
        tp.getTextRanges().append(tr);
        //Set a large font for the text 'bigger font size'
        tr = new PortionEx("bigger font size");
        tr.setFontHeight(35);
        tp.getTextRanges().append(tr);

        //Append other normal text
        tr = new PortionEx(".");
        tp.getTextRanges().append(tr);

        //Save the document
        String result = "output/mixFontStyles.pptx";
        ppt.saveToFile(result, FileFormat.PPTX_2013);
    }
}
