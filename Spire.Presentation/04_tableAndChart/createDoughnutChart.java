import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import com.spire.presentation.charts.entity.ChartDataPoint;
import com.spire.presentation.drawing.FillFormatType;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class createDoughnutChart {
    public static void main(String[] args) throws Exception {
        String outputFile = "output/createDoughnutChart_result.pptx";
        String imageFile = "data/bg.png";

        //Create a presentation instance
        Presentation presentation = new Presentation();

        //Set background image
        Rectangle2D.Double rect2 = new Rectangle2D.Double(0, 0, presentation.getSlideSize().getSize().getWidth(), presentation.getSlideSize().getSize().getHeight());
        presentation.getSlides().get(0).getShapes().appendEmbedImage(ShapeType.RECTANGLE, imageFile, rect2);
        presentation.getSlides().get(0).getShapes().get(0).getLine().getFillFormat().getSolidFillColor().setColor(Color.white);
        Rectangle2D.Double rect = new Rectangle2D.Double(80, 100, 550, 320);
        //Add a Doughnut chart
        IChart chart = presentation.getSlides().get(0).getShapes().appendChart(ChartType.DOUGHNUT, rect, false);
        chart.getChartTitle().getTextProperties().setText("Market share by country");
        chart.getChartTitle().getTextProperties().isCentered(true);
        chart.getChartTitle().setHeight(30);
        String[] countries = new String[]{"Guba", "Mexico", "France", "German"};
        int[] sales = new int[]{1800, 3000, 5100, 6200};
        chart.getChartData().get(0, 0).setText("Countries");
        chart.getChartData().get(0, 1).setText("Sales");
        for (int i = 0; i < countries.length; ++i) {
            chart.getChartData().get(i + 1, 0).setValue(countries[i]);
            chart.getChartData().get(i + 1, 1).setValue(sales[i]);
        }
        chart.getSeries().setSeriesLabel(chart.getChartData().get("B1", "B1"));
        chart.getCategories().setCategoryLabels(chart.getChartData().get("A2", "A5"));
        chart.getSeries().get(0).setValues(chart.getChartData().get("B2", "B5"));
        for (int i = 0; i < chart.getSeries().get(0).getValues().getCount(); i++) {
            ChartDataPoint cdp = new ChartDataPoint(chart.getSeries().get(0));
            cdp.setIndex(i);
            chart.getSeries().get(0).getDataPoints().add(cdp);
        }
        //Set the series color
        chart.getSeries().get(0).getDataPoints().get(0).getFill().setFillType(FillFormatType.SOLID);
        chart.getSeries().get(0).getDataPoints().get(0).getFill().getSolidColor().setColor(Color.green);
        chart.getSeries().get(0).getDataPoints().get(1).getFill().setFillType(FillFormatType.SOLID);
        chart.getSeries().get(0).getDataPoints().get(1).getFill().getSolidColor().setColor(Color.pink);
        chart.getSeries().get(0).getDataPoints().get(2).getFill().setFillType(FillFormatType.SOLID);
        chart.getSeries().get(0).getDataPoints().get(2).getFill().getSolidColor().setColor(Color.gray);
        chart.getSeries().get(0).getDataPoints().get(3).getFill().setFillType(FillFormatType.SOLID);
        chart.getSeries().get(0).getDataPoints().get(3).getFill().getSolidColor().setColor(Color.orange);

        chart.getSeries().get(0).getDataLabels().setLabelValueVisible(true);
        chart.getSeries().get(0).getDataLabels().setPercentValueVisible(true);

        presentation.saveToFile(outputFile, FileFormat.PPTX_2013);
    }
}
