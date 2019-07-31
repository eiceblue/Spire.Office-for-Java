import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class createBubbleChart {
    public static void main(String[] args) throws Exception {
        String outputFile = "output/createBubbleChart_result.pptx";
        String imageFile = "data/bg.png";

        //Create a PPT file.
        Presentation presentation = new Presentation();

        //Set background image
        Rectangle2D.Double rect2 = new Rectangle2D.Double(0, 0, presentation.getSlideSize().getSize().getWidth(), presentation.getSlideSize().getSize().getHeight());
        presentation.getSlides().get(0).getShapes().appendEmbedImage(ShapeType.RECTANGLE, imageFile, rect2);
        presentation.getSlides().get(0).getShapes().get(0).getLine().getFillFormat().getSolidFillColor().setColor(Color.white);

        //Add bubble chart
        Rectangle2D.Double rect1 = new Rectangle2D.Double(90, 100, 550, 320);
        IChart chart = null;
        chart = presentation.getSlides().get(0).getShapes().appendChart(ChartType.BUBBLE, rect1, false);

        //Chart title
        chart.getChartTitle().getTextProperties().setText("Bubble Chart");
        chart.getChartTitle().getTextProperties().isCentered(true);
        chart.getChartTitle().setHeight(30);
        chart.hasTitle(true);

        //Attach the data to chart
        double[] xdata = new double[]{7.7, 8.9, 1.0, 2.4};
        double[] ydata = new double[]{15.2, 5.3, 6.7, 8};
        double[] size = new double[]{1.1, 2.4, 3.7, 4.8};

        chart.getChartData().get(0, 0).setText("X-Value");
        chart.getChartData().get(0, 1).setText("Y-Value");
        chart.getChartData().get(0, 2).setText("Size");

        for (int i = 0; i < xdata.length; ++i) {
            chart.getChartData().get(i + 1, 0).setValue(xdata[i]);
            chart.getChartData().get(i + 1, 1).setValue(ydata[i]);
            chart.getChartData().get(i + 1, 2).setValue(size[i]);
        }

        //Set series label
        chart.getSeries().setSeriesLabel(chart.getChartData().get("B1", "B1"));

        chart.getSeries().get(0).setXValues(chart.getChartData().get("A2", "A5"));
        chart.getSeries().get(0).setYValues(chart.getChartData().get("B2", "B5"));
        chart.getSeries().get(0).getBubbles().add(chart.getChartData().get("C2"));
        chart.getSeries().get(0).getBubbles().add(chart.getChartData().get("C3"));
        chart.getSeries().get(0).getBubbles().add(chart.getChartData().get("C4"));
        chart.getSeries().get(0).getBubbles().add(chart.getChartData().get("C5"));

        //Save the document
        presentation.saveToFile(outputFile, FileFormat.PPTX_2010);
    }
}
