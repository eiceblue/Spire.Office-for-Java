import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import java.awt.geom.*;

public class multipleCategoryChart {
    public static void main(String[] args) throws Exception {
    //Create a PPT file
    Presentation presentation = new Presentation();

    //Add line markers chart
    Rectangle2D rect1 = new Rectangle2D.Double(90, 100, 550, 320);
    IChart chart = presentation.getSlides().get(0).getShapes().appendChart(ChartType.COLUMN_CLUSTERED, rect1, false);

    //Chart title
    chart.getChartTitle().getTextProperties().setText("Multiple-Category");
    chart.getChartTitle().getTextProperties().isCentered(true);
    chart.getChartTitle().setHeight(30);
    chart.hasTitle(true);


    //Data for series
    Double[] Series1 = new Double[] { 7.7, 8.9, 7.0, 6.0,7.0, 8.0 };

    //Set series text
    chart.getChartData().get(0,2).setText("Series1");

    //Set category text
    chart.getChartData().get(1,0).setText("Grp 1");
    chart.getChartData().get(3,0).setText("Grp 2");
    chart.getChartData().get(5,0).setText("Grp 3");

    chart.getChartData().get(1,1).setText("A");
    chart.getChartData().get(2,1).setText("B");
    chart.getChartData().get(3,1).setText("C");
    chart.getChartData().get(4,1).setText("D");
    chart.getChartData().get(5,1).setText("E");
    chart.getChartData().get(6,1).setText("F");;


    //Fill data for chart
    for (int i = 0; i < Series1.length; ++i) {
        chart.getChartData().get(i + 1, 2).setValue(Series1[i]);
    }

    //Set series label
    chart.getSeries().setSeriesLabel(chart.getChartData().get("C1", "C1"));
    //Set category label
    chart.getCategories().setCategoryLabels(chart.getChartData().get("A2", "B7"));

    //Set values for series
    chart.getSeries().get(0).setValues(chart.getChartData().get("C2", "C7"));

    //Set if the category axis has multiple levels
     chart.getPrimaryCategoryAxis().hasMultiLvlLbl(true);
    //Merge same label
   chart.getPrimaryCategoryAxis().isMergeSameLabel(true);

     String result = "output/multipleCategoryChart_result.pptx";
    //Save the document
     presentation.saveToFile(result, FileFormat.PPTX_2010);
    }
}
