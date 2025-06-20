import com.spire.presentation.*;
import java.awt.geom.Rectangle2D;

public class addMathMLEquation {
    public static void main(String[] args) throws Exception {
        
        //Create a PPT document
        Presentation ppt = new Presentation();

        //Set the mathML code
        String mathMLCode="<mml:math xmlns:mml=\"http://www.w3.org/1998/Math/MathML\" xmlns:m=\"http://schemas.openxmlformats.org/officeDocument/2006/math\">" + "<mml:msup><mml:mrow><mml:mi>x</mml:mi></mml:mrow><mml:mrow><mml:mn>2</mml:mn></mml:mrow></mml:msup><mml:mo>+</mml:mo><mml:msqrt><mml:msup><mml:mrow><mml:mi>x</mml:mi></mml:mrow><mml:mrow><mml:mn>2</mml:mn></mml:mrow></mml:msup><mml:mo>+</mml:mo><mml:mn>1</mml:mn></mml:msqrt><mml:mo>+</mml:mo><mml:mn>1</mml:mn></mml:math>";

        //Add a shape
        IAutoShape shape=ppt.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, new Rectangle2D.Float(30,100,400,30));
        shape.getTextFrame().getParagraphs().clear();

        //Add the mathml equation paragraph
        ParagraphEx tp = shape.getTextFrame().getParagraphs().addParagraphFromMathMLCode(mathMLCode);

        //Save the document
        String outputFile = "result.pptx";
        ppt.saveToFile(outputFile, FileFormat.PPTX_2013);
        ppt.dispose();
    }
}
