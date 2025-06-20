import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import com.spire.presentation.charts.entity.*;
import com.spire.presentation.collections.*;
import com.spire.presentation.drawing.*;
import java.awt.*;

public class addShadowEffectForDataLabel {
    public static void main(String[] args) throws Exception {
        String input = "data/template_Ppt_3.pptx";
        String output = "output/addShadowEffectForDataLabel.pptx";

        //create a PowerPoint document.
        Presentation presentation = new Presentation();

        //load the file from disk.
        presentation.loadFromFile(input);

        //get the chart.
        IChart chart =(IChart)presentation.getSlides().get(0).getShapes().get(0);

        //add a data label to the first chart series.
        ChartDataLabelCollection dataLabels = chart.getSeries().get(0).getDataLabels();
        ChartDataLabel Label = dataLabels.add();
        Label.setLabelValueVisible(true);

        //add outer shadow effect to the data label.
        Label.getEffect().setOuterShadowEffect(new OuterShadowEffect());

        //set shadow color.
        Label.getEffect().getOuterShadowEffect().getColorFormat().setColor( Color.YELLOW);

        //set blur.
        Label.getEffect().getOuterShadowEffect().setBlurRadius(5);

        //set distance.
        Label.getEffect().getOuterShadowEffect().setDistance(10);

        //set angle.
        Label.getEffect().getOuterShadowEffect().setDirection(90f);

        //save the file.
        presentation.saveToFile(output, FileFormat.PPTX_2013);
    }
}
