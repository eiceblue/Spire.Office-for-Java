import com.spire.presentation.*;
import com.spire.presentation.charts.*;

public class explodePieChart {
    public static void main(String[] args) throws Exception {

        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/ExplodePieChart.pptx");

        //Get the chart that needs to set the point explosion.
        IChart chart = (IChart)presentation.getSlides().get(0).getShapes().get(0);

        chart.getSeries().get(0).setDistance(15);

        String result = "output/explodePieChart_result.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
