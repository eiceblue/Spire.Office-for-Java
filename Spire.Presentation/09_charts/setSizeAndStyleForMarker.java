import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import com.spire.presentation.charts.entity.ChartDataPoint;
import com.spire.presentation.drawing.FillFormatType;

import java.awt.*;

public class setSizeAndStyleForMarker {
    public static void main(String[] args) throws Exception {
        //Create a PowerPoint document.
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/SetSizeAndStyleForMarker.pptx");

        //Get the chart from the presentation.
        IChart chart = (IChart)presentation.getSlides().get(0).getShapes().get(0);

        for (int i = 0; i < chart.getSeries().get(0).getValues().getCount(); i++) {
            //Create a ChartDataPoint object and specify the index.
            ChartDataPoint dataPoint = new ChartDataPoint(chart.getSeries().get(0));
            dataPoint.setIndex(i);

            //Set the fill color of the data marker.
            dataPoint.getMarkerFill().getFill().setFillType(FillFormatType.SOLID);
            dataPoint.getMarkerFill().getFill().getSolidColor().setColor(Color.yellow);

            //Set the line color of the data marker.
            dataPoint.getMarkerFill().getLine().setFillType(FillFormatType.SOLID);
            dataPoint.getMarkerFill().getLine().getSolidFillColor().setKnownColor(KnownColors.YELLOW_GREEN);

            //Set the size of the data marker.
            dataPoint.setMarkerSize(20);

            //Set the style of the data marker
            dataPoint.setMarkerStyle(ChartMarkerType.DIAMOND);
            chart.getSeries().get(0).getDataPoints().add(dataPoint);
        }

        String result = "output/setSizeAndStyleForMarker_out.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
