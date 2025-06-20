import com.spire.presentation.*;
import com.spire.presentation.collections.*;

public class durationAndDelayTime {
    public static void main(String[] args) throws Exception{
        //Create PPT document and load file
        Presentation presentation = new Presentation();
        presentation.loadFromFile("data/Animation.pptx");
        //Get the first slide
        ISlide slide = presentation.getSlides().get(0);
        AnimationEffectCollection animations = slide.getTimeline().getMainSequence();

        //Get duration time of animation
        float durationTime = animations.get(0).getTiming().getDuration();

        //Set new duration time of animation
        animations.get(0).getTiming().setDuration(0.8f);

        //Get delay time of animation
        float delayTime = animations.get(0).getTiming().getTriggerDelayTime();

        //Set new delay time of animation
        animations.get(0).getTiming().setTriggerDelayTime(0.6f);

        String result = "output/durationAndDelayTime_result.pptx";
        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);

    }
}
