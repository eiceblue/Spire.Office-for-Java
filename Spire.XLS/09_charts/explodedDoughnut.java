import com.spire.xls.*;
import com.spire.xls.charts.*;
import java.awt.*;

public class explodedDoughnut {
    public static void main(String[] args) throws Exception {
        String output = "output/explodedDoughnut.xlsx";

        //create a Workbook
        Workbook workbook = new Workbook();

        //get the first sheet and set its name
        Worksheet sheet = workbook.getWorksheets().get(0);
        sheet.setName("ExplodedDoughnut");

        //set chart data
        createChartData(sheet);

        //add a chart
        Chart chart = sheet.getCharts().add();
        chart.setChartType(ExcelChartType.DoughnutExploded);

        //set position of chart
        chart.setLeftColumn(1);
        chart.setTopRow(6);
        chart.setRightColumn(11);
        chart.setBottomRow(29);

        //set region of chart data
        chart.setDataRange(sheet.getCellRange("A1:B5"));
        chart.setSeriesDataFromRange(false);

        //chart title
        chart.setChartTitle("Sales market by country");
        chart.getChartTitleArea().isBold(true);
        chart.getChartTitleArea().setSize(12);

        ChartSeries series = chart.getSeries();
        for (int i = 0;i < series.size();i++ )
        {
            ChartSerie cs = series.get(i);
            cs.getFormat().getOptions().isVaryColor(true);
            cs.getDataPoints().getDefaultDataPoint().getDataLabels().hasValue(true);
        }
        chart.getPlotArea().getFill().setVisible(false);
        chart.getLegend().setPosition(LegendPositionType.Top);

        //save the result file
        workbook.saveToFile(output,ExcelVersion.Version2013);

    }

    private static void createChartData(Worksheet sheet)
    {
        //set value of specified cell
        sheet.getCellRange("A1").setValue("Country");
        sheet.getCellRange("A2").setValue("Cuba");
        sheet.getCellRange("A3").setValue("Mexico");
        sheet.getCellRange("A4").setValue("France");
        sheet.getCellRange("A5").setValue("German");

        sheet.getCellRange("B1").setValue("Sales");
        sheet.getCellRange("B2").setNumberValue(6000);
        sheet.getCellRange("B3").setNumberValue(8000);
        sheet.getCellRange("B4").setNumberValue(9000);
        sheet.getCellRange("B5").setNumberValue(8500);

        //style
        sheet.getCellRange("A1:B1").setRowHeight(15);
        sheet.getCellRange("A1:B1").getCellStyle().setColor(Color.darkGray);
        sheet.getCellRange("A1:B1").getCellStyle().getExcelFont().setColor(Color.white);
        sheet.getCellRange("A1:B1").getCellStyle().setVerticalAlignment(VerticalAlignType.Center);
        sheet.getCellRange("A1:B1").getCellStyle().setHorizontalAlignment(HorizontalAlignType.Center);

        sheet.getCellRange("B2:B5").getCellStyle().setNumberFormat("\"$\"#,##0");
    }
}
