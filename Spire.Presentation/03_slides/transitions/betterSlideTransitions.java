import com.spire.presentation.*;
import com.spire.presentation.drawing.transition.*;

public class betterSlideTransitions {
    public static void main(String[] args) throws Exception {
        String input="data/setTransitions.pptx";
        String result = "output/betterSlideTransitions_result.pptx";

        //Create PPT document
        Presentation presentation = new Presentation();

        //Load the PPT
        presentation.loadFromFile(input);

        //Set the first slide transition as circle
        presentation.getSlides().get(0).getSlideShowTransition().setType(TransitionType.CIRCLE);

        //Set the transition time of 3 seconds
        presentation.getSlides().get(0).getSlideShowTransition().setAdvanceOnClick(true);
        presentation.getSlides().get(0).getSlideShowTransition().setAdvanceAfterTime(3000);

        //Set the second slide transition as comb and set the speed
        presentation.getSlides().get(1).getSlideShowTransition().setType(TransitionType.COMB);
        presentation.getSlides().get(1).getSlideShowTransition().setSpeed(TransitionSpeed.SLOW);

        // Set the transition time of 5 seconds
        presentation.getSlides().get(1).getSlideShowTransition().setAdvanceOnClick(true);
        presentation.getSlides().get(1).getSlideShowTransition().setAdvanceAfterTime(5000);

        // Set the third slide transition as zoom
        presentation.getSlides().get(2).getSlideShowTransition().setType(TransitionType.ZOOM);

        // Set the transition time of 7 seconds
        presentation.getSlides().get(2).getSlideShowTransition().setAdvanceOnClick(true);
        presentation.getSlides().get(2).getSlideShowTransition().setAdvanceAfterTime(7000);

        //Save the file
        presentation.saveToFile(result, FileFormat.PPTX_2013);
        presentation.dispose();
    }
}
