import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import com.spire.presentation.charts.entity.*;
import com.spire.presentation.drawing.*;

import java.awt.*;

public class setPositionOfChartDataLabels {
    public static void main(String[] args) throws Exception{
       //Create a PowerPoint document.
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/Template_Ppt_2.pptx");

        //Get the chart.
        IChart chart = (IChart)presentation.getSlides().get(0).getShapes().get(0);

        //Add data label to chart and set its id.
        ChartDataLabel label1 =chart.getSeries().get(0).getDataLabels().add();
        label1.setID(0);

        //Set the default position of data label. This position is relative to the data markers.
        label1.setPosition(ChartDataLabelPosition.OUTSIDE_END);

        //Set custom position of data label. This position is relative to the default position.
        label1.setX(0.1f);
        label1.setY(-0.1f);

        //Set label value visible
        label1.setLabelValueVisible(true);

        //Set legend key invisible
        label1.setLegendKeyVisible(false);

        //Set category name invisible
        label1.setCategoryNameVisible(false);

        //Set series name invisible
        label1.setSeriesNameVisible(false);

        //Set Percentage invisible
        label1.setPercentageVisible(false);

        //Set border style and fill style of data label
        label1.getLine().setFillType(FillFormatType.SOLID);
        label1.getLine().getSolidFillColor().setColor(Color.blue);
        label1.getFill().setFillType(FillFormatType.SOLID);
        label1.getFill().getSolidColor().setColor(Color.orange);

        String result = "output/setPositionOfChartDataLabels_result.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2010);
    }
}
