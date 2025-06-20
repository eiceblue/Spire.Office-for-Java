import com.spire.presentation.*;
import com.spire.presentation.charts.*;

public class showChartLabels {
    public static void main(String[] args) throws Exception {
        //Create PPT document and load file
        Presentation presentation = new Presentation();
        //Load the file from disk.
        presentation.loadFromFile("data/ChartSample2.pptx");

        //Get chart on the first slide
        IChart chart = (IChart)presentation.getSlides().get(0).getShapes().get(0);

        //Show data labels
        chart.getSeries().get(0).getDataLabels().setLabelValueVisible(true);
        chart.getSeries().get(0).getDataLabels().setCategoryNameVisible(true);
        chart.getSeries().get(0).getDataLabels().setSeriesNameVisible(true);

        String result = "output/showChartLabels_result.pptx";
        //Save the document
        presentation.saveToFile(result, FileFormat.PPTX_2010);
    }
}
