import com.spire.presentation.*;

public class setAdvanceAfterTime {
    public static void main(String[] args) throws Exception {
        String input="data/setTransitions.pptx";
        String output = "output/result.pptx";

        //Create a PPT document
        Presentation ppt = new Presentation();

        //Load the file from disk
        ppt.loadFromFile(input);

        //Traverse all slides
        for(int i=0;i<ppt.getSlides().getCount();i++)
        { ppt.getSlides().get(i).getSlideShowTransition().isAdvanceAfterTime(true);

            //Set the time
            ppt.getSlides().get(i).getSlideShowTransition().setAdvanceAfterTime(5000L);
        }
        //Save the document
        ppt.saveToFile(output, FileFormat.PPTX_2013);
    }
}
