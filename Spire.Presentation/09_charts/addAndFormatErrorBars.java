import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import com.spire.presentation.drawing.*;
import java.awt.*;

public class addAndFormatErrorBars {
    public static void main(String[] args) throws Exception {
        String input = "data/addAndFormatErrorBars.pptx";
        String output = "output/addAndFormatErrorBars_output.pptx";

        //create a PowerPoint document.
        Presentation presentation = new Presentation();

        //load the file from disk.
        presentation.loadFromFile(input);

        //get the column chart on the first slide and set chart title.
        IChart columnChart = (IChart)presentation.getSlides().get(0).getShapes().get(0);
        columnChart.getChartTitle().getTextProperties().setText("Vertical Error Bars");

        //add Y (Vertical) Error Bars.
        //get Y error bars of the first chart series.
        IErrorBarsFormat errorBarsYFormat1 = columnChart.getSeries().get(0).getErrorBarsYFormat();

        //set end cap.
        errorBarsYFormat1.setErrorBarNoEndCap( false);

        //specify direction.
        errorBarsYFormat1.setErrorBarSimType((ErrorBarSimpleType.PLUS).getValue());

        //specify error amount type.
        errorBarsYFormat1.setErrorBarvType((ErrorValueType.STANDARD_ERROR).getValue());

        //set value.
        errorBarsYFormat1.setErrorBarVal(0.3f);

        //set line format.
        errorBarsYFormat1.getLine().setFillType(FillFormatType.SOLID);
        errorBarsYFormat1.getLine().getSolidFillColor().setColor(Color.RED);
        errorBarsYFormat1.getLine().setWidth(1);

        //get the bubble chart on the second slide and set chart title.
        IChart bubbleChart = (IChart)presentation.getSlides().get(1).getShapes().get(0);
        bubbleChart.getChartTitle().getTextProperties().setText("Vertical and Horizontal Error Bars");

        //add X (Horizontal) and Y (Vertical) Error Bars.
        //get X error bars of the first chart series.
        IErrorBarsFormat errorBarsXFormat = bubbleChart.getSeries().get(0).getErrorBarsXFormat();

        //set end cap.
        errorBarsXFormat.setErrorBarNoEndCap(false);

        //specify direction.
        errorBarsXFormat.setErrorBarvType((ErrorBarSimpleType.BOTH).getValue());

        //specify error amount type.
        errorBarsXFormat.setErrorBarvType((ErrorValueType.STANDARD_ERROR).getValue());

        //set value.
        errorBarsXFormat.setErrorBarVal(0.3f);

        //get Y error bars of the first chart series.
        IErrorBarsFormat errorBarsYFormat2 = bubbleChart.getSeries().get(0).getErrorBarsYFormat();

        //set end cap.
        errorBarsYFormat2.setErrorBarNoEndCap(false);

        //specify direction.
        errorBarsYFormat2.setErrorBarvType((ErrorBarSimpleType.BOTH).getValue());

        //specify error amount type.
        errorBarsYFormat2.setErrorBarvType((ErrorValueType.STANDARD_ERROR).getValue());

        //set value.
        errorBarsYFormat2.setErrorBarVal(0.3f);

        //save the file.
        presentation.saveToFile(output, FileFormat.PPTX_2013);
    }
}
