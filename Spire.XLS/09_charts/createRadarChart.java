import com.spire.xls.*;

public class createRadarChart {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Initialize worksheet
        workbook.createEmptySheets(1);
        Worksheet sheet = workbook.getWorksheets().get(0);
        sheet.setName("Chart data");
        sheet.setGridLinesVisible(false);

        //Writes chart data
        CreateChartData(sheet);
        //Add a new  chart worksheet to workbook
        Chart chart = sheet.getCharts().add();

        //Set position of chart
        chart.setLeftColumn(1);
        chart.setTopRow(6);
        chart.setRightColumn(11);
        chart.setBottomRow(29);

        //Set region of chart data
        chart.setDataRange(sheet.getCellRange("A1:C5"));
        chart.setSeriesDataFromRange(false);
        chart.setChartType(ExcelChartType.Radar);


        //Chart title
        chart.setChartTitle("Sale market by region");
        chart.getChartTitleArea().isBold(true);
        chart.getChartTitleArea().setSize(12);

        chart.getPlotArea().getFill().setVisible(false);

        chart.getLegend().setPosition(LegendPositionType.Corner);

        //Save the document
        String output = "output/CreateRadarChart_out.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
    private static void CreateChartData(Worksheet sheet)
    {
        //Product
        sheet.getCellRange("A1").setValue("Product");
        sheet.getCellRange("A2").setValue("Bikes");
        sheet.getCellRange("A3").setValue("Cars");
        sheet.getCellRange("A4").setValue("Trucks");
        sheet.getCellRange("A5").setValue("Buses");

        //Paris
        sheet.getCellRange("B1").setValue("Paris");
        sheet.getCellRange("B2").setNumberValue(4000);
        sheet.getCellRange("B3").setNumberValue(23000);
        sheet.getCellRange("B4").setNumberValue(4000);
        sheet.getCellRange("B5").setNumberValue(30000);

        //New York
        sheet.getCellRange("C1").setValue("New York");
        sheet.getCellRange("C2").setNumberValue(30000);
        sheet.getCellRange("C3").setNumberValue(7600);
        sheet.getCellRange("C4").setNumberValue(18000);
        sheet.getCellRange("C5").setNumberValue(8000);

        //Style
        sheet.getCellRange("A1:C1").getStyle().getFont().isBold(true);
        sheet.getCellRange("A2:C2").getStyle().setKnownColor(ExcelColors.LightYellow);
        sheet.getCellRange("A3:C3").getStyle().setKnownColor(ExcelColors.LightGreen1);
        sheet.getCellRange("A4:C4").getStyle().setKnownColor(ExcelColors.LightOrange);
        sheet.getCellRange("A5:C5").getStyle().setKnownColor(ExcelColors.LightTurquoise);


        sheet.getCellRange("B2:C5").getStyle().setNumberFormat("\"$\"#,##0");
    }

}
