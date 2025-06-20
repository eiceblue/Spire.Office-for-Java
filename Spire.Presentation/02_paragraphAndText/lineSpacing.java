import com.spire.presentation.*;
import com.spire.presentation.drawing.*;

import java.awt.*;

public class lineSpacing {
    public static void main(String[] args) throws Exception {
        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load PPT file from disk
        presentation.loadFromFile("data/template_Az.pptx");
        //Get the first slide
        ISlide slide = presentation.getSlides().get(0);
        //Add a shape
        IAutoShape shape = presentation.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE,
                new Rectangle(50, 100, (int) presentation.getSlideSize().getSize().getWidth() - 100, 300));
        shape.getShapeStyle().getLineColor().setColor(Color.WHITE);
        shape.getFill().setFillType(FillFormatType.NONE);
        shape.getTextFrame().getParagraphs().clear();

        //Add text
        shape.appendTextFrame("Spire.Presentation for Java is a professional PowerPoint API that enables developers"
                + " to create, read, write, convert and save PowerPoint documents in Java Applications. As an independent"
                + " Java library, Spire.Presentation doesn't need Microsoft PowerPoint to be installed on system.");
        //Set font and color of text
        PortionEx textRange = shape.getTextFrame().getTextRange();
        textRange.getFill().setFillType(FillFormatType.SOLID);
        shape.getShapeStyle().getLineColor().setColor(Color.BLUE);
        textRange.setFontHeight(20);
        textRange.setLatinFont(new TextFont("Lucida Sans Unicode"));

        //Set properties of paragraph
        shape.getTextFrame().getParagraphs().get(0).setSpaceBefore(100);
        shape.getTextFrame().getParagraphs().get(0).setSpaceAfter(100);
        shape.getTextFrame().getParagraphs().get(0).setLineSpacing(150);

        String result = "output/lineSpacing.pptx";
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
