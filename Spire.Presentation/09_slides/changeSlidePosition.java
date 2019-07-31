import com.spire.presentation.*;;

public class changeSlidePosition {
    public static void main(String[] args) throws Exception{
        String inputFile = "data/changeSlidePosition.pptx";
        String outputFile = "output/changeSlidePosition_result.pptx";
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);
        //Move the first slide to the second slide position
        ISlide slide = ppt.getSlides().get(0);
        slide.setSlideNumber(2);
        ppt.saveToFile(outputFile, FileFormat.PPTX_2010);
        ppt.dispose();
    }
}

