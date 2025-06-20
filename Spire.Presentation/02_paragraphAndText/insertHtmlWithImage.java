import com.spire.presentation.*;
import com.spire.presentation.collections.*;

public class insertHtmlWithImage {
    public static void main(String[] args) throws Exception {
        //Create an instance of presentation document
        Presentation ppt = new Presentation();
        ShapeList shapes = ppt.getSlides().get(0).getShapes();

        shapes.addFromHtml("<html><div><p>First paragraph</p><p><img src='data\\logo.png'/></p><p>Second paragraph </p></html>");

        //Save the document
        String result = "output/insertHtmlWithImage.pptx";
        ppt.saveToFile(result, FileFormat.PPTX_2013);
    }
}
