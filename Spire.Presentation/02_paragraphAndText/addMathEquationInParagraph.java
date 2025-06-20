import com.spire.presentation.*;
import java.awt.geom.Rectangle2D;

public class addMathEquationInParagraph {

    public static void main(String[] args) throws Exception {
        // Create an Presentation object and load the input file
        Presentation ppt = new Presentation();
        String latexMathCode="x^{2}+\\sqrt{x^{2}+1=2}";

        // Append shape
        IAutoShape shape=ppt.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE,new Rectangle2D.Float(30,100,400,200));
        // clear shape
        shape.getTextFrame().getParagraphs().clear();

        // Append paragraph
        ParagraphEx p=new ParagraphEx();
        shape.getTextFrame().getParagraphs().append(p);

        // Append text and latex code
        PortionEx portionEx=new PortionEx("Test");
        p.getTextRanges().append(portionEx);
        p.appendFromLatexMathCode(latexMathCode);
        PortionEx portionEx2=new PortionEx("Hello");
        p.getTextRanges().append(portionEx2);

        // Save the file
        ppt.saveToFile("addMathEquationInParagraph.pptx", FileFormat.AUTO);
    }
}
