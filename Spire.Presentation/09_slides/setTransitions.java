import com.spire.presentation.*;
import com.spire.presentation.drawing.transition.*;

public class setTransitions {
    public static void main(String[] args) throws Exception{
        String inputFile ="data/setTransitions.pptx";
        String outputFile="output/setTransitions_result.pptx";
        Presentation presentation = new Presentation();
        presentation.loadFromFile(inputFile);
        //Set the first slide transition as push and sound mode
        presentation.getSlides().get(0).getSlideShowTransition().setType(TransitionType.PUSH);
        presentation.getSlides().get(0).getSlideShowTransition().setSoundMode(TransitionSoundMode.START_SOUND);
        //Set the second slide transition as circle and set the speed
        presentation.getSlides().get(1).getSlideShowTransition().setType(TransitionType.FADE);
        presentation.getSlides().get(1).getSlideShowTransition().setSpeed(TransitionSpeed.SLOW);
        //Save the file
        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
        presentation.dispose();
    }
}
