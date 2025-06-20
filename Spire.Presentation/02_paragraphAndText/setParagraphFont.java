import com.spire.presentation.*;
import com.spire.presentation.drawing.*;

import java.awt.*;

public class setParagraphFont {
    public static void main(String[] args) throws Exception {
        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load PPT file from disk
        presentation.loadFromFile("data/template_Az2.pptx");
        //Get the first slide
        ISlide slide = presentation.getSlides().get(0);

        //Access the first and second placeholder in the slide and typecasting it as AutoShape
        ITextFrameProperties tf1 = ((IAutoShape) slide.getShapes().get(0)).getTextFrame();
        ITextFrameProperties tf2 = ((IAutoShape) slide.getShapes().get(1)).getTextFrame();

        // Access the first Paragraph
        ParagraphEx para1 = tf1.getParagraphs().get(0);
        ParagraphEx para2 = tf2.getParagraphs().get(0);

        //Justify the paragraph
        para2.setAlignment(TextAlignmentType.JUSTIFY);

        //Access the first text range
        PortionEx textRange1 = para1.getFirstTextRange();
        PortionEx textRange2 = para2.getFirstTextRange();

        //Define new fonts
        TextFont fd1 = new TextFont("Elephant");
        TextFont fd2 = new TextFont("Castellar");

        // Assign new fonts to text range
        textRange1.setLatinFont(fd1);
        textRange2.setLatinFont(fd2);

        // Set font to Bold
        textRange1.getFormat().isBold(TriState.TRUE);
        textRange2.getFormat().isBold(TriState.FALSE);

        // Set font to Italic
        textRange1.getFormat().isItalic(TriState.FALSE);
        textRange2.getFormat().isItalic(TriState.TRUE);

        // Set font color
        textRange1.getFill().setFillType(FillFormatType.SOLID);
        textRange1.getFill().getSolidColor().setColor(Color.blue);
        textRange1.getFill().setFillType(FillFormatType.SOLID);
        textRange2.getFill().getSolidColor().setColor(Color.ORANGE);

        String result = "output/setParagraphFont.pptx";
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
