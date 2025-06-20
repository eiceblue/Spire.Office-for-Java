import com.spire.presentation.*;
import com.spire.presentation.charts.*;

public class setTextFontForChartTitle {
    public static void main(String[] args) throws Exception {
        //Create a PowerPoint document.
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/Template_Ppt_3.pptx");

        //Get the chart.
        IChart chart = (IChart)presentation.getSlides().get(0).getShapes().get(0);

        //Set the font for the text on chart title area.
        chart.getChartTitle().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().setLatinFont(new TextFont("Arial Unicode MS"));
        chart.getChartTitle().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().getFill().getSolidColor().setKnownColor(KnownColors.BLUE);
        chart.getChartTitle().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().setFontHeight(50);

        String result = "output/setTextFontForChartTitle_result.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
