import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import com.spire.presentation.drawing.FillFormatType;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class createParetoChart {
    public static void main(String[] args) throws Exception {
        //Create PPT document
        Presentation ppt = new Presentation();
        //Create a Pareto chart in first slide
        IChart chart = ppt.getSlides().get(0).getShapes().appendChart(ChartType.PARETO, new Rectangle2D.Float(50, 50, 500, 400), false);
        //Set series text
        chart.getChartData().get(0,1).setText("Series 1");
        //Set category text
        String[] categories = { "Category 1", "Category 2", "Category 4", "Category 3", "Category 4", "Category 2", "Category 1",
                "Category 1", "Category 3", "Category 2", "Category 4", "Category 2", "Category 3",
                "Category 1", "Category 3", "Category 2", "Category 4", "Category 1", "Category 1",
                "Category 3", "Category 2", "Category 4", "Category 1", "Category 1", "Category 3",
                "Category 2", "Category 4", "Category 1"};
        for (int i = 0; i < categories.length; i++)
        {
            chart.getChartData().get(i+1,0).setText(categories[i]);
        }
        //Fill data for chart
        double[] values = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        for (int i = 0; i < values.length; i++)
        {
            chart.getChartData().get(i+1,1).setNumberValue(values[i]);
        }
        //Set series label
        chart.getSeries().setSeriesLabel(chart.getChartData().get(0,1,0,1));
        //Set category label
        chart.getCategories().setCategoryLabels(chart.getChartData().get(1,0, categories.length, 0));
        //Set values for series
        chart.getSeries().get(0).setValues(chart.getChartData().get(1,1, values.length, 1));

        chart.getPrimaryCategoryAxis().isBinningByCategory(true);
        chart.getSeries().get(1).getLine().getFillFormat().setFillType(FillFormatType.SOLID);
        chart.getSeries().get(1).getLine().getFillFormat().getSolidFillColor().setColor(Color.red);
        //Chart title
        chart.getChartTitle().getTextProperties().setText( "Pareto");
        chart.hasLegend(true);
        chart.getChartLegend().setPosition(ChartLegendPositionType.BOTTOM);
        //Save the document
        String output = "output/Pareto_result.pptx";
        ppt.saveToFile(output, FileFormat.PPTX_2016);
        ppt.dispose();
    }
}
