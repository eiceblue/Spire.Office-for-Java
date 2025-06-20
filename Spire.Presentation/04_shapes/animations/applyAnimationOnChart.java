import com.spire.presentation.*;
import com.spire.presentation.charts.IChart;
import com.spire.presentation.drawing.animation.*;

public class applyAnimationOnChart {
    public static void main(String[] args) throws Exception {
        //Load PPT document from disk
        Presentation ppt = new Presentation();
        ppt.loadFromFile("data/AnimationChart.pptx");
        //Get first shape in first slide
        IShape shape=ppt.getSlides().get(0).getShapes().get(0);
        if(shape instanceof IChart)
        {
            IChart chart = (IChart) shape;
            //Apply Fly animation effect on the chart
            AnimationEffect effect=ppt.getSlides().get(0).getTimeline().getMainSequence().addEffect(chart,AnimationEffectType.FLY);
            //Set the BuildType as SERIES
            effect.getGraphicAnimation().setBuildType(GraphicBuildType.BUILD_AS_SERIES);
        }
        //Save the PPT document
        ppt.saveToFile("output/AnimationChart_output.pptx", FileFormat.AUTO);
    }
}
