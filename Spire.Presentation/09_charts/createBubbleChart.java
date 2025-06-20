import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class createBubbleChart {
    public static void main(String[] args) throws Exception {
        String output = "output/createBubbleChart.pptx";
        String imageFile = "data/bg.png";

        //create a PPT file.
        Presentation presentation = new Presentation();

        //set background image
        Rectangle2D.Double rect2 = new Rectangle2D.Double(0, 0, presentation.getSlideSize().getSize().getWidth(), presentation.getSlideSize().getSize().getHeight());
        presentation.getSlides().get(0).getShapes().appendEmbedImage(ShapeType.RECTANGLE, imageFile, rect2);
        presentation.getSlides().get(0).getShapes().get(0).getLine().getFillFormat().getSolidFillColor().setColor(Color.white);

        //add bubble chart
        Rectangle2D.Double rect1 = new Rectangle2D.Double(90, 100, 550, 320);
        IChart chart = null;
        chart = presentation.getSlides().get(0).getShapes().appendChart(ChartType.BUBBLE, rect1, false);

        //chart title
        chart.getChartTitle().getTextProperties().setText("Bubble Chart");
        chart.getChartTitle().getTextProperties().isCentered(true);
        chart.getChartTitle().setHeight(30);
        chart.hasTitle(true);

        //attach the data to chart
        double[] xdata = new double[]{7.7, 8.9, 1.0, 2.4};
        double[] ydata = new double[]{15.2, 5.3, 6.7, 8};
        double[] size = new double[]{1.1, 2.4, 3.7, 4.8};
        chart.getChartData().get(0, 0).setText("X-Value");
        chart.getChartData().get(0, 1).setText("Y-Value");
        chart.getChartData().get(0, 2).setText("Size");
        for (int i = 0; i < xdata.length; ++i) {
            chart.getChartData().get(i + 1, 0).setValue(xdata[ i ]);
            chart.getChartData().get(i + 1, 1).setValue(ydata[ i ]);
            chart.getChartData().get(i + 1, 2).setValue(size[ i ]);
        }

        //set series label
        chart.getSeries().setSeriesLabel(chart.getChartData().get("B1", "B1"));
        chart.getSeries().get(0).setXValues(chart.getChartData().get("A2", "A5"));
        chart.getSeries().get(0).setYValues(chart.getChartData().get("B2", "B5"));
        chart.getSeries().get(0).getBubbles().add(chart.getChartData().get("C2"));
        chart.getSeries().get(0).getBubbles().add(chart.getChartData().get("C3"));
        chart.getSeries().get(0).getBubbles().add(chart.getChartData().get("C4"));
        chart.getSeries().get(0).getBubbles().add(chart.getChartData().get("C5"));

        //save the document
        presentation.saveToFile(output, FileFormat.PPTX_2013);
    }

}
