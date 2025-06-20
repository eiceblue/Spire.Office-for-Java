import com.spire.presentation.*;
import com.spire.presentation.drawing.*;

import java.awt.*;

public class appendHTML {
    public static void main(String[] args) throws Exception {
        //Create a PPT document and load file
        Presentation ppt = new Presentation();
        ppt.loadFromFile("data/template_Az.pptx");

        //Add a shape
        IAutoShape shape = ppt.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE,
                new Rectangle(150, 100, 200, 200));

        //Clear default paragraphs
        shape.getTextFrame().getParagraphs().clear();

        String code = "<html><body><p>This is a paragraph</p></body></html>";

        //Append HTML, and generate a paragraph with default style in PPT document.
        shape.getTextFrame().getParagraphs().addFromHtml(code);

        String codeColor = "<html><body><p style=\" color:black \">This is a paragraph</p></body></html>";
        //Append HTML with black setting
        shape.getTextFrame().getParagraphs().addFromHtml(codeColor);

        //Add another shape
        IAutoShape shape1 = ppt.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, new Rectangle(350, 100, 200, 200));

        //Clear default paragraph
        shape1.getTextFrame().getParagraphs().clear();

        //Change the fill format of shape
        shape1.getFill().setFillType(FillFormatType.SOLID);
        shape1.getFill().getSolidColor().setColor(Color.white);

        //Append HTML
        shape1.getTextFrame().getParagraphs().addFromHtml(code);
        ParagraphEx par = shape1.getTextFrame().getParagraphs().get(0);

        //Change the fill color for paragraph
        PortionEx textRange = shape1.getTextFrame().getTextRange();
        textRange.getFill().setFillType(FillFormatType.SOLID);
        textRange.getFill().getSolidColor().setColor(Color.black);

        //Save the document
        String output = "output/appendHTML.pptx";
        ppt.saveToFile(output, FileFormat.PPTX_2010);
    }
}
