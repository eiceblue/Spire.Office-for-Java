import com.spire.xls.*;
import com.spire.xls.core.*;

public class createPivotChart {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/PivotTable.xlsx");

        //get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);
        //get the first pivot table in the worksheet
        IPivotTable pivotTable = sheet.getPivotTables().get(0);

        //create a clustered column chart based on the pivot table
        Chart chart = sheet.getCharts().add(ExcelChartType.ColumnClustered, pivotTable);
        //set chart position
        chart.setTopRow(12);
        chart.setLeftColumn(1);
        chart.setRightColumn(8);
        chart.setBottomRow(30);
        //set chart title
        chart.setChartTitle("Pivot Chart");

        //Save the document
        String output = "output/CreatePivotChart_out.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
