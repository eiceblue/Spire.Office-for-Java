import com.spire.presentation.*;
import com.spire.presentation.drawing.FillFormatType;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;

public class insertVideo {
    public static void main(String[] args) throws Exception {

        String inputFile = "data/insertVideo.pptx";
        String inputFile_1 = "data/Video.mp4";
        String imageFile = "data/Video.png";
        String outputFile = "output/insertVideo_result.pptx";

        Presentation presentation = new Presentation();
        presentation.loadFromFile(inputFile);
        //Add title
        Rectangle2D.Double rec_title = new Rectangle2D.Double(50, 280, 160, 50);
        IAutoShape shape_title = presentation.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, rec_title);
        shape_title.getLine().setFillType(FillFormatType.NONE);

        shape_title.getFill().setFillType(FillFormatType.NONE);
        ParagraphEx para_title = new ParagraphEx();
        para_title.setText("Video:");
        para_title.setAlignment(TextAlignmentType.CENTER);
        para_title.getTextRanges().get(0).setLatinFont(new TextFont("Myriad Pro Light"));
        para_title.getTextRanges().get(0).setFontHeight(32);
        para_title.getTextRanges().get(0).isBold(TriState.TRUE);
        para_title.getTextRanges().get(0).getFill().setFillType(FillFormatType.SOLID);
        para_title.getTextRanges().get(0).getFill().getSolidColor().setColor(Color.gray);
        shape_title.getTextFrame().getParagraphs().append(para_title);

        //Insert video into the document
        Rectangle2D.Double videoRect = new Rectangle2D.Double(presentation.getSlideSize().getSize().getWidth() / 2 - 125, 240, 150, 150);
        IVideo video = presentation.getSlides().get(0).getShapes().appendVideoMedia((new java.io.File(inputFile_1)).getAbsolutePath(), videoRect);
        BufferedImage image = ImageIO.read( new File(imageFile));
        video.getPictureFill().getPicture().setEmbedImage(presentation.getImages().append(image));

        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
        presentation.dispose();
    }
}
