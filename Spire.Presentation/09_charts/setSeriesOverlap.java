import com.spire.presentation.*;
import com.spire.presentation.charts.*;

public class setSeriesOverlap {
    public static void main(String[] args) throws Exception{
        //Create PPT document and load file
        Presentation ppt = new Presentation();
        ppt.loadFromFile("data/ChartSample2.pptx");
        //Get chart on the first slide
        IChart chart = (IChart)ppt.getSlides().get(0).getShapes().get(0);

        //Set overlap
        chart.setOverLap(50);

        String result = "output/setSeriesOverlap_result.pptx";
        //Save the document
        ppt.saveToFile(result, FileFormat.PPTX_2010);
    }
}
