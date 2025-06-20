import com.spire.presentation.*;
import com.spire.presentation.charts.*;

import java.awt.geom.Rectangle2D;

public class createBoxandwhiskerChart {
    public static void main(String[] args) throws Exception {
        //Create a PPT file
        Presentation ppt = new Presentation();
        //Create a Boxandwhisker chart to the first slide
        IChart chart = ppt.getSlides().get(0).getShapes().appendChart(ChartType.BOX_AND_WHISKER, new Rectangle2D.Float(50, 50, 500, 400), false);
        //Set series text
        String[] seriesLabel = { "Series 1", "Series 2", "Series 3" };
        for (int i = 0; i < seriesLabel.length; i++)
        {
            chart.getChartData().get(0,i+1).setText("Series 1");
        }
        //Set category text
        String[] categories = {"Category 1", "Category 1", "Category 1", "Category 1", "Category 1", "Category 1", "Category 1",
                "Category 2", "Category 2", "Category 2", "Category 2", "Category 2", "Category 2",
                "Category 3", "Category 3", "Category 3", "Category 3", "Category 3"};
        for (int i = 0; i < categories.length; i++)
        {
            chart.getChartData().get(i+1,0).setText(categories[i]);
        }
        //Fill data for chart
        double[][] values = new double[][]{{-7,-3,-24},{-10,1,11},{-28,-6,34},{47,2,-21},{35,17,22},{-22,15,19},{17,-11,25},
            {-30,18,25},{49,22,56},{37,22,15},{-55,25,31},{14,18,22},{18,-22,36},{-45,25,-17},
            {-33,18,22},{18,2,-23},{-33,-22,10},{10,19,22}};
        for (int i = 0; i < seriesLabel.length; i++)
        {
            for (int j = 0; j < categories.length; j++)
            {
                chart.getChartData().get(j+1,i+1).setNumberValue(values[j][i]);
            }
        }
        //Set series label
        chart.getSeries().setSeriesLabel(chart.getChartData().get(0,1,0, seriesLabel.length));
        //Set category label
        chart.getCategories().setCategoryLabels(chart.getChartData().get(1,0, categories.length, 0));
        //Set values for series
        chart.getSeries().get(0).setValues(chart.getChartData().get(1,1, categories.length, 1));
        chart.getSeries().get(1).setValues(chart.getChartData().get(1,2, categories.length, 2));
        chart.getSeries().get(2).setValues(chart.getChartData().get(1,3, categories.length, 3));

        chart.getSeries().get(0).isShowInnerPoints(false);
        chart.getSeries().get(0).isShowOutlierPoints(true);
        chart.getSeries().get(0).isShowMeanMarkers(true);
        chart.getSeries().get(0).isShowMeanLine(true);
        chart.getSeries().get(0).setQuartileCalculationType(QuartileCalculation.ExclusiveMedian);
        chart.getSeries().get(1).isShowInnerPoints(false);
        chart.getSeries().get(1).isShowOutlierPoints(true);
        chart.getSeries().get(1).isShowMeanMarkers(true);
        chart.getSeries().get(1).isShowMeanLine(true);
        chart.getSeries().get(1).setQuartileCalculationType(QuartileCalculation.InclusiveMedian);
        chart.getSeries().get(2).isShowInnerPoints(false);
        chart.getSeries().get(2).isShowOutlierPoints(true);
        chart.getSeries().get(2).isShowMeanMarkers(true);
        chart.getSeries().get(2).isShowMeanLine(true);
        chart.getSeries().get(2).setQuartileCalculationType(QuartileCalculation.ExclusiveMedian);
        //Chart title
        chart.hasLegend(true);
        chart.getChartTitle().getTextProperties().setText("BoxAndWhisker");
        chart.getChartLegend().setPosition(ChartLegendPositionType.TOP);
        //Save to file
        String output = "output/BoxandwhiskerChart_result.pptx";
        ppt.saveToFile(output, FileFormat.PPTX_2016);
        ppt.dispose();
    }
}
