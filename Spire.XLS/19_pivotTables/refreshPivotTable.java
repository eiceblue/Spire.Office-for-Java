import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.pivottables.*;

public class refreshPivotTable {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the Excel file from the specified path
        workbook.loadFromFile("data/template_Xls_7.xlsx");

        // Get the second worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(1);

        // Set the value of cell D2 in the worksheet to "999"
        sheet.getRange().get("D2").setValue("999");

        // Get the first PivotTable from the first worksheet of the workbook
        XlsPivotTable pt = (XlsPivotTable) workbook.getWorksheets().get(0).getPivotTables().get(0);

        // Set the refresh on load property of the pivot table's cache to true
        pt.getCache().isRefreshOnLoad(true);

        // Specify the path and name of the output file
        String result = "output/refreshPivotTable_result.xlsx";

        // Save the modified workbook to the specified output file in Excel 2013 format
        workbook.saveToFile(result, ExcelVersion.Version2013);

        // Clean up resources and release memory used by the workbook
        workbook.dispose();
    }
}
