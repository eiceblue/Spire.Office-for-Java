import com.spire.xls.*;
import com.spire.xls.charts.*;
import java.awt.*;

public class setAndFormatDataLabel {
    public static void main(String[] args) throws Exception {
        String output = "output/setAndFormatDataLabel.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();

        workbook.createEmptySheets(1);
        Worksheet sheet = workbook.getWorksheets().get(0);

        sheet.setName("Demo");
        sheet.getCellRange("A1").setValue("Month");
        sheet.getCellRange("A2").setValue("Jan");
        sheet.getCellRange("A3").setValue( "Feb");
        sheet.getCellRange("A4").setValue("Mar");
        sheet.getCellRange("A5").setValue( "Apr");
        sheet.getCellRange("A6").setValue( "May");
        sheet.getCellRange("A7").setValue( "Jun");
        sheet.getCellRange("B1").setValue( "Peter");
        sheet.getCellRange("B2").setNumberValue( 25);
        sheet.getCellRange("B3").setNumberValue(18);
        sheet.getCellRange("B4").setNumberValue( 8);
        sheet.getCellRange("B5").setNumberValue(13);
        sheet.getCellRange("B6").setNumberValue( 22);
        sheet.getCellRange("B7").setNumberValue( 28);

        Chart chart = sheet.getCharts().add(ExcelChartType.LineMarkers);
        chart.setDataRange(sheet.getCellRange("B1:B7"));
        chart.getPlotArea().setVisible(false);
        chart.setSeriesDataFromRange( false);
        chart.setTopRow(5);
        chart.setBottomRow(26);
        chart.setLeftColumn(2);
        chart.setRightColumn(11);
        chart.setChartTitle("Data Labels Demo");
        chart.getChartTitleArea().isBold(true);
        chart.getChartTitleArea().setSize(12);
        ChartSerie cs1 = chart.getSeries().get(0);
        cs1.setCategoryLabels(sheet.getCellRange("A2:A7"));

        cs1.getDataPoints().getDefaultDataPoint().getDataLabels().hasValue(true);
        cs1.getDataPoints().getDefaultDataPoint().getDataLabels().hasLegendKey(false);
        cs1.getDataPoints().getDefaultDataPoint().getDataLabels().hasPercentage(false);
        cs1.getDataPoints().getDefaultDataPoint().getDataLabels().hasSeriesName (true);
        cs1.getDataPoints().getDefaultDataPoint().getDataLabels().hasCategoryName ( true);
        cs1.getDataPoints().getDefaultDataPoint().getDataLabels().setDelimiter( ". ");

        cs1.getDataPoints().getDefaultDataPoint().getDataLabels().setSize(9);
        cs1.getDataPoints().getDefaultDataPoint().getDataLabels().setColor(Color.RED);
        cs1.getDataPoints().getDefaultDataPoint().getDataLabels().setFontName( "Calibri");
        cs1.getDataPoints().getDefaultDataPoint().getDataLabels().setPosition(DataLabelPositionType.Center);

        //save the document
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
