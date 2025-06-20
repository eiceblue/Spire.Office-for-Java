import com.spire.presentation.*;
import com.spire.presentation.drawing.*;

import java.awt.*;

public class superscriptAndSubscript {
    public static void main(String[] args) throws Exception {
        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load PPT file from disk
        presentation.loadFromFile("data/template_Az.pptx");
        //Get the first slide
        ISlide slide = presentation.getSlides().get(0);
        //Add a shape
        IAutoShape shape = presentation.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, new Rectangle(150, 100, 200, 50));
        shape.getFill().setFillType(FillFormatType.NONE);
        shape.getShapeStyle().getLineColor().setColor(Color.white);
        shape.getTextFrame().getParagraphs().clear();

        shape.appendTextFrame("Test");
        PortionEx tr = new PortionEx("superscript");
        shape.getTextFrame().getParagraphs().get(0).getTextRanges().append(tr);

        //Set superscript text
        shape.getTextFrame().getParagraphs().get(0).getTextRanges().get(1).getFormat().setScriptDistance(30);

        PortionEx textRange = shape.getTextFrame().getParagraphs().get(0).getTextRanges().get(0);
        textRange.getFill().setFillType(FillFormatType.SOLID);
        textRange.getFill().getSolidColor().setColor(Color.BLACK);
        textRange.setFontHeight(20);
        textRange.setLatinFont(new TextFont("Arial"));

        textRange = shape.getTextFrame().getParagraphs().get(0).getTextRanges().get(1);
        textRange.getFill().setFillType(FillFormatType.SOLID);
        textRange.getFill().getSolidColor().setColor(Color.BLUE);
        textRange.setLatinFont(new TextFont("Arial"));


        shape = presentation.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, new Rectangle(150, 150, 200, 50));
        shape.getFill().setFillType(FillFormatType.NONE);
        shape.getShapeStyle().getLineColor().setColor(Color.white);
        shape.getTextFrame().getParagraphs().clear();

        shape.appendTextFrame("Test");
        tr = new PortionEx("subscript");
        shape.getTextFrame().getParagraphs().get(0).getTextRanges().append(tr);

        //Set subscript text
        shape.getTextFrame().getParagraphs().get(0).getTextRanges().get(1).getFormat().setScriptDistance(-25);

        textRange = shape.getTextFrame().getParagraphs().get(0).getTextRanges().get(0);
        textRange.getFill().setFillType(FillFormatType.SOLID);
        textRange.getFill().getSolidColor().setColor(Color.BLACK);
        textRange.setFontHeight(20);
        textRange.setLatinFont(new TextFont("Arial"));


        textRange = shape.getTextFrame().getParagraphs().get(0).getTextRanges().get(1);
        textRange.getFill().setFillType(FillFormatType.SOLID);
        textRange.getFill().getSolidColor().setColor(Color.BLUE);
        textRange.setLatinFont(new TextFont("Arial"));


        String result = "output/superscriptAndSubscript.pptx";
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
