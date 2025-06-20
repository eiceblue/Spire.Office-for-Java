import com.spire.presentation.*;
import com.spire.presentation.charts.*;

public class setTickMarkLabelsOnCategoryAxis {
    public static void main(String[] args) throws Exception {
        //Create a PowerPonit document.
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/Template_Ppt_3.pptx");

        //Get the chart from the PowerPoint slide.
        IChart chart = (IChart)presentation.getSlides().get(0).getShapes().get(0);

        //Rotate tick labels.
        chart.getPrimaryCategoryAxis().setTextRotationAngle(45);

        //Specify interval between labels.
        chart.getPrimaryCategoryAxis().isAutomaticTickLabelSpacing(false);
        chart.getPrimaryCategoryAxis().setTickLabelSpacing(2);

        //Change position.
        chart.getPrimaryCategoryAxis().setTickLabelPosition(TickLabelPositionType.TICK_LABEL_POSITION_HIGH);

        String result = "output/setTickMarkLabelsOnCategoryAxis_result.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);

    }
}
