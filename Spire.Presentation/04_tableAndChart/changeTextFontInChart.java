import com.spire.presentation.*;
import com.spire.presentation.charts.IChart;
import com.spire.presentation.drawing.FillFormatType;

public class changeTextFontInChart {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/changeTextFontInChart.pptx";
        String outputFile = "output/changeTextFontInChart_result.pptx";

        //Load a PPTX file
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);

        //Get the chart
        IChart chart = (IChart) ((ppt.getSlides().get(0).getShapes().get(0) instanceof IChart) ? ppt.getSlides().get(0).getShapes().get(0) : null);

        chart.getChartTitle().getTextProperties().getParagraphs().get(0).setText("Chart Title");
        //Change the font of title
        chart.getChartTitle().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().setLatinFont(new TextFont("Lucida Sans Unicode"));
        chart.getChartTitle().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().getFill().getSolidColor().setKnownColor(KnownColors.BLUE);
        chart.getChartTitle().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().setFontHeight(30);

        //Change the font of legend
        chart.getChartLegend().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().getFill().getSolidColor().setKnownColor(KnownColors.DARK_GREEN);
        chart.getChartLegend().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().setLatinFont(new TextFont("Lucida Sans Unicode"));

        //Change the font of series
        chart.getPrimaryCategoryAxis().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().getFill().getSolidColor().setKnownColor(KnownColors.RED);
        chart.getPrimaryCategoryAxis().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().getFill().setFillType(FillFormatType.SOLID);
        chart.getPrimaryCategoryAxis().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().setFontHeight(10);
        chart.getPrimaryCategoryAxis().getTextProperties().getParagraphs().get(0).getDefaultCharacterProperties().setLatinFont(new TextFont("Lucida Sans Unicode"));

        ppt.saveToFile(outputFile, FileFormat.PPTX_2010);
    }
}
