
import com.spire.presentation.*;

public class addHyperlinkToText {
    public static void main(String[] args) throws Exception {

        //Create a PPT document
        Presentation presentation = new Presentation();
        presentation.loadFromFile("data/AddHyperlinkToText.pptx");

        IAutoShape shape = (IAutoShape)presentation.getSlides().get(0).getShapes().get(0);
        ParagraphEx tp = shape.getTextFrame().getParagraphs().get(0);
        String temp = tp.getText();

        //Clear all text.
        tp.getTextRanges().clear();

        //Split the original text.
        String[] strSplit = temp.split("Spire.Presentation");

        //Add new text.
        PortionEx tr = new PortionEx(strSplit[0]);
        tp.getTextRanges().append(tr);

        //Add the hyperlink.
        tr = new PortionEx("Spire.Presentation");
        tr.getClickAction().setAddress("http://www.e-iceblue.com/Introduce/presentation-for-net-introduce.html");
        tp.getTextRanges().append(tr);

        String result = "output/Result-AddHyperlinkToText.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
