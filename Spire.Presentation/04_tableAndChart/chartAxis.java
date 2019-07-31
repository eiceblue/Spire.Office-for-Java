import com.spire.presentation.*;
import com.spire.presentation.charts.IChart;
import com.spire.presentation.drawing.FillFormatType;
import java.awt.*;

public class chartAxis {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/chartAxis.pptx";
        String outputFile = "output/chartAxis_result.pptx";

        //Create PPT document and load file
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);

        //Get the chart
        IChart chart = (IChart) ((ppt.getSlides().get(0).getShapes().get(0) instanceof IChart) ? ppt.getSlides().get(0).getShapes().get(0) : null);
        chart.getChartTitle().getTextProperties().getParagraphs().get(0).setText("Chart Title");
        //Add a secondary axis to display the value of Series 3
        chart.getSeries().get(2).setUseSecondAxis(true);

        //Set the grid line of secondary axis as invisible
        chart.getSecondaryValueAxis().getMajorGridTextLines().setFillType(FillFormatType.NONE);

        //Set bounds of axis value. Before we assign values, we must set IsAutoMax and IsAutoMin as false, otherwise MS PowerPoint will automatically set the values.
        chart.getPrimaryValueAxis().isAutoMax(false);
        chart.getPrimaryValueAxis().isAutoMin(false);
        chart.getSecondaryValueAxis().isAutoMax(false);
        chart.getSecondaryValueAxis().isAutoMax(false);

        chart.getPrimaryValueAxis().setMinValue(0f);
        chart.getPrimaryValueAxis().setMaxValue(5.0f);
        chart.getSecondaryValueAxis().setMinValue(0f);
        chart.getSecondaryValueAxis().setMaxValue(1.0f);

        //Set axis line format
        chart.getPrimaryValueAxis().getMinorGridLines().setFillType(FillFormatType.SOLID);
        chart.getSecondaryValueAxis().getMinorGridLines().setFillType(FillFormatType.SOLID);
        chart.getPrimaryValueAxis().getMinorGridLines().setWidth(0.1f);
        chart.getSecondaryValueAxis().getMinorGridLines().setWidth(0.1f);
        chart.getPrimaryValueAxis().getMinorGridLines().getSolidFillColor().setColor(Color.lightGray);
        chart.getSecondaryValueAxis().getMinorGridLines().getSolidFillColor().setColor(Color.lightGray);
        chart.getPrimaryValueAxis().getMinorGridLines().setDashStyle(LineDashStyleType.DASH);
        chart.getSecondaryValueAxis().getMinorGridLines().setDashStyle(LineDashStyleType.DASH);

        chart.getPrimaryValueAxis().getMajorGridTextLines().setWidth(0.3f);
        chart.getPrimaryValueAxis().getMajorGridTextLines().getSolidFillColor().setColor(Color.blue);
        chart.getSecondaryValueAxis().getMajorGridTextLines().setWidth(0.3f);
        chart.getSecondaryValueAxis().getMajorGridTextLines().getSolidFillColor().setColor(Color.blue);

        ppt.saveToFile(outputFile, FileFormat.PPTX_2010);
    }
}
