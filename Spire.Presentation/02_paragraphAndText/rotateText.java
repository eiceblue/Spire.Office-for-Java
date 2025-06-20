import com.spire.presentation.*;

public class rotateText {
    public static void main(String[] args) throws Exception {
        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load PPT file from disk
        presentation.loadFromFile("data/template_Az1.pptx");
        //Get the first slide
        ISlide slide = presentation.getSlides().get(0);
        //Get a shape
        IAutoShape shape = (IAutoShape) slide.getShapes().get(0);

        shape.getTextFrame().setVerticalTextType(VerticalTextType.VERTICAL_270);

        String result = "output/rotateText.pptx";
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
