import com.spire.presentation.*;
import com.spire.presentation.charts.*;

public class addCustomErrorBars {
    public static void main(String[] args) throws Exception {
        String input = "data/chartSample.pptx";
        String output = "output/addCustomErrorBars.pptx";

        //create PPT document and load file
        Presentation ppt = new Presentation();
        ppt.loadFromFile(input);

        //get the bubble chart on the first slide
        IChart bubbleChart = (IChart)ppt.getSlides().get(0).getShapes().get(0) ;

        //get X error bars of the first chart series
        IErrorBarsFormat errorBarsXFormat = bubbleChart.getSeries().get(0).getErrorBarsXFormat();

        //specify error amount type as custom error bars
        errorBarsXFormat.setErrorBarvType((ErrorValueType.CUSTOM_ERROR_BARS).getValue());

        //set the minus and plus value of the X error bars
        errorBarsXFormat.setMinusVal(0.5f);
        errorBarsXFormat.setPlusVal( 0.5f);

        //get Y error bars of the first chart series
        IErrorBarsFormat errorBarsYFormat = bubbleChart.getSeries().get(0).getErrorBarsYFormat();

        //specify error amount type as custom error bars
        errorBarsYFormat.setErrorBarvType((ErrorValueType.CUSTOM_ERROR_BARS).getValue());

        //set the minus and plus value of the Y error bars
        errorBarsYFormat.setMinusVal(1f);
        errorBarsYFormat.setPlusVal( 1f);

         //save the document
        ppt.saveToFile(output, FileFormat.PPTX_2013);
    }
}
