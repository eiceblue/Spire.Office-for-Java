import com.spire.presentation.*;

public class clonePPTAtEndOfAnother {
    public static void main(String[] args) throws Exception {
        //Load source document from disk
        Presentation sourcePPT = new Presentation();
        sourcePPT.loadFromFile("data/changeSlidePosition.pptx");

        //Load destination document from disk
        Presentation destPPT = new Presentation();
        destPPT.loadFromFile("data/pptSample_N.pptx");

        //Loop through all slides of source document
        for (Object s : sourcePPT.getSlides()) {
            ISlide slide = (ISlide) s;
            //Append the slide at the end of destination document
            destPPT.getSlides().append(slide);
        }

        //Save the document
        String result = "output/clonePPTAtEndOfAnother.pptx";
        destPPT.saveToFile(result, FileFormat.PPTX_2013);
    }
}
