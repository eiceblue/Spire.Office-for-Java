import com.spire.presentation.*;
import com.spire.presentation.charts.IChart;

public class doughnutChartHole {
    public static void main(String[] args) throws Exception {
        //Create PPT document and load file
        Presentation ppt = new Presentation();
        ppt.loadFromFile("data/DoughnutChart.pptx");

        //Get the chart on the first slide
        IChart chart = (IChart)ppt.getSlides().get(0).getShapes().get(0);

        //Set hole size
        chart.getSeries().get(0).setDoughnutHoleSize(55);

        String result = "output/doughnutChartHole_result.pptx";
        //Save the document
        ppt.saveToFile(result, FileFormat.PPTX_2010);
    }
}
