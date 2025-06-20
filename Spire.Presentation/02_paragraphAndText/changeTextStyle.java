import com.spire.presentation.*;
import com.spire.presentation.collections.*;
import com.spire.presentation.drawing.*;

import java.awt.*;

public class changeTextStyle {
    public static void main(String[] args) throws Exception {
        //Load a PPT document
        Presentation presentation = new Presentation();
        presentation.loadFromFile("data/changeTextStyle.pptx");

        IAutoShape shape = (IAutoShape) presentation.getSlides().get(0).getShapes().get(0);
        ParagraphCollection paras = shape.getTextFrame().getParagraphs();

        //Set the style for the text content in the first paragraph
        ParagraphEx para1 = paras.get(0);
        int max = para1.getTextRanges().getCount();
        for (int i = 0; i < max; i++) {
            para1.getTextRanges().get(i).getFill().setFillType(FillFormatType.SOLID);
            para1.getTextRanges().get(i).getFill().getSolidColor().setColor(Color.GREEN);
            para1.getTextRanges().get(i).setLatinFont(new TextFont("Lucida Sans Unicode"));
            para1.getTextRanges().get(i).setFontHeight(14);
        }

        //Set the style for the text content in the third paragraph
        ParagraphEx para3 = paras.get(2);
        max = para3.getTextRanges().getCount();
        for (int i = 0; i < max; i++) {
            para3.getTextRanges().get(i).getFill().setFillType(FillFormatType.SOLID);
            para3.getTextRanges().get(i).getFill().getSolidColor().setColor(Color.blue);
            para3.getTextRanges().get(i).setLatinFont(new TextFont("Calibri"));
            para3.getTextRanges().get(i).setFontHeight(16);
            para3.getTextRanges().get(i).setTextUnderlineType(TextUnderlineType.DASHED);
        }

        //Save the document
        String output = "output/changeTextStyle.pptx";
        presentation.saveToFile(output, FileFormat.PPTX_2013);
    }
}
