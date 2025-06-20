
import com.spire.presentation.*;
import com.spire.presentation.drawing.FillFormatType;

import java.awt.*;


public class linkToASpecificSlide {
    public static void main(String[] args) throws Exception {
        String outputFile = "output/linkToASpecificSlide-result.pptx";

        //Create PPT document
        Presentation presentation = new Presentation();

        //Append a slide to it.
        presentation.getSlides().append();

        //Add new shape to PPT document
        Rectangle rec = new Rectangle((int)presentation.getSlideSize().getSize().getWidth() / 2 - 250, 120, 400, 100);
        IAutoShape shape = presentation.getSlides().get(1).getShapes().appendShape(ShapeType.RECTANGLE, rec);

        shape.getFill().setFillType(FillFormatType.NONE);
        shape.getLine().setFillType(FillFormatType.NONE);
        shape.getTextFrame().setText("Jump to the first slide");

        //Create a hyperlink based on the shape and the text on it, linking to the first slide.
        ClickHyperlink hyperlink = new ClickHyperlink(presentation.getSlides().get(0));
        shape.setClick(hyperlink);
        shape.getTextFrame().getTextRange().setClickAction(hyperlink);

        //Save the document
        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
    }
}
