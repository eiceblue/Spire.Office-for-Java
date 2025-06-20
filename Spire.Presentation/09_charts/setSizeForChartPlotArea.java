import com.spire.presentation.*;
import com.spire.presentation.charts.*;

public class setSizeForChartPlotArea {
    public static void main(String[] args) throws Exception {
        //Create PPT document and load file
        Presentation presentation = new Presentation();
        presentation.loadFromFile("data/ChartSample2.pptx");

        //Get chart on the first slide
        IChart chart = (IChart)presentation.getSlides().get(0).getShapes().get(0);

        //Set width and height for chart plot area
        chart.getPlotArea().setWidth(250);
        chart.getPlotArea().setHeight(300);


        String result = "output/setSizeForChartPlotArea_result.pptx";
        //Save the document
        presentation.saveToFile(result, FileFormat.PPTX_2010);
    }
}
