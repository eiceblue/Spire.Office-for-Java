import com.spire.presentation.*;
import com.spire.presentation.charts.IChart;

public class deleteChartLegendEntries {
    public static void main(String[] args) throws Exception{
        //Create a PowerPoint document.
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/Template_Ppt_2.pptx");

        //Get the chart.
        IChart chart = (IChart)presentation.getSlides().get(0).getShapes().get(0);

        //Delete the first and the second legend entries from the chart.
        chart.getChartLegend().deleteEntry(0);
        chart.getChartLegend().deleteEntry(1);

        String result = "output/result-DeleteChartLegendEntries.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
