import com.spire.presentation.*;
import com.spire.presentation.drawing.FillFormatType;
import java.awt.*;
import java.awt.geom.Rectangle2D;
public class addWatermark {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/addWatermark.pptx";
        String outputFile = "output/addWatermark_result.pptx";

        //Create a PPT document and load file
        Presentation presentation = new Presentation();
        presentation.loadFromFile(inputFile);

        //Set the width and height of watermark string
        int width= 400;
        int height= 300;
        //Define a rectangle range
        Rectangle2D.Double rect = new Rectangle2D.Double((presentation.getSlideSize().getSize().getWidth() - width) / 2,
                (presentation.getSlideSize().getSize().getHeight() - height) / 2, width, height);

        //Add a rectangle shape with a defined range
        IAutoShape shape = presentation.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, rect);

        //Set the style of shape
        shape.getFill().setFillType(FillFormatType.NONE);
        shape.getShapeStyle().getLineColor().setColor(Color.white);
        shape.setRotation(-45);
        shape.getLocking().setSelectionProtection(true);
        shape.getLine().setFillType(FillFormatType.NONE);

        //Add text to shape
        shape.getTextFrame().setText("E-iceblue");
        PortionEx textRange = shape.getTextFrame().getTextRange();

        //Set the style of the text range
        textRange.getFill().setFillType(FillFormatType.SOLID);
        textRange.getFill().getSolidColor().setColor(Color.pink);
        textRange.setFontHeight(50);

        //Save the document
        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
    }
}
