import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import java.awt.geom.Rectangle2D;

public class autoVaryColorForPieChart {
    public static void main(String[] args) throws Exception {
        //Create a PPT file
        Presentation ppt = new Presentation();

        Rectangle2D.Double rect1 = new Rectangle2D.Double(40, 100, 550, 320);
        //Add a pie chart
        IChart chart = ppt.getSlides().get(0).getShapes().appendChart(ChartType.PIE, rect1, false);
        chart.getChartTitle().getTextProperties().setText("Sales by Quarter");
        chart.getChartTitle().getTextProperties().isCentered(true);
        chart.getChartTitle().setHeight(30);
        chart.hasTitle(true);

        //Attach the data to chart
        String[] quarters = new String[]{"1st Qtr", "2nd Qtr", "3rd Qtr", "4th Qtr"};
        int[] sales = new int[]{210, 320, 180, 500};
        chart.getChartData().get(0,0).setText("Quarters");
        chart.getChartData().get(0,1).setText("Sales");
        for (int i = 0; i < quarters.length; ++i) {
            chart.getChartData().get(i + 1, 0).setValue(quarters[i]);
            chart.getChartData().get(i + 1, 1).setValue(sales[i]);
        }

        chart.getSeries().setSeriesLabel(chart.getChartData().get("B1", "B1"));
        chart.getCategories().setCategoryLabels(chart.getChartData().get("A2", "A5"));
        chart.getSeries().get(0).setValues(chart.getChartData().get("B2", "B5"));


        //Set whether auto vary color, default value is true
        chart.getSeries().get(0).isVaryColor(false);

        chart.getSeries().get(0).setDistance(15);

        String result = "output/autoVaryColorForPieChart_result.pptx";
        //Save the document
        ppt.saveToFile(result, FileFormat.PPTX_2010);
    }

}