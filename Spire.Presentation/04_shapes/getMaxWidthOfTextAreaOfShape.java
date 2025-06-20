import com.spire.presentation.*;

public class getMaxWidthOfTextAreaOfShape {
    public static void main(String[] args) throws Exception {
        String input="data/extractText.pptx";
      
        Presentation ppt = new Presentation();
        ppt.loadFromFile(input);
        ISlide slide = ppt.getSlides().get(0);
        IAutoShape shape = (IAutoShape)slide.getShapes().get(0);
        float maxWidth = shape.getTextFrame().getMaxWidth();
        System.out.println(maxWidth);
    }
}
