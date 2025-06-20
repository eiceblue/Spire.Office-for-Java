import com.spire.presentation.*;

public class changeSlidePosition {
    public static void main(String[] args) throws Exception {
        Presentation ppt = new Presentation();
        ppt.loadFromFile("data/changeSlidePosition.pptx");
        //Move the first slide to the second slide position
        ISlide slide = ppt.getSlides().get(0);
        slide.setSlideNumber(2);

        String output = "output/changeSlidePosition.pptx";
        ppt.saveToFile(output, FileFormat.PPTX_2013);
    }
}
