import com.spire.presentation.*;
import com.spire.presentation.drawing.FillFormatType;
import java.awt.*;
import java.awt.geom.*;
public class hyperlinks {
    public static void main(String[] args) throws Exception {
        String outputFile = "output/hyperlink_result.pptx";
        String imageFile = "data/bg.png";

        //Create a PPT document
        Presentation presentation = new Presentation();

        //Set background Image
        Rectangle2D.Double rect = new Rectangle2D.Double(0, 0, presentation.getSlideSize().getSize().getWidth(), presentation.getSlideSize().getSize().getHeight());
        presentation.getSlides().get(0).getShapes().appendEmbedImage(ShapeType.RECTANGLE, imageFile, rect);

        //Add new shape to PPT document
        Rectangle2D.Double rec = new Rectangle2D.Double(presentation.getSlideSize().getSize().getWidth() / 2 - 255, 120, 500, 280);
        IAutoShape shape = presentation.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, rec);
        shape.getFill().setFillType(FillFormatType.NONE);
        shape.getLine().setWidth(0);

        //Add some paragraphs with hyperlinks
        ParagraphEx para1 = new ParagraphEx();
        PortionEx tr1 = new PortionEx();
        tr1.setText("E-iceblue");
        para1.getTextRanges().append(tr1);
        shape.getTextFrame().getParagraphs().append(para1);
        para1.setAlignment(TextAlignmentType.CENTER);
        //Set the font and fill style of text
        tr1.getFill().setFillType(FillFormatType.SOLID);
        tr1.getFill().getSolidColor().setColor(Color.blue);
        shape.getTextFrame().getParagraphs().append(new ParagraphEx());

        //Add some paragraphs with hyperlinks
        ParagraphEx para2 = new ParagraphEx();
        PortionEx tr2 = new PortionEx();
        tr2.setText("Click to know more about Spire.Presentation.");
        tr2.getClickAction().setAddress("https://www.e-iceblue.com/Introduce/presentation-for-java.html");
        para2.getTextRanges().append(tr2);
        shape.getTextFrame().getParagraphs().append(para2);
        shape.getTextFrame().getParagraphs().append(new ParagraphEx());

        ParagraphEx para3 = new ParagraphEx();
        PortionEx tr3 = new PortionEx();
        tr3.setText("Click to visit E-iceblue Home page.");
        tr3.getClickAction().setAddress("https://www.e-iceblue.com/");
        para3.getTextRanges().append(tr3);
        shape.getTextFrame().getParagraphs().append(para3);
        shape.getTextFrame().getParagraphs().append(new ParagraphEx());

        ParagraphEx para4 = new ParagraphEx();
        PortionEx tr4 = new PortionEx();
        tr4.setText("Click to go to the forum to raise questions.");
        tr4.getClickAction().setAddress("https://www.e-iceblue.com/forum/components-f5.html");
        para4.getTextRanges().append(tr4);
        shape.getTextFrame().getParagraphs().append(para4);
        shape.getTextFrame().getParagraphs().append(new ParagraphEx());

        ParagraphEx para5 = new ParagraphEx();
        PortionEx tr5 = new PortionEx();
        tr5.setText("Click to contact our sales team via email. ");
        tr5.getClickAction().setAddress("mailto:sales@e-iceblue.com");
        para5.getTextRanges().append(tr5);
        shape.getTextFrame().getParagraphs().append(para5);
        shape.getTextFrame().getParagraphs().append(new ParagraphEx());

        ParagraphEx para6 = new ParagraphEx();
        PortionEx tr6 = new PortionEx();
        tr6.setText("Click to contact our support team via email. ");
        tr6.getClickAction().setAddress("mailto:support@e-iceblue.com");
        para6.getTextRanges().append(tr6);
        shape.getTextFrame().getParagraphs().append(para6);


        for (Object para : shape.getTextFrame().getParagraphs()) {
            ParagraphEx paragraph = (ParagraphEx) para;
            String text = paragraph.getText();
            if (text != null && text.length() != 0) {
                paragraph.getTextRanges().get(0).setLatinFont(new TextFont("Lucida Sans Unicode"));
                paragraph.getTextRanges().get(0).setFontHeight(20);
            }
        }
        //Save the document
        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
    }
}
