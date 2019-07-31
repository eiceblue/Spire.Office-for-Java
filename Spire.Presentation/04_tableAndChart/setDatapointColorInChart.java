import com.spire.presentation.*;
import com.spire.presentation.charts.IChart;
import com.spire.presentation.charts.entity.ChartDataPoint;
import com.spire.presentation.drawing.FillFormatType;

public class setDatapointColorInChart {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/setDatapointColorInChart.pptx";
        String outputFile = "output/setDatapointColorInChart_result.pptx";

        //Create a ppt document and load file
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);

        //Get the chart
        IChart chart = (IChart) ((ppt.getSlides().get(0).getShapes().get(0) instanceof IChart) ? ppt.getSlides().get(0).getShapes().get(0) : null);
        chart.getChartTitle().getTextProperties().setText("Chart Title");
        //Initialize an instances of dataPoint
        ChartDataPoint cdp1 = new ChartDataPoint(chart.getSeries().get(0));
        //Specify the datapoint order
        cdp1.setIndex(0);
        //Set the color of the datapoint
        cdp1.getFill().setFillType(FillFormatType.SOLID);
        cdp1.getFill().getSolidColor().setKnownColor(KnownColors.ORANGE);

        //Add the dataPoint to first series
        chart.getSeries().get(0).getDataPoints().add(cdp1);
        //Set the color for the other three data points
        ChartDataPoint cdp2 = new ChartDataPoint(chart.getSeries().get(0));
        cdp2.setIndex(1);
        cdp2.getFill().setFillType(FillFormatType.SOLID);
        cdp2.getFill().getSolidColor().setKnownColor(KnownColors.GOLD);
        chart.getSeries().get(0).getDataPoints().add(cdp2);
        ChartDataPoint cdp3 = new ChartDataPoint(chart.getSeries().get(0));
        cdp3.setIndex(2);
        cdp3.getFill().setFillType(FillFormatType.SOLID);
        cdp3.getFill().getSolidColor().setKnownColor(KnownColors.MEDIUM_PURPLE);
        chart.getSeries().get(0).getDataPoints().add(cdp3);

        ChartDataPoint cdp4 = new ChartDataPoint(chart.getSeries().get(0));
        cdp4.setIndex(1);
        cdp4.getFill().setFillType(FillFormatType.SOLID);
        cdp4.getFill().getSolidColor().setKnownColor(KnownColors.FOREST_GREEN);
        chart.getSeries().get(0).getDataPoints().add(cdp4);

        //Save the file
        ppt.saveToFile(outputFile, FileFormat.PPTX_2010);
    }
}
