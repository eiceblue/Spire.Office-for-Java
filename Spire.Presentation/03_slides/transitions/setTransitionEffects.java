import com.spire.presentation.*;
import com.spire.presentation.drawing.transition.*;

public class setTransitionEffects {
    public static void main(String[] args) throws Exception {
        String input="data/setTransitions.pptx";
        String result="output/setTransitionEffects_result.pptx";

        //Create PPT document
        Presentation presentation = new Presentation();

        //Load the PPT
        presentation.loadFromFile(input);

        // Set effects
        presentation.getSlides().get(0).getSlideShowTransition().setType(TransitionType.CUT);
        ((OptionalBlackTransition)presentation.getSlides().get(0).getSlideShowTransition().getValue()).setFromBlack(true);

        //Save the file
        presentation.saveToFile(result, FileFormat.PPTX_2013);
        presentation.dispose();
    }
}
