import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import com.spire.presentation.charts.entity.*;
import com.spire.presentation.drawing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class createPieChart {
    public static void main(String[] args) throws Exception {
        String output = "output/createPieChart.pptx";

        //create a PPT document
        Presentation presentation = new Presentation();

        //insert a Pie chart to the first slide and set the chart title.
        Rectangle2D rect1 = new Rectangle2D.Double(40, 100, 550, 320);
        IChart chart = presentation.getSlides().get(0).getShapes().appendChart(ChartType.PIE, rect1, false);
        chart.getChartTitle().getTextProperties().setText("Sales by Quarter");
        chart.getChartTitle().getTextProperties().isCentered(true);
        chart.getChartTitle().setHeight(30);
        chart.hasTitle(true);

        //define some data.
        String[] quarters = new String[] { "1st Qtr", "2nd Qtr", "3rd Qtr", "4th Qtr" };
        int[] sales = new int[] { 210, 320, 180, 500 };

        //append data to ChartData, which represents a data table where the chart data is stored.
        chart.getChartData().get(0, 0).setText("Quarters");
        chart.getChartData().get(0, 1).setText("Sales");
        for (int i = 0; i < quarters.length; ++i)
        {
            chart.getChartData().get(i + 1, 0).setValue(quarters[i]);
            chart.getChartData().get(i + 1, 1).setValue(sales[i]);
        }
        //set category labels, series label and series data.
        chart.getSeries().setSeriesLabel(chart.getChartData().get("B1", "B1"));
        chart.getCategories().setCategoryLabels(chart.getChartData().get("A2", "A5"));
        chart.getSeries().get(0).setValues(chart.getChartData().get("B2", "B5"));

        //add data points to series and fill each data point with different color.
        for (int i = 0; i < chart.getSeries().get(0).getValues().getCount(); i++)
        {
            ChartDataPoint cdp = new ChartDataPoint(chart.getSeries().get(0));
            cdp.setIndex(i);
            chart.getSeries().get(0).getDataPoints().add(cdp);
        }
        chart.getSeries().get(0).getDataPoints().get(0).getFill().setFillType( FillFormatType.SOLID);
        chart.getSeries().get(0).getDataPoints().get(0).getFill().getSolidColor().setColor(Color.GREEN);
        chart.getSeries().get(0).getDataPoints().get(1).getFill().setFillType( FillFormatType.SOLID);
        chart.getSeries().get(0).getDataPoints().get(1).getFill().getSolidColor().setColor(Color.BLUE);
        chart.getSeries().get(0).getDataPoints().get(2).getFill().setFillType( FillFormatType.SOLID);
        chart.getSeries().get(0).getDataPoints().get(2).getFill().getSolidColor().setColor(Color.PINK);
        chart.getSeries().get(0).getDataPoints().get(3).getFill().setFillType( FillFormatType.SOLID);
        chart.getSeries().get(0).getDataPoints().get(3).getFill().getSolidColor().setColor(Color.YELLOW);

        //set the data labels to display label value and percentage value.
        chart.getSeries().get(0).getDataLabels().setLabelValueVisible(true);
        chart.getSeries().get(0).getDataLabels().setPercentValueVisible(true);

        //save to file.
        presentation.saveToFile(output, FileFormat.PPTX_2013);
    }
}
