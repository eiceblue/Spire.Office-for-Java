import com.spire.presentation.*;
import com.spire.presentation.charts.*;

public class invertIfNegative {
    public static void main(String[] args) throws Exception {
        //Create PPT document and load file
        Presentation ppt = new Presentation();
        ppt.loadFromFile("data/ColumnChart.pptx");

        //Get chart on the first slide
        IChart chart = (IChart)ppt.getSlides().get(0).getShapes().get(0);

        //Set invert if negative
        chart.getSeries().get(0).setInvertIfNegative(true);

        //Chart.Series[0].DataPoints[0].InvertIfNegative = true;

        String result = "output/invertIfNegative_result.pptx";
        //Save the document
        ppt.saveToFile(result, FileFormat.PPTX_2010);
    }
}
