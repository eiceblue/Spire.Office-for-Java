import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import com.spire.presentation.drawing.FillFormatType;

public class setTextFontForLegendAndAxis {
    public static void main(String[] args) throws Exception {
        //Create a PowerPonit document.
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/Template_Ppt_2.pptx");

        //Get the chart.
        IChart chart = (IChart)presentation.getSlides().get(0).getShapes().get(0);

        //Set the font for the text on Chart Legend area.
        chart.getChartLegend().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().getFill().getSolidColor().setKnownColor(KnownColors.GREEN) ;
        chart.getChartLegend().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().setLatinFont(new TextFont("Arial Unicode MS"));

        //Set the font for the text on Chart Axis area.
        chart.getPrimaryCategoryAxis().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().getFill().getSolidColor().setKnownColor(KnownColors.RED);
        chart.getPrimaryCategoryAxis().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().getFill().setFillType(FillFormatType.SOLID);
        chart.getPrimaryCategoryAxis().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().setFontHeight(10);
        chart.getPrimaryCategoryAxis().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().setLatinFont(new TextFont("Arial Unicode MS"));

        String result = "output/setTextFontOfChartLegendAndChartAxis_result.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
