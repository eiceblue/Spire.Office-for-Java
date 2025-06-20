import com.spire.presentation.*;
import com.spire.presentation.collections.*;

public class setAnimationRepeatType {
    public static void main(String[] args) throws Exception {
        //Create PPT document and load file
        Presentation presentation = new Presentation();
        presentation.loadFromFile("data/Animation.pptx");
        //Get the first slide
        ISlide slide = presentation.getSlides().get(0);
        AnimationEffectCollection animations = slide.getTimeline().getMainSequence();
        animations.get(0).getTiming().setAnimationRepeatType(AnimationRepeatType.UtilEndOfSlide);

        String result = "output/setAnimationRepeatType_result.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
