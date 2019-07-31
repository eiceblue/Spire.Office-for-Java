import com.spire.presentation.*;
import com.spire.presentation.collections.ParagraphCollection;
import com.spire.presentation.drawing.FillFormatType;
import java.awt.*;

public class changeTextStyle {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/changeTextStyle.pptx";
        String outputFile = "output/changeTextStyle_result.pptx";

        //Load a PPT document
        Presentation presentation = new Presentation();
        presentation.loadFromFile(inputFile);

        IAutoShape shape = (IAutoShape) presentation.getSlides().get(0).getShapes().get(0);
        ParagraphCollection paras = shape.getTextFrame().getParagraphs();

        //Set the style for the text content in the first paragraph
        ParagraphEx para1 = paras.get(0);
        int max = para1.getTextRanges().getCount();
        for (int i = 0; i < max; i++) {
            para1.getTextRanges().get(i).getFill().setFillType(FillFormatType.SOLID);
            para1.getTextRanges().get(i).getFill().getSolidColor().setColor(Color.green);
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
        presentation.saveToFile(outputFile, FileFormat.PPTX_2007);
    }
}
