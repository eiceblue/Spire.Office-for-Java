import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import com.spire.presentation.charts.entity.*;

public class groupTwoLevelAxisLabels {
    public static void main(String[] args) throws Exception {
        //Create a PowerPoint document.
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/GroupTwoLevelAxisLabels.pptx");
        //Get the chart.
        IChart chart = (IChart)presentation.getSlides().get(0).getShapes().get(0);

        //Get the category axis from the chart.
        IChartAxis chartAxis = chart.getPrimaryCategoryAxis();

        //Group the axis labels that have the same first-level label.
        if (chartAxis.hasMultiLvlLbl())
        {
            chartAxis.isMergeSameLabel(true);
        }

        String result = "output/groupTwoLevelAxisLabels_result.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);

    }
}
