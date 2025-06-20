import com.spire.presentation.*;
import com.spire.presentation.charts.*;

public class setLegendOptions {
    public static void main(String[] args) throws Exception {
        //Create PPT document and load file
        Presentation ppt = new Presentation();
        ppt.loadFromFile("data/ChartSample2.pptx");

        //Get chart on the first slide
        IChart chart = (IChart)ppt.getSlides().get(0).getShapes().get(0);

        //Set the legend positon
        chart.getChartLegend().setLeft(20);
        chart.getChartLegend().setTop(20);

        //Set the legend size
        chart.getChartLegend().setWidth(250);
        chart.getChartLegend().setHeight(30);

        String result = "output/setLegendOptions_result.pptx";
        //Save the document
        ppt.saveToFile(result, FileFormat.PPTX_2010);
    }
}
