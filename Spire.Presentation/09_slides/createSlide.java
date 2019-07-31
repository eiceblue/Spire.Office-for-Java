import com.spire.presentation.*;
import com.spire.presentation.drawing.FillFormatType;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class createSlide {
    public static void main(String[] args) throws Exception {
        String ImageFile = "data/bg.png";
        String outputFile = "output/createSlide.pptx";
        Presentation ppt = new Presentation();
        //Add new slide
        ppt.getSlides().append();
        //Set the background image
        for (int i = 0; i < 2; i++) {
            Rectangle2D.Double rect = new Rectangle2D.Double(0, 0, ppt.getSlideSize().getSize().getWidth(), ppt.getSlideSize().getSize().getHeight());
            ppt.getSlides().get(i).getShapes().appendEmbedImage(ShapeType.RECTANGLE, ImageFile, rect);
            ppt.getSlides().get(i).getShapes().get(0).getLine().getFillFormat().getSolidFillColor().setColor(Color.white);
        }
        //Add title
        Rectangle2D.Double rec_title = new Rectangle2D.Double(ppt.getSlideSize().getSize().getWidth() / 2 - 200, 70, 400, 50);
        IAutoShape shape_title = ppt.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, rec_title);
        shape_title.getShapeStyle().getLineColor().setColor(Color.white);
        shape_title.getFill().setFillType(FillFormatType.NONE);
        ParagraphEx para_title = new ParagraphEx();
        para_title.setText("E-iceblue");
        para_title.setAlignment(TextAlignmentType.CENTER);
        para_title.getTextRanges().get(0).setLatinFont(new TextFont("Myriad Pro Light"));
        para_title.getTextRanges().get(0).setFontHeight(36);
        para_title.getTextRanges().get(0).getFill().setFillType(FillFormatType.SOLID);
        para_title.getTextRanges().get(0).getFill().getSolidColor().setColor(Color.darkGray);
        shape_title.getTextFrame().getParagraphs().append(para_title);

        //Append new shape
        IAutoShape shape = ppt.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, new Rectangle2D.Double(50, 150, 600, 280));
        shape.getShapeStyle().getLineColor().setColor(Color.white);
        shape.getFill().setFillType(FillFormatType.NONE);
        shape.getLine().setFillType(FillFormatType.NONE);
        //Add text to shape
        shape.appendTextFrame("Welcome to use Spire.Presentation for JAVA");

        //Add new paragraph
        ParagraphEx pare = new ParagraphEx();
        pare.setText("");
        shape.getTextFrame().getParagraphs().append(pare);

        //Add new paragraph
        pare = new ParagraphEx();
        pare.setText("Spire.Presentation for Java is a professional PowerPoint API that enables developers to create, read, write, convert " +
                "and save PowerPoint documents in Java Applications. As an independent Java component, " +
                "Spire.Presentation doesn’t need Microsoft PowerPoint to be installed on system.");
        shape.getTextFrame().getParagraphs().append(pare);

        //Set the Font
        for (Object para : shape.getTextFrame().getParagraphs()) {
            ((ParagraphEx) para).getTextRanges().get(0).setLatinFont(new TextFont("Myriad Pro"));
            ((ParagraphEx) para).getTextRanges().get(0).setFontHeight(24);
            ((ParagraphEx) para).getTextRanges().get(0).getFill().setFillType(FillFormatType.SOLID);
            ((ParagraphEx) para).getTextRanges().get(0).getFill().getSolidColor().setColor(Color.darkGray);
            ((ParagraphEx) para).setAlignment(TextAlignmentType.LEFT);
        }

        //Append new shape - SixPointedStar
        shape = ppt.getSlides().get(1).getShapes().appendShape(ShapeType.SIX_POINTED_STAR, new Rectangle2D.Double(100, 100, 100, 100));
        shape.getFill().setFillType(FillFormatType.SOLID);
        shape.getFill().getSolidColor().setColor(Color.orange);
        shape.getShapeStyle().getLineColor().setColor(Color.white);

        //Append new shape
        shape = ppt.getSlides().get(1).getShapes().appendShape(ShapeType.RECTANGLE, new Rectangle2D.Double(50, 250, 600, 50));
        shape.getShapeStyle().getLineColor().setColor(Color.white);
        shape.getFill().setFillType(FillFormatType.NONE);

        //Add text to shape
        shape.appendTextFrame("This is a newly added Slide.");

        //Set the Font
        shape.getTextFrame().getParagraphs().get(0).getTextRanges().get(0).setLatinFont(new TextFont("Myriad Pro"));
        shape.getTextFrame().getParagraphs().get(0).getTextRanges().get(0).setFontHeight(24);
        shape.getTextFrame().getParagraphs().get(0).getTextRanges().get(0).getFill().setFillType(FillFormatType.SOLID);
        shape.getTextFrame().getParagraphs().get(0).getTextRanges().get(0).getFill().getSolidColor().setColor(Color.black);
        shape.getTextFrame().getParagraphs().get(0).setAlignment(TextAlignmentType.LEFT);
        shape.getTextFrame().getParagraphs().get(0).setIndent(35);

        //Save the document
        ppt.saveToFile(outputFile, FileFormat.PPTX_2013);
        ppt.dispose();
    }
}
