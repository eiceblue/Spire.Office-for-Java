import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import com.spire.presentation.charts.entity.*;
import com.spire.presentation.collections.*;
import java.text.DecimalFormat;

public class setPercentageForLabels {
    public static void main(String[] args) throws Exception {
        //Create PPT document and load file
        Presentation ppt = new Presentation();
        ppt.loadFromFile("data/ColumnStacked.pptx");

        //Get the chart on the first slide
        IChart chart = (IChart)ppt.getSlides().get(0).getShapes().get(0);

        float dataPontPercent = 0f;

        for (int i = 0; i < chart.getSeries().size(); i++)
        {
            ChartSeriesDataFormat series = chart.getSeries().get(i);
            //Get the total number
            float total = GetTotal(series.getValues());
            for (int j = 0; j < series.getValues().getCount(); j++) {
                //Get the percent
                dataPontPercent = Float.parseFloat(series.getValues().get(j).getText()) / total * 100;
                //Add data labels
                ChartDataLabel label = series.getDataLabels().add();
                label.setLabelValueVisible(true);
                //Set the percent text for the label
                DecimalFormat df1 = new DecimalFormat("##.00%");
                label.getTextFrame().getParagraphs().get(0).setText(df1.format(dataPontPercent/100));
                label.getTextFrame().getParagraphs().get(0).getTextRanges().get(0).setFontHeight(12);
            }
        }

        String result = "output/setPercentageForLabels_result.pptx";
        //Save the document
        ppt.saveToFile(result, FileFormat.PPTX_2010);
    }
    private static float GetTotal(CellRanges ranges)
    {
        float total = 0;
        for (int i = 0; i < ranges.getCount(); i++)
        {
            total += Float.parseFloat(ranges.get(i).getText());
        }

        return total;
    }
}
