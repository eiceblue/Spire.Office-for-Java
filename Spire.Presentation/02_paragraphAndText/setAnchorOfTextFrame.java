import com.spire.presentation.*;

public class setAnchorOfTextFrame {
    public static void main(String[] args) throws Exception {
        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load PPT file from disk
        presentation.loadFromFile("data/template_Az1.pptx");
        //Get the first slide
        ISlide slide = presentation.getSlides().get(0);
        //Get a shape
        IAutoShape shape = (IAutoShape) slide.getShapes().get(0);
        shape.getTextFrame().setAnchoringType(TextAnchorType.BOTTOM);

        String result = "output/setAnchorOfTextFrame.pptx";
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
