import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import java.awt.geom.Rectangle2D;

public class createLineMarkersChart {
    public static void main(String[] args) throws Exception {
        String output = "output/createLineMarkersChart.pptx";
        String imageFile = "data/bg.png";

        //create a PPT file
        Presentation presentation = new Presentation();

        //add line markers chart
        Rectangle2D rect1 = new Rectangle2D.Double(90, 100, 550, 320);
        IChart chart = presentation.getSlides().get(0).getShapes().appendChart(ChartType.LINE_MARKERS, rect1, false);

        //chart title
        chart.getChartTitle().getTextProperties().setText("Line Makers Chart");
        chart.getChartTitle().getTextProperties().isCentered(true);
        chart.getChartTitle().setHeight(30);
        chart.hasTitle(true);

        //data for series
        Double[] Series1 = new Double[] { 7.7, 8.9, 1.0, 2.4 };
        Double[] Series2 = new Double[] { 15.2, 5.3, 6.7, 8.0 };

        //set series text
        chart.getChartData().get(0, 1).setText("Series1");
        chart.getChartData().get(0, 2).setText("Series2");

        //set category text
        chart.getChartData().get(1, 0).setText( "Category 1");
        chart.getChartData().get(2, 0).setText("Category 2");
        chart.getChartData().get(3, 0).setText( "Category 3");
        chart.getChartData().get(4, 0).setText( "Category 4");

        //fill data for chart
        for (int i = 0; i < Series1.length; ++i)
        {
            chart.getChartData().get(i + 1, 1).setValue(Series1[i]);
            chart.getChartData().get(i + 1, 2).setValue(Series2[i]);
        }
        //set series label
        chart.getSeries().setSeriesLabel(chart.getChartData().get("B1", "C1"));
        //set category label
        chart.getCategories().setCategoryLabels(chart.getChartData().get("A2", "A5"));

        //set values for series
        chart.getSeries().get(0).setValues(chart.getChartData().get("B2", "B5"));
        chart.getSeries().get(1).setValues(chart.getChartData().get("C2", "C5"));

        //save the document
        presentation.saveToFile(output, FileFormat.PPTX_2013);
    }
}
