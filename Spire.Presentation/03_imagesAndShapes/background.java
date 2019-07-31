import com.spire.presentation.*;
import com.spire.presentation.drawing.FillFormatType;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class background {
    public static void main(String[] args) throws Exception {
        String outputFile = "output/background_result.pptx";
        String imageFile = "data/backgroundImg.png";

        //Create a PPT document
        Presentation presentation = new Presentation();

        //Set background Image
        Rectangle2D.Double rect = new Rectangle2D.Double(0, 0, presentation.getSlideSize().getSize().getWidth(), presentation.getSlideSize().getSize().getHeight());
        presentation.getSlides().get(0).getShapes().appendEmbedImage(ShapeType.RECTANGLE, imageFile, rect);

        //Add title
        Rectangle2D.Double rec_title = new Rectangle2D.Double(presentation.getSlideSize().getSize().getWidth() / 2 - 200, 70, 380, 50);
        IAutoShape shape_title = presentation.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, rec_title);
        shape_title.getLine().setFillType(FillFormatType.NONE);
        shape_title.getFill().setFillType(FillFormatType.NONE);

        ParagraphEx para_title = new ParagraphEx();
        para_title.setText("Background Sample");
        para_title.setAlignment(TextAlignmentType.CENTER);
        para_title.getTextRanges().get(0).setLatinFont(new TextFont("Lucida Sans Unicode"));
        para_title.getTextRanges().get(0).setFontHeight(36);
        para_title.getTextRanges().get(0).getFill().setFillType(FillFormatType.SOLID);
        para_title.getTextRanges().get(0).getFill().getSolidColor().setColor(Color.blue);
        shape_title.getTextFrame().getParagraphs().append(para_title);

        //Add new shape to PPT document
        Rectangle2D.Double rec = new Rectangle2D.Double(presentation.getSlideSize().getSize().getWidth() / 2 - 300, 155, 600, 200);
        IAutoShape shape = presentation.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, rec);
        shape.getLine().setFillType(FillFormatType.NONE);
        shape.getFill().setFillType(FillFormatType.NONE);
        ParagraphEx para = new ParagraphEx();
        para.setText("Spire.Presentation for Java is a professional PowerPoint API that enables developers to create, read, write, " +
                "convert and save PowerPoint documents in Java Applications. As an independent Java component, " +
                "Spire.Presentation doesn’t need Microsoft PowerPoint to be installed on system.");
        para.getTextRanges().get(0).getFill().setFillType(FillFormatType.SOLID);
        para.getTextRanges().get(0).getFill().getSolidColor().setColor(Color.white);
        para.getTextRanges().get(0).setFontHeight(26);
        shape.getTextFrame().getParagraphs().append(para);

        //Save the document
        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);

    }
}
