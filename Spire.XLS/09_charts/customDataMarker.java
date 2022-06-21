import com.spire.xls.*;
import com.spire.xls.charts.ChartSerie;

import java.awt.*;

public class customDataMarker {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();
        workbook.createEmptySheets(1);
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Set the value of the cells.
        sheet.getCellRange("A1").setValue("Tom");
        sheet.getCellRange("A2").setNumberValue(1.5);
        sheet.getCellRange("A3").setNumberValue(2.1);
        sheet.getCellRange("A4").setNumberValue(3.6);
        sheet.getCellRange("A5").setNumberValue(5.2);
        sheet.getCellRange("A6").setNumberValue(7.3);
        sheet.getCellRange("A7").setNumberValue(3.1);

        sheet.getCellRange("B1").setValue("Kitty");
        sheet.getCellRange("B2").setNumberValue(2.5);
        sheet.getCellRange("B3").setNumberValue(4.2);
        sheet.getCellRange("B4").setNumberValue(1.3);
        sheet.getCellRange("B5").setNumberValue(3.2);
        sheet.getCellRange("B6").setNumberValue(6.2);
        sheet.getCellRange("B7").setNumberValue(4.7);

        //Create a Scatter-Markers chart based on the sample data
        Chart chart = sheet.getCharts().add(ExcelChartType.ScatterMarkers);

        //Set region of chart data
        chart.setDataRange(sheet.getCellRange("A1:B7"));
        chart.setSeriesDataFromRange(false);
        chart.getPlotArea().setVisible(false);


        //Set position of chart
        chart.setLeftColumn(4);
        chart.setTopRow(5);
        chart.setRightColumn(11);
        chart.setBottomRow(22);

        chart.setChartTitle("Chart with Markers");
        chart.getChartTitleArea().isBold(true);
        chart.getChartTitleArea().setSize(10);



        //Format the markers in the chart by setting the background color, foreground color, type, size and transparency
        ChartSerie cs1 = chart.getSeries().get(0);
        cs1.getDataFormat().setMarkerBackgroundColor( Color.blue);
        cs1.getDataFormat().setMarkerForegroundColor(Color.orange);
        cs1.getDataFormat().setMarkerSize(7);
        cs1.getDataFormat().setMarkerStyle(ChartMarkerType.PlusSign);
        cs1.getDataFormat().setMarkerTransparencyValue(0.8);

        ChartSerie cs2 = chart.getSeries().get(1);
        cs2.getDataFormat().setMarkerBackgroundColor( Color.pink);
        cs2.getDataFormat().setMarkerSize(9);
        cs2.getDataFormat().setMarkerStyle(ChartMarkerType.Triangle);
        cs2.getDataFormat().setMarkerTransparencyValue(0.9);
        //Save to file
        workbook.saveToFile("output/customDataMarker.xlsx", ExcelVersion.Version2013);
    }
}
