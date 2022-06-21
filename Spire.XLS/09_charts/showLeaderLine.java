import com.spire.xls.*;
import com.spire.xls.charts.ChartSerie;

public class showLeaderLine {
    public static void main(String[] args) throws Exception {
        String output = "output/showLeaderLine.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();
        workbook.setVersion(ExcelVersion.Version2013);

        //get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //set value of specified range
        sheet.getCellRange("A1").setValue("1");
        sheet.getCellRange("A2").setValue("2");
        sheet.getCellRange("A3").setValue("3");
        sheet.getCellRange("B1").setValue("4");
        sheet.getCellRange("B2").setValue("5");
        sheet.getCellRange("B3").setValue("6");
        sheet.getCellRange("C1").setValue("7");
        sheet.getCellRange("C2").setValue("8");
        sheet.getCellRange("C3").setValue("9");

        Chart chart = sheet.getCharts().add(ExcelChartType.BarStacked);
        chart.setDataRange(sheet.getCellRange("A1:C3"));
        chart.setTopRow(4);
        chart.setLeftColumn(2);
        chart.setWidth(450);
        chart.setHeight(300);

        for (
                ChartSerie cs : (Iterable<ChartSerie>) chart.getSeries()) {
            cs.getDataPoints().getDefaultDataPoint().getDataLabels().hasValue(true);
            //show the leader lines
            cs.getDataPoints().getDefaultDataPoint().getDataLabels().setShowLeaderLines(true);
        }
        //save the file
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
