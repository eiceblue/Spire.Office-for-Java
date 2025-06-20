import com.spire.presentation.*;
import com.spire.presentation.charts.*;

import java.awt.geom.Rectangle2D;

public class createSunBurstChart {
    public static void main(String[] args) throws Exception {
        //Create PPT document
        Presentation ppt = new Presentation();
        //Create a SunBurst chart to the first slide
        IChart chart = ppt.getSlides().get(0).getShapes().appendChart(ChartType.SUN_BURST, new Rectangle2D.Float(50, 50, 500, 400), false);
        //Set series text
        chart.getChartData().get(0,3).setText("Series 1");
        //Set category text
        String[][] categories = {{"Branch 1","Stem 1","Leaf 1"},{"Branch 1","Stem 1","Leaf 2"},{"Branch 1","Stem 1", "Leaf 3"},
                {"Branch 1","Stem 2","Leaf 4"},{"Branch 1","Stem 2","Leaf 5"},{"Branch 1","Leaf 6",null},{"Branch 1","Leaf 7", null},
                {"Branch 2","Stem 3","Leaf 8"},{"Branch 2","Leaf 9",null},{"Branch 2","Stem 4","Leaf 10"},{"Branch 2","Stem 4","Leaf 11"},
                {"Branch 2","Stem 5","Leaf 12"},{"Branch 3","Stem 5","Leaf 13"},{"Branch 3","Stem 6","Leaf 14"},{"Branch 3","Leaf 15",null}};
        for (int i = 0; i < 15; i++)
        {
            for (int j = 0; j < 3; j++){
                chart.getChartData().get(i+1,j).setValue(categories[i][j]);
            }

        }
        //Fill data for chart
        double[] values = { 17, 23, 48, 22, 76, 54, 77, 26, 44, 63, 10, 15, 48, 15, 51 };
        for (int i = 0; i < values.length; i++)
        {
            chart.getChartData().get(i+1,3).setNumberValue(values[i]);
        }
        //Set series labels
        chart.getSeries().setSeriesLabel(chart.getChartData().get(0,3,0,3));
        //Set categories labels
        chart.getCategories().setCategoryLabels(chart.getChartData().get(1,0, values.length, 2));
        //Assign data to series values
        chart.getSeries().get(0).setValues(chart.getChartData().get(1,3, values.length, 3));
        chart.getSeries().get(0).getDataLabels().setCategoryNameVisible(true);
        //Chart title
        chart.getChartTitle().getTextProperties().setText( "SunBurst");
        chart.hasLegend(true);
        chart.getChartLegend().setPosition(ChartLegendPositionType.BOTTOM);
        //Save the document
        String output = "output/SunBurst_result.pptx";
        ppt.saveToFile(output, FileFormat.PPTX_2016);
        ppt.dispose();
    }
}
