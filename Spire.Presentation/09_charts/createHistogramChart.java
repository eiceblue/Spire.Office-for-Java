import com.spire.presentation.*;
import com.spire.presentation.charts.*;

import java.awt.geom.Rectangle2D;

public class createHistogramChart {
    public static void main(String[] args) throws Exception {
        //Create PPT document
        Presentation ppt = new Presentation();
        //Create a Histogram chart to the first slide
        IChart chart = ppt.getSlides().get(0).getShapes().appendChart(ChartType.HISTOGRAM, new Rectangle2D.Float(50, 50, 500, 400), false);
        //Set series text
        chart.getChartData().get(0,0).setText("Series 1");
        //Fill data for chart
        double[] values = { 1, 1, 1, 3, 3, 3, 3, 5, 5, 5, 8, 8, 8, 9, 9, 9, 12, 12, 13, 13, 17, 17, 17, 19, 19, 19, 25, 25, 25, 25, 25, 25, 25, 25, 29, 29, 29, 29, 32, 32, 33, 33, 35, 35, 41, 41, 44, 45, 49, 49 };
        for (int i = 0; i < values.length; i++)
        {
            chart.getChartData().get(i+1,1).setNumberValue(values[i]);
        }
        //Set series label
        chart.getSeries().setSeriesLabel(chart.getChartData().get(0,0,0,0));
        //Set values for series
        chart.getSeries().get(0).setValues(chart.getChartData().get(1,0, values.length, 0));
        chart.getPrimaryCategoryAxis().setNumberOfBins(7);
        chart.getPrimaryCategoryAxis().setGapWidth(20);
        //Chart title
        chart.getChartTitle().getTextProperties().setText( "Histogram");
        chart.getChartLegend().setPosition(ChartLegendPositionType.BOTTOM);
        //Save the document
        String output = "output/Histogram_result.pptx";
        ppt.saveToFile(output, FileFormat.PPTX_2016);
        ppt.dispose();
    }
}
