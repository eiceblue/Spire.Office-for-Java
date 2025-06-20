
import com.spire.presentation.*;
import com.spire.presentation.drawing.FillFormatType;
import java.awt.*;


public class hyperlinkOutlineStyle {
    public static void main(String[] args) throws Exception {
        String outputFile = "output/hyperlinkOutlineStyle-result.pptx";

        //Create PPT document
        Presentation presentation = new Presentation();

        //Add new shape to PPT document
        Rectangle rec = new Rectangle((int)presentation.getSlideSize().getSize().getWidth() / 2 - 250, 120, 400, 100);
        IAutoShape shape = presentation.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, rec);

        shape.getFill().setFillType(FillFormatType.NONE);
        shape.getLine().setFillType(FillFormatType.NONE);

        //Add some paragraphs with hyperlinks
        ParagraphEx para1 = new ParagraphEx();
        PortionEx tr1 = new PortionEx();
        tr1.setText("Click to know more about Spire.Presentation.");
        tr1.getClickAction().setAddress("https://www.e-iceblue.com/Introduce/presentation-for-java.html");
        para1.getTextRanges().append(tr1);

        tr1.getFormat().isItalic(TriState.TRUE);
        tr1.getFormat().setFontMinSize(20);

        //Set the outline format of text range
        tr1.getTextLineFormat().getFillFormat().setFillType(FillFormatType.SOLID);
        tr1.getTextLineFormat().getFillFormat().getSolidFillColor().setColor(Color.lightGray);
        tr1.getTextLineFormat().setJoinStyle(LineJoinType.ROUND);
        tr1.getTextLineFormat().setWidth(2);

        //Add the paragraph to shape
        shape.getTextFrame().getParagraphs().append(para1);
        shape.getTextFrame().getParagraphs().append(new ParagraphEx());

        //Save the document
        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
    }
}
