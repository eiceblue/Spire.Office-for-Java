import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.pivottables.XlsPivotTable;

public class consolidationFunctions {
    public static void main(String[] args) {
        String inputFile="data/pivotTableExample.xlsx";
        String outputFile="output/consolidationFunctions_result.xlsx";

        //Create a workbook
        Workbook workbook = new Workbook();

        //Load an excel file including pivot table
        workbook.loadFromFile(inputFile);
        //Get the sheet in which the pivot table is located
        Worksheet sheet = workbook.getWorksheets().get("PivotTable");

        XlsPivotTable pt = (XlsPivotTable)sheet.getPivotTables().get(0);

        //Apply Average consolidation function to first data field
        pt.getDataFields().get(0).setSubtotal(SubtotalTypes.Average);

        //Apply Max consolidation function to second data field
        pt.getDataFields().get(1).setSubtotal(SubtotalTypes.Max);

        pt.calculateData();

        //Save to file
        workbook.saveToFile(outputFile, ExcelVersion.Version2010);
    }
}
