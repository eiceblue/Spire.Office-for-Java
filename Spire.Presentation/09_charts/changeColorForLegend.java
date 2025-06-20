import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import com.spire.presentation.drawing.*;
import java.awt.*;

public class changeColorForLegend {
    public static void main(String[] args) throws Exception {
        String input = "data/chartSample2.pptx";
        String output = "output/changeColorForLegend.pptx";

        //create PPT document and load file
        Presentation ppt = new Presentation();
        ppt.loadFromFile(input);

        //get chart on the first slide
        IChart Chart =(IChart)ppt.getSlides().get(0).getShapes().get(0);

        //change the fill color
        Chart.getChartLegend().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().getFill().setFillType(FillFormatType.SOLID);
        Chart.getChartLegend().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().getFill().getSolidColor().setColor(Color.BLUE);

        //use italic for the paragraph
        Chart.getChartLegend().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().isItalic(TriState.TRUE);

        //save the document
        ppt.saveToFile(output, FileFormat.PPTX_2013);
    }
}
