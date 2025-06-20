import com.spire.presentation.*;
import com.spire.presentation.charts.*;

public class scaleBubbleChartSize {
    public static void main(String[] args) throws Exception {
        //Create a PowerPoint document.
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/ScaleBubbleChartSize.pptx");

        //Get the chart from the first presentation slide.
        IChart chart = (IChart)presentation.getSlides().get(0).getShapes().get(0);

        //Scale the bubble size, the range value is from 0 to 300.
        chart.setBubbleScale(50);

        String result = "output/scaleBubbleChartSize_result.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);

    }
}
