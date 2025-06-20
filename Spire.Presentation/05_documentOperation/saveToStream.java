import com.spire.presentation.*;
import com.spire.presentation.drawing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.*;

public class saveToStream {
    public static void main(String[] args) throws Exception {
        String ImageFile = "data/bg.png";
        String output = "output/saveToStream.pptx";

        //create PowerPoint file and save it to stream
        Presentation presentation = new Presentation();

        //set background Image
        Rectangle2D rect = new Rectangle2D.Double(0, 0, presentation.getSlideSize().getSize().getWidth(), presentation.getSlideSize().getSize().getHeight());
        presentation.getSlides().get(0).getShapes().appendEmbedImage(ShapeType.RECTANGLE, ImageFile, rect);
        presentation.getSlides().get(0).getShapes().get(0).getLine().getFillFormat().getSolidFillColor().setColor(Color.LIGHT_GRAY);

        //append new shape
        IAutoShape shape = presentation.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, new Rectangle2D.Double(50, 100, 600, 150));
        shape.getFill().setFillType( FillFormatType.NONE);
        shape.getShapeStyle().getLineColor().setColor(Color.WHITE);

        //add text to shape
        shape.getTextFrame().setText("This demo shows how to Create PowerPoint file and save it to Stream.");
        shape.getTextFrame().getParagraphs().get(0).getTextRanges().get(0).getFill().setFillType( FillFormatType.SOLID);
        shape.getTextFrame().getParagraphs().get(0).getTextRanges().get(0).getFill().getSolidColor().setColor(Color.BLACK);
        shape.getTextFrame().getParagraphs().get(0).getTextRanges().get(0).setFontHeight(30);

        //save to Stream
        File outFile = new File(output);
        OutputStream outputStream = new FileOutputStream(outFile);
        presentation.saveToFile(outputStream, FileFormat.PPTX_2013);
    }
}
