import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import com.spire.presentation.charts.entity.ChartDataPoint;

import java.awt.geom.Rectangle2D;

public class createWaterfallChart {
    public static void main(String[] args) throws Exception {
        //Create PPT document
        Presentation ppt = new Presentation();
        //Create a WaterFall chart to the first slide
        IChart chart = ppt.getSlides().get(0).getShapes().appendChart(ChartType.WATER_FALL, new Rectangle2D.Float(50, 50, 500, 400), false);
        //Set series text
        chart.getChartData().get(0,1).setText("Series 1");
        //Set category text
        String[] categories = { "Category 1", "Category 2", "Category 3", "Category 4", "Category 5", "Category 6", "Category 7" };
        for (int i = 0; i < categories.length; i++)
        {
            chart.getChartData().get(i+1,0).setText(categories[i]);
        }
        //Fill data for chart
        double[] values = { 100, 20, 50, -40, 130, -60, 70 };
        for (int i = 0; i < values.length; i++)
        {
            chart.getChartData().get(i+1,1).setNumberValue(values[i]);
        }
        //Set series labels
        chart.getSeries().setSeriesLabel(chart.getChartData().get(0,1,0,1));
        //Set categories labels
        chart.getCategories().setCategoryLabels(chart.getChartData().get(1,0, categories.length, 0));
        //Assign data to series values
        chart.getSeries().get(0).setValues(chart.getChartData().get(1,1, values.length, 1));
        //Operate the third datapoint of first series
        ChartDataPoint chartDataPoint = new ChartDataPoint(chart.getSeries().get(0));
        chartDataPoint.setIndex(2);
        chartDataPoint.setSetAsTotal(true);
        chart.getSeries().get(0).getDataPoints().add(chartDataPoint);
        //Operate the sixth datapoint of first series
        ChartDataPoint chartDataPoint2 = new ChartDataPoint(chart.getSeries().get(0));
        chartDataPoint2.setIndex(5);
        chartDataPoint2.setSetAsTotal(true);
        chart.getSeries().get(0).getDataPoints().add(chartDataPoint2);

        chart.getSeries().get(0).isShowConnectorLines(true);
        chart.getSeries().get(0).getDataLabels().setLabelValueVisible(true);
        //Chart title
        chart.getChartTitle().getTextProperties().setText( "WaterFall");
        chart.getChartLegend().setPosition(ChartLegendPositionType.RIGHT);
        //Save the document
        String output = "output/WaterFall_result.pptx";
        ppt.saveToFile(output, FileFormat.PPTX_2016);
        ppt.dispose();
    }
}
