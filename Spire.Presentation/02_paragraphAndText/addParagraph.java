import com.spire.presentation.*;
import com.spire.presentation.drawing.*;

import java.awt.*;

public class addParagraph {
    public static void main(String[] args) throws Exception {
        //Create an instance of presentation document
        Presentation ppt = new Presentation();

        //Set background image
        String ImageFile = "Data/bg.png";
        Rectangle rect = new Rectangle(0, 0, (int) ppt.getSlideSize().getSize().getWidth(), (int) ppt.getSlideSize().getSize().getHeight());
        ppt.getSlides().get(0).getShapes().appendEmbedImage(ShapeType.RECTANGLE, ImageFile, rect);
        ppt.getSlides().get(0).getShapes().get(0).getLine().getFillFormat().getSolidFillColor().setColor(Color.white);

        //Append a new shape
        IAutoShape shape = ppt.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, new Rectangle(50, 70, 620, 150));
        shape.getFill().setFillType(FillFormatType.NONE);
        shape.getShapeStyle().getLineColor().setColor(Color.white);

        //Set the alignment of paragraph
        shape.getTextFrame().getParagraphs().get(0).setAlignment(TextAlignmentType.LEFT);
        //Set the indent of paragraph
        shape.getTextFrame().getParagraphs().get(0).setIndent(50);
        //Set the linespacing of paragraph
        shape.getTextFrame().getParagraphs().get(0).setLineSpacing(150);
        //Set the text of paragraph
        shape.getTextFrame().setText("This powerful component suite contains the most up-to-date versions of all .NET WPF Silverlight components offered by E-iceblue.");

        //Set the Font
        shape.getTextFrame().getParagraphs().get(0).getTextRanges().get(0).setLatinFont(new TextFont("Arial Rounded MT Bold"));
        shape.getTextFrame().getParagraphs().get(0).getTextRanges().get(0).getFill().setFillType(FillFormatType.SOLID);
        shape.getTextFrame().getParagraphs().get(0).getTextRanges().get(0).getFill().getSolidColor().setColor(Color.BLACK);

        //Save the document
        String result = "output/addParagraph.pptx";
        ppt.saveToFile(result, FileFormat.PPTX_2013);
    }
}
