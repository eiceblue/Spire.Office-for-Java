
import com.spire.presentation.*;

public class removeHyperlink {
    public static void main(String[] args) throws Exception {

        //Create a PPT document
        Presentation presentation = new Presentation();
        presentation.loadFromFile("data/ModifyHyperlink.pptx");

        //Get the shape and its text with hyperlink.
        IAutoShape shape = (IAutoShape)presentation.getSlides().get(0).getShapes().get(0);

        //Set null to remove the hyperlink.
        shape.getTextFrame().getTextRange().setClickAction(null);

        String result = "output/Result-removeHyperlink.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
