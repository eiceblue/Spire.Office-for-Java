import com.spire.xls.*;
import com.spire.xls.charts.*;
import java.awt.*;

public class line {
    public static void main(String[] args) {

        //Create a Workbook
        Workbook workbook = new Workbook();

        //Get the first sheet and set its name
        Worksheet sheet = workbook.getWorksheets().get(0);
        sheet.setName("Line Chart");

        //Set chart data
        CreateChartData(sheet);

        //Add a chart
        Chart chart = sheet.getCharts().add();
        chart.setChartType(ExcelChartType.Line);

        //Set region of chart data
        chart.setDataRange(sheet.getCellRange("A1:E5"));

        //Set position of chart
        chart.setLeftColumn(1);
        chart.setTopRow(6);
        chart.setRightColumn(11);
        chart.setBottomRow(29);

        //Set chart title
        chart.setChartTitle("Sales market by country");
        chart.getChartTitleArea().isBold(true);
        chart.getChartTitleArea().setSize(12);

        chart.getPrimaryCategoryAxis().setTitle("Month");
        chart.getPrimaryCategoryAxis().getFont().isBold(true);
        chart.getPrimaryCategoryAxis().getTitleArea().isBold(true);

        chart.getPrimaryValueAxis().setTitle("Sales(in Dollars)");
        chart.getPrimaryValueAxis().hasMajorGridLines(false);
        chart.getPrimaryValueAxis().getTitleArea().setTextRotationAngle(90);
        chart.getPrimaryValueAxis().setMinValue(1000);
        chart.getPrimaryValueAxis().getTitleArea().isBold(true);

        for(ChartSerie cs : (Iterable<ChartSerie>) chart.getSeries())
        {
            cs.getFormat().getOptions().isVaryColor(true);
            cs.getDataPoints().getDefaultDataPoint().getDataLabels().hasValue(true);
            cs.getDataFormat().setMarkerStyle(ChartMarkerType.Circle);
        }

        chart.getPlotArea().getFill().setVisible(false);

        chart.getLegend().setPosition(LegendPositionType.Top);
        workbook.saveToFile("output/Line_out.xlsx",ExcelVersion.Version2010);
    }

    private static void CreateChartData(Worksheet sheet)
    {
        //Set value of specified cell
        sheet.getCellRange("A1").setValue("Country");
        sheet.getCellRange("A2").setValue("Cuba");
        sheet.getCellRange("A3").setValue("Mexico");
        sheet.getCellRange("A4").setValue("France");
        sheet.getCellRange("A5").setValue("German");

        sheet.getCellRange("B1").setValue("Jun");
        sheet.getCellRange("B2").setNumberValue(3300);
        sheet.getCellRange("B3").setNumberValue(2300);
        sheet.getCellRange("B4").setNumberValue(4500);
        sheet.getCellRange("B5").setNumberValue(6700);

        sheet.getCellRange("C1").setValue("Jul");
        sheet.getCellRange("C2").setNumberValue(7500);
        sheet.getCellRange("C3").setNumberValue(2900);
        sheet.getCellRange("C4").setNumberValue(2300);
        sheet.getCellRange("C5").setNumberValue(4200);

        sheet.getCellRange("D1").setValue("Aug");
        sheet.getCellRange("D2").setNumberValue(7400);
        sheet.getCellRange("D3").setNumberValue(6900);
        sheet.getCellRange("D4").setNumberValue(7800);
        sheet.getCellRange("D5").setNumberValue(4200);

        sheet.getCellRange("E1").setValue("Sep");
        sheet.getCellRange("E2").setNumberValue(8000);
        sheet.getCellRange("E3").setNumberValue(7200);
        sheet.getCellRange("E4").setNumberValue(8500);
        sheet.getCellRange("E5").setNumberValue(5600);

        //Set style of cells
        sheet.getCellRange("A1:E1").setRowHeight(15);
        sheet.getCellRange("A1:E1").getCellStyle().setColor(Color.darkGray);
        sheet.getCellRange("A1:E1").getCellStyle().getExcelFont().setColor(Color.white);
        sheet.getCellRange("A1:E1").getCellStyle().setVerticalAlignment(VerticalAlignType.Center);
        sheet.getCellRange("A1:E1").getCellStyle().setHorizontalAlignment(HorizontalAlignType.Center);

        //Set number format of cells
        sheet.getCellRange("B2:D5").getCellStyle().setNumberFormat("\"$\"#,##0");
    }
}
