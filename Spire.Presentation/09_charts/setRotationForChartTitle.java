import com.spire.presentation.*;
import com.spire.presentation.charts.*;

public class setRotationForChartTitle {
    public static void main(String[] args) throws Exception {
        //Create PPT document and load file
        Presentation presentation = new Presentation();
        presentation.loadFromFile("data/ChartSample2.pptx");

        //Get the chart
        IChart chart = (IChart)presentation.getSlides().get(0).getShapes().get(0);

        chart.getChartTitle().getTextProperties().setRotationAngle(-30);

        String result = "output/setRotationForChartTitle_result.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
