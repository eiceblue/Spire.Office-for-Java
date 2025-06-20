import com.spire.presentation.*;
import com.spire.presentation.charts.*;
import com.spire.presentation.drawing.*;

public class changeTextFontInChart {
    public static void main(String[] args) throws Exception {
        String input = "data/Template_Ppt_2.pptx";
        String output = "output/changeTextFontInChart_output.pptx";

        //load a PPTX file
        Presentation ppt = new Presentation();
        ppt.loadFromFile(input);

        //get the chart
        IChart chart = (IChart) ((ppt.getSlides().get(0).getShapes().get(0) instanceof IChart) ? ppt.getSlides().get(0).getShapes().get(0) : null);
        chart.getChartTitle().getTextProperties().getParagraphs().get(0).setText("Chart Title");

        //change the font of title
        chart.getChartTitle().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().setLatinFont(new TextFont("Lucida Sans Unicode"));
        chart.getChartTitle().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().getFill().getSolidColor().setKnownColor(KnownColors.BLUE);
        chart.getChartTitle().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().setFontHeight(30);

        //change the font of legend
        chart.getChartLegend().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().getFill().getSolidColor().setKnownColor(KnownColors.DARK_GREEN);
        chart.getChartLegend().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().setLatinFont(new TextFont("Lucida Sans Unicode"));

        //change the font of series
        chart.getPrimaryCategoryAxis().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().getFill().getSolidColor().setKnownColor(KnownColors.RED);
        chart.getPrimaryCategoryAxis().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().getFill().setFillType(FillFormatType.SOLID);
        chart.getPrimaryCategoryAxis().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().setFontHeight(10);
        chart.getPrimaryCategoryAxis().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().setLatinFont(new TextFont("Lucida Sans Unicode"));

        //save the file
        ppt.saveToFile(output, FileFormat.PPTX_2013);
    }
}
