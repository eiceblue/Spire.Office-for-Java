import com.spire.presentation.*;
import com.spire.presentation.drawing.*;

import java.awt.*;

public class setTextMargins {
    public static void main(String[] args) throws Exception {
        //Create an instance of presentation document
        Presentation ppt = new Presentation();

        //Set background image
        String imageFile = "data/bg.png";
        Rectangle rect = new Rectangle(0, 0, (int) ppt.getSlideSize().getSize().getWidth(),
                (int) ppt.getSlideSize().getSize().getHeight());
        ppt.getSlides().get(0).getShapes().appendEmbedImage(ShapeType.RECTANGLE, imageFile, rect);
        ppt.getSlides().get(0).getShapes().get(0).getLine().getFillFormat().getSolidFillColor().setColor(Color.WHITE);

        //Append a new shape
        IAutoShape shape = ppt.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, new Rectangle(50, 100, 450, 150));

        //Set margins for text inside shapes
        shape.getShapeStyle().getLineColor().setColor(Color.cyan);
        shape.getFill().setFillType(FillFormatType.NONE);
        shape.getTextFrame().getParagraphs().get(0).setAlignment(TextAlignmentType.JUSTIFY);
        shape.getTextFrame().setText("Using Spire.Presentation, developers will find an easy and effective" +
                " method to create, read, write, modify, convert and print PowerPoint files on any" +
                " .Net platform. It's worthwhile for you to try this amazing product.");
        shape.getTextFrame().getParagraphs().get(0).getTextRanges().get(0).setLatinFont(new TextFont("Arial"));
        shape.getTextFrame().getParagraphs().get(0).getTextRanges().get(0).getFill().setFillType(FillFormatType.SOLID);
        shape.getTextFrame().getParagraphs().get(0).getTextRanges().get(0).getFill().getSolidColor().setColor(Color.BLACK);

        //Set the margins for the text frame
        shape.getTextFrame().setMarginTop(10);
        shape.getTextFrame().setMarginBottom(35);
        shape.getTextFrame().setMarginLeft(15);
        shape.getTextFrame().setMarginRight(30);

        //Save the document
        String result = "output/setTextMargins.pptx";
        ppt.saveToFile(result, FileFormat.PPTX_2013);
    }
}
