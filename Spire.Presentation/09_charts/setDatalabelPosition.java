import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import com.spire.presentation.charts.entity.ChartDataLabel;

public class setDatalabelPosition {
    public static void main(String[] args) throws Exception {
        //Create PPT document and load file
        Presentation ppt = new Presentation();
        ppt.loadFromFile("data/ChartSample2.pptx");

        //Get chart on the first slide
        IChart chart = (IChart)ppt.getSlides().get(0).getShapes().get(0);

        //Add data label
        ChartDataLabel label = chart.getSeries().get(0).getDataLabels().add();
        //Set the position of the label
        label.setX (2f);
        label.setY (2f);

        String result = "output/setDatalabelPosition_result.pptx";
        //Save the document
        ppt.saveToFile(result, FileFormat.PPTX_2013);
    }
}
