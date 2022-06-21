import com.spire.xls.*;
import com.spire.xls.charts.*;
import java.awt.*;

public class discontinuousData {
    public static void main(String[] args) throws Exception {
        String input = "data/DiscontinuousData.xlsx";
        String output = "output/discontinuousData_output.xlsx";

        Workbook book = new Workbook();
        //load file from disk
        book.loadFromFile(input);

        //get the first sheet
        Worksheet sheet = book.getWorksheets().get(0);

        //add a chart
        Chart chart = sheet.getCharts().add(ExcelChartType.ColumnClustered);
        chart.setSeriesDataFromRange(false);

        //set the position of chart
        chart.setLeftColumn(1);
        chart.setTopRow(10);
        chart.setRightColumn(10);
        chart.setBottomRow(24);

        //add a series
        ChartSerie cs1 = (ChartSerie)chart.getSeries().add();

        //set the name of the cs1
        cs1.setName(sheet.getCellRange("B1").getValue());

        //set discontinuous values for cs1
        cs1.setCategoryLabels(sheet.getCellRange("A2:A3").addCombinedRange(sheet.getCellRange("A5:A6"))
                .addCombinedRange(sheet.getCellRange("A8:A9")));
        cs1.setValues(sheet.getCellRange("B2:B3").addCombinedRange(sheet.getCellRange("B5:B6"))
                .addCombinedRange(sheet.getCellRange("B8:B9")));

        //set the chart type
        cs1.setSerieType(ExcelChartType.ColumnClustered);

        //add a series
        ChartSerie cs2 = (ChartSerie)chart.getSeries().add();
        cs2.setName(sheet.getCellRange("C1").getValue());
        cs2.setCategoryLabels(sheet.getCellRange("A2:A3").addCombinedRange(sheet.getCellRange("A5:A6"))
                .addCombinedRange(sheet.getCellRange("A8:A9")));
        cs2.setValues(sheet.getCellRange("C2:C3").addCombinedRange(sheet.getCellRange("C5:C6"))
                .addCombinedRange(sheet.getCellRange("C8:C9")));
        cs2.setSerieType(ExcelChartType.ColumnClustered);

        chart.setChartTitle("Chart");
        chart.getChartTitleArea().getFont().setSize(20);
        chart.getChartTitleArea().setColor(Color.black);

        chart.getPrimaryValueAxis().hasMajorGridLines(false);

        //save the result file
        book.saveToFile(output, ExcelVersion.Version2013);
    }
}
