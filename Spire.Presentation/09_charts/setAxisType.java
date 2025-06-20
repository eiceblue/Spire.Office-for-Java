import com.spire.presentation.*;
import com.spire.presentation.charts.*;

public class setAxisType {
    public static void main(String[] args) throws Exception {
        //Create PPT document and load file
        Presentation presentation = new Presentation();
        presentation.loadFromFile("data/SetAxisType.pptx");

        //Get the chart
        IChart chart = (IChart)presentation.getSlides().get(0).getShapes().get(0);

        chart.getPrimaryCategoryAxis().setAxisType(AxisType.DateAxis);
        chart.getPrimaryCategoryAxis().setMajorUnitScale(ChartBaseUnitType.MONTHS);

        String result = "output/setAxisType_result.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
