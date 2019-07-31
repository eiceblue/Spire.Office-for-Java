import com.spire.presentation.*;
import com.spire.presentation.drawing.FillFormatType;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class insertAudio {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/insertAudio.pptx";
        String inputFile_1 = "data/Music.wav";
        String outputFile = "output/insertAudio_result.pptx";

        Presentation presentation = new Presentation();
        presentation.loadFromFile(inputFile);
        //Add title
        Rectangle2D.Double rec_title = new Rectangle2D.Double(50, 240, 160, 50);
        IAutoShape shape_title = presentation.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, rec_title);
        shape_title.getLine().setFillType(FillFormatType.NONE);

        shape_title.getFill().setFillType(FillFormatType.NONE);
        ParagraphEx para_title = new ParagraphEx();
        para_title.setText("Audio:");
        para_title.setAlignment(TextAlignmentType.CENTER);
        para_title.getTextRanges().get(0).setLatinFont(new TextFont("Myriad Pro Light"));
        para_title.getTextRanges().get(0).setFontHeight(32);
        para_title.getTextRanges().get(0).isBold(TriState.TRUE);
        para_title.getTextRanges().get(0).getFill().setFillType(FillFormatType.SOLID);
        para_title.getTextRanges().get(0).getFill().getSolidColor().setColor(Color.gray);
        shape_title.getTextFrame().getParagraphs().append(para_title);

        //Insert audio into the document
        Rectangle2D.Double audioRect = new Rectangle2D.Double(220, 240, 80, 80);
        presentation.getSlides().get(0).getShapes().appendAudioMedia((new java.io.File(inputFile_1)).getAbsolutePath(), audioRect);

        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
        presentation.dispose();
    }
}