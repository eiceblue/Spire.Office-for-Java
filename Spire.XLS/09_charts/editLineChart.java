import com.spire.xls.*;
import com.spire.xls.charts.*;

public class editLineChart {
    public static void main(String[] args) throws Exception {
        String input = "data/LineChart.xlsx";
        String output = "output/editLineChart.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();
        workbook.loadFromFile(input);

        //get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //get the line chart
        Chart chart = sheet.getCharts().get(0);

        //add a new series
        ChartSerie cs = chart.getSeries().add("Added");

        //set the values for the series
        cs.setValues(sheet.getCellRange("I1:L1"));

        //save and launch result file
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
