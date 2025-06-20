import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.pivottables.XlsPivotTable;

public class customPivotTableFieldName {
    public static void main(String[] args) {
        // Create a workbook
        Workbook workbook = new Workbook();

        // Load an excel file including pivot table
        workbook.loadFromFile("CustomPivotTableFieldName.xlsx");

        // Get the sheet in which the pivot table is located
        Worksheet sheet = workbook.getWorksheets().get("PivotTable");

        // Access the first pivot table in the worksheet
        XlsPivotTable pivotTable = (XlsPivotTable)sheet.getPivotTables().get(0);

        // Set a custom name for the row field
        pivotTable.getRowFields().get(0).setCustomName("rowName");

        // Set a custom name for the column field
        pivotTable.getColumnFields().get(0).setCustomName("colName");

        // Set a custom name for the data field
        pivotTable.getDataFields().get(0).setCustomName("DataName");

        // Calculate the pivot table data
        pivotTable.calculateData();

        // Specify the filename for the resulting workbook
        String result = "CustomPivotTableFieldName_result.xlsx";

        // Save the modified workbook to a file
        workbook.saveToFile(result, ExcelVersion.Version2010);

        // Dispose of the workbook object to release resources
        workbook.dispose();
    }
}
