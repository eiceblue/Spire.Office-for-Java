import com.spire.presentation.*;
import com.spire.presentation.charts.*;

public class changeFontForChartDataTable {
    public static void main(String[] args) throws Exception {
        String input = "data/chartSample2.pptx";
        String output = "output/changeFontForChartDataTable.pptx";

        //create PPT document and load file
        Presentation ppt = new Presentation();
        ppt.loadFromFile(input);

        //get chart on the first slide
        IChart Chart =(IChart)ppt.getSlides().get(0).getShapes().get(0);
        Chart.hasDataTable( true);

        //add a new paragraph in data table
        Chart.getChartDataTable().getText().getParagraphs().append(new ParagraphEx());

        //change the font size
        Chart.getChartDataTable().getText().getParagraphs().get(0).getDefaultCharacterProperties().setFontHeight(15);

        //save the document
        ppt.saveToFile(output, FileFormat.PPTX_2013);
    }
}
