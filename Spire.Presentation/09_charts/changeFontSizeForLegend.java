import com.spire.presentation.*;
import com.spire.presentation.charts.*;

public class changeFontSizeForLegend {
    public static void main(String[] args) throws Exception {
        String input = "data/chartSample2.pptx";
        String output = "output/changeFontSizeForLegend.pptx";

        //create PPT document and load file
        Presentation ppt = new Presentation();
        ppt.loadFromFile(input);

        //get chart on the first slide
        IChart Chart =(IChart)ppt.getSlides().get(0).getShapes().get(0);

        //change legend font size
        Chart.getChartLegend().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().setFontHeight( 17);

        //save the document
        ppt.saveToFile(output, FileFormat.PPTX_2013);
    }
}
