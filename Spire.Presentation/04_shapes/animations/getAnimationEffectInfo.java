import com.spire.presentation.*;
import com.spire.presentation.drawing.animation.*;

import java.io.FileWriter;

public class getAnimationEffectInfo {
    public static void main(String[] args) throws Exception {
        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load the document from disk
        presentation.loadFromFile("data/Animation.pptx");

        StringBuilder sb = new StringBuilder();
        //Travel each slide
        for(Object slideobj:presentation.getSlides()){
            ISlide slide = (ISlide)slideobj;
            //Travel all animation effects in a slide
            for(Object effectobj:slide.getTimeline().getMainSequence() ){
                AnimationEffect effect = (AnimationEffect)effectobj;

                //Get the animation effect type
                AnimationEffectType animationEffectType = effect.getAnimationEffectType();
                sb.append("animation effect type:"+animationEffectType+"\n");

                //Get the slide number where the animation is located
                int slideNumber = slide.getSlideNumber();
                sb.append("page number:"+slideNumber+"\n");

                //Get shape name
                String shapeName = effect.getShapeTarget().getName();
                sb.append("shape name:"+shapeName+"\n"+"\n");
            }
        }
        //Save to the text document
        String output = "output/AnimationEffectInfo.txt";
        FileWriter writer = new FileWriter(output);
        writer.write(sb.toString());
        writer.flush();
        writer.close();

    }
}
