import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import com.spire.presentation.drawing.*;

public class hideAxisAndGridLine {
    public static void main(String[] args) throws Exception {
        //Create PPT document and load file
        Presentation ppt = new Presentation();
        ppt.loadFromFile("data/ChartSample2.pptx");

        //Get chart on the first slide
        IChart chart = (IChart)ppt.getSlides().get(0).getShapes().get(0);

        //Hide axis
        chart.getPrimaryCategoryAxis().isVisible(false);
        chart.getPrimaryValueAxis().isVisible(false);

        //Remove grid line
       chart.getPrimaryValueAxis().getMajorGridTextLines().setFillType(FillFormatType.NONE);

        String result = "output/hideAxisAndGridline_result.pptx";
        //Save the document
        ppt.saveToFile(result, FileFormat.PPTX_2010);
    }
}
