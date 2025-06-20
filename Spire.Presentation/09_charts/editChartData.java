import com.spire.presentation.*;
import com.spire.presentation.charts.*;

public class editChartData {
    public static void main(String[] args) throws Exception {
         //Create PPT document and load file
        Presentation ppt = new Presentation();
        ppt.loadFromFile("data/ChartSample2.pptx");

        //Get chart on the first slide
        IChart chart = (IChart)ppt.getSlides().get(0).getShapes().get(0);

        //Change the value of the second datapoint of the first series
        chart.getSeries().get(0).getValues().get(1).setValue(6);

        String result = "output/editChartData_result.pptx";
        //Save the document
        ppt.saveToFile(result, FileFormat.PPTX_2010);
    }
}
