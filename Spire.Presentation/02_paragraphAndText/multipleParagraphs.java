import com.spire.presentation.*;
import com.spire.presentation.drawing.*;

import java.awt.*;

public class multipleParagraphs {
    public static void main(String[] args) throws Exception {
        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load PPT file from disk
        presentation.loadFromFile("data/template_Az.pptx");
        //Access the first slide
        ISlide slide = presentation.getSlides().get(0);

        // Add an AutoShape of rectangle type
        Rectangle rec = new Rectangle((int) presentation.getSlideSize().getSize().getWidth() / 2 - 250, 150, 500, 150);
        IAutoShape shape = presentation.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, rec);

        // Access TextFrame of the AutoShape
        ITextFrameProperties tf = shape.getTextFrame();

        // Create Paragraphs and PortionExs with different text formats
        ParagraphEx para0 = tf.getParagraphs().get(0);
        PortionEx PortionEx1 = new PortionEx();
        PortionEx PortionEx2 = new PortionEx();
        para0.getTextRanges().append(PortionEx1);
        para0.getTextRanges().append(PortionEx2);

        ParagraphEx para1 = new ParagraphEx();
        tf.getParagraphs().append(para1);
        PortionEx PortionEx11 = new PortionEx();
        PortionEx PortionEx12 = new PortionEx();
        PortionEx PortionEx13 = new PortionEx();
        para1.getTextRanges().append(PortionEx11);
        para1.getTextRanges().append(PortionEx12);
        para1.getTextRanges().append(PortionEx13);

        ParagraphEx para2 = new ParagraphEx();
        tf.getParagraphs().append(para2);
        PortionEx PortionEx21 = new PortionEx();
        PortionEx PortionEx22 = new PortionEx();
        PortionEx PortionEx23 = new PortionEx();
        para2.getTextRanges().append(PortionEx21);
        para2.getTextRanges().append(PortionEx22);
        para2.getTextRanges().append(PortionEx23);

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                tf.getParagraphs().get(i).getTextRanges().get(j).setText("TextRange " + j);
                if (j == 0) {
                    tf.getParagraphs().get(i).getTextRanges().get(j).getFill().setFillType(FillFormatType.SOLID);
                    tf.getParagraphs().get(i).getTextRanges().get(j).getFill().getSolidColor().setColor(Color.cyan);
                    tf.getParagraphs().get(i).getTextRanges().get(j).getFormat().isBold(TriState.TRUE);
                    tf.getParagraphs().get(i).getTextRanges().get(j).setFontHeight(15);
                } else if (j == 1) {
                    tf.getParagraphs().get(i).getTextRanges().get(j).getFill().setFillType(FillFormatType.SOLID);
                    tf.getParagraphs().get(i).getTextRanges().get(j).getFill().getSolidColor().setColor(Color.BLUE);
                    tf.getParagraphs().get(i).getTextRanges().get(j).getFormat().isBold(TriState.TRUE);
                    tf.getParagraphs().get(i).getTextRanges().get(j).setFontHeight(18);
                }
            }


        String result = "output/multipleParagraphs.pptx";
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
