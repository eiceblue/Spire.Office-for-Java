import com.spire.presentation.*;
import com.spire.presentation.charts.*;

public class removeTickMarksOfAxis {
    public static void main(String[] args) throws Exception {
        //Create a PowerPoint document.
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/Template_Ppt_2.pptx");

        //Get the chart that need to be adjusted the number format and remove the tick marks.
        IChart chart = (IChart)presentation.getSlides().get(0).getShapes().get(0);

        //Set percentage number format for the axis value of chart.
        chart.getPrimaryValueAxis().setNumberFormat("0#\\%");

        //Remove the tick marks for value axis and category axis.
        chart.getPrimaryValueAxis().setMajorTickMark(TickMarkType.TICK_MARK_NONE);
        chart.getPrimaryValueAxis().setMinorTickMark(TickMarkType.TICK_MARK_NONE);
        chart.getPrimaryCategoryAxis().setMajorTickMark(TickMarkType.TICK_MARK_NONE);
        chart.getPrimaryCategoryAxis().setMinorTickMark(TickMarkType.TICK_MARK_NONE);

        String result = "output/setNumberFormatAndRemoveTickMarksOfChart_result.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
