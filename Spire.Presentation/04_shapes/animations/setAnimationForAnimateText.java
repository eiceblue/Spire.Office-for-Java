import com.spire.presentation.*;
import com.spire.presentation.drawing.timeline.AnimateType;

public class setAnimationForAnimateText {
    public static void main(String[] args) throws Exception {
        String input="data/setAnimationForAnimateText.pptx";
        String output="output/setAnimationForAnimateText_out.pptx";

        //Create an instance of presentation document
        Presentation ppt = new Presentation();
        //Load file
        ppt.loadFromFile(input);

        //Set the AnimateType as Letter
        ppt.getSlides().get(0).getTimeline().getMainSequence().get(0).setIterateType(AnimateType.Letter);

        //Set the IterateTimeValue for the animate text
        ppt.getSlides().get(0).getTimeline().getMainSequence().get(0).setIterateTimeValue(10);

        //Save the document
        ppt.saveToFile(output, FileFormat.PPTX_2013);
        ppt.dispose();
    }
}
