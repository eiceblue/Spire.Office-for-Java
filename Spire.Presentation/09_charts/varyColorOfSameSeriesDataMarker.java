import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import com.spire.presentation.charts.entity.*;
import com.spire.presentation.drawing.FillFormatType;

import java.awt.*;

public class varyColorOfSameSeriesDataMarker {
    public static void main(String[] args) throws Exception {
        //Create a PowerPoint document.
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/VaryColorsOfSameSeriesDataMarkers.pptx");

        //Get the chart from the presentation.
        IChart chart = (IChart)presentation.getSlides().get(0).getShapes().get(0);

        //Create a ChartDataPoint object and specify the index.
        ChartDataPoint dataPoint = new ChartDataPoint(chart.getSeries().get(0));
        dataPoint.setIndex(0);

        //Set the fill color of the data marker.
        dataPoint.getMarkerFill().getFill().setFillType(FillFormatType.SOLID);
        dataPoint.getMarkerFill().getFill().getSolidColor().setColor(Color.RED);

        //Set the line color of the data marker.
        dataPoint.getMarkerFill().getLine().setFillType(FillFormatType.SOLID);
        dataPoint.getMarkerFill().getLine().getSolidFillColor().setColor(Color.RED);

        //Add the data point to the point collection of a series.
        chart.getSeries().get(0).getDataPoints().add(dataPoint);

        dataPoint = new ChartDataPoint(chart.getSeries().get(0));
        dataPoint.setIndex(1);
        //Set the fill color of the data marker.
        dataPoint.getMarkerFill().getFill().setFillType(FillFormatType.SOLID);
        dataPoint.getMarkerFill().getFill().getSolidColor().setColor(Color.BLACK);

        //Set the line color of the data marker.
        dataPoint.getMarkerFill().getLine().setFillType(FillFormatType.SOLID);
        dataPoint.getMarkerFill().getLine().getSolidFillColor().setColor(Color.BLACK);
        chart.getSeries().get(0).getDataPoints().add(dataPoint);

        dataPoint = new ChartDataPoint(chart.getSeries().get(0));
        dataPoint.setIndex(2);
        //Set the fill color of the data marker.
        dataPoint.getMarkerFill().getFill().setFillType(FillFormatType.SOLID);
        dataPoint.getMarkerFill().getFill().getSolidColor().setColor(Color.BLUE);

        //Set the line color of the data marker.
        dataPoint.getMarkerFill().getLine().setFillType(FillFormatType.SOLID);
        dataPoint.getMarkerFill().getLine().getSolidFillColor().setColor(Color.BLUE);
        chart.getSeries().get(0).getDataPoints().add(dataPoint);

        String result = "output/varyColorsOfSameSeriesDataMarkers_result.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2010);
    }
}
