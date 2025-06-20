import com.spire.presentation.*;

public class setSlideLayout {
    public static void main(String[] args) throws Exception {
        //Create an instance of presentation document
        Presentation ppt = new Presentation();

        //Remove the first slide
        ppt.getSlides().removeAt(0);

        //Append a slide and set the layout for slide
        ISlide slide = ppt.getSlides().append(SlideLayoutType.TITLE);

        //Add content for Title and Text
        IAutoShape shape = (IAutoShape)slide.getShapes().get(0);
        shape.getTextFrame().setText("Hello Wolrd! -> This is title");

        shape = (IAutoShape)slide.getShapes().get(1);
        shape.getTextFrame().setText("E-iceblue Support Team -> This is content");

        //Save the document
        String result = "output/setSlideLayout_result.pptx";
        ppt.saveToFile(result, FileFormat.PPTX_2013);
        ppt.dispose();
    }
}
