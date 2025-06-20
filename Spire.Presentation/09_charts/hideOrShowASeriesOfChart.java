import com.spire.presentation.*;
import com.spire.presentation.charts.*;

public class hideOrShowASeriesOfChart {
    public static void main(String[] args) throws Exception {
        //Create a PowerPoint document.
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/Template_Ppt_2.pptx");

        //Get the first slide.
        ISlide slide = presentation.getSlides().get(0);

        //Get the first chart.
        IChart chart = (IChart)slide.getShapes().get(0);

        //Hide the first series of the chart.
        chart.getSeries().get(0).isHidden(true);

        //Show the first series of the chart.
        //chart.Series[0].IsHidden = false;

        String result = "output/hideOrShowASeriesOfChart_result.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2010);
    }
}
