
import com.spire.presentation.*;

public class modifyHyperlink {
    public static void main(String[] args) throws Exception {

        //Create a PPT document
        Presentation presentation = new Presentation();
        presentation.loadFromFile("data/ModifyHyperlink.pptx");

        //Get the shape we want to edit it.
        IAutoShape shape = (IAutoShape)presentation.getSlides().get(0).getShapes().get(0);

        //Edit the link text and the target URL.
        shape.getTextFrame().getTextRange().getClickAction().setAddress("http://www.e-iceblue.com");
        shape.getTextFrame().getTextRange().setText("E-iceblue");

        String result = "output/Result-modifyHyperlink.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
