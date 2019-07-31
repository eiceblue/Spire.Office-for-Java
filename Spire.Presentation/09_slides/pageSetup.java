import com.spire.presentation.*;
import com.spire.presentation.drawing.FillFormatType;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class pageSetup {
    public static void main(String[] args) throws Exception{
        String ImageFile = "data/bg.png";
        String outputFile = "output/pageSetup.pptx";
        //Create PPT document
        Presentation ppt = new Presentation();

        //Set the size of slides
        ppt.setPageSize(600,600,false);
        ppt.getSlideSize().setOrientation(SlideOrienation.PORTRAIT);
        ppt.getSlideSize().setType(SlideSizeType.CUSTOM);

        //Set background image
        Rectangle2D.Double rect = new Rectangle2D.Double(0, 0, ppt.getSlideSize().getSize().getWidth(), ppt.getSlideSize().getSize().getHeight());
        ppt.getSlides().get(0).getShapes().appendEmbedImage(ShapeType.RECTANGLE, ImageFile, rect);
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
        para_title.getTextRanges().get(0).getFill().getSolidColor().setColor(Color.black);
        shape_title.getTextFrame().getParagraphs().append(para_title);

        //Save the document
        ppt.saveToFile(outputFile, FileFormat.PPTX_2010);
    }
}
