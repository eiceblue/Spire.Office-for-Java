import com.spire.presentation.*;
import com.spire.presentation.charts.*;

public class addTrendLineForChartSeries {
    public static void main(String[] args) throws Exception {
        String input = "data/template_Ppt_2.pptx";
        String output = "output/addTrendLineForChartSeries.pptx";

        //create a PPT document
        Presentation presentation = new Presentation();

        //load the file from disk.
        presentation.loadFromFile(input);

        //get the target chart, add trendline for the first data series of the chart and specify the trendline type.
        IChart chart = (IChart)presentation.getSlides().get(0).getShapes().get(0);
        ITrendlines it = chart.getSeries().get(0).addTrendLine(TrendlineSimpleType.LINEAR);

        //set the trendline properties to determine what should be displayed.
        it.setdisplayEquation(false);
        it.setdisplayRSquaredValue(false);

        //save to file.
        presentation.saveToFile(output, FileFormat.PPTX_2013);
    }
}
