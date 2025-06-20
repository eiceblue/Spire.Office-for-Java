import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.pivottables.*;

public class expandOrCollapseRows {
    public static void main(String[] args) {
        // Create a new workbook object
        Workbook workbook = new Workbook();
        // Load an existing template Excel file
        workbook.loadFromFile("data/template_Xls_7.xlsx");

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);
        // Get the first pivot table on the worksheet
        XlsPivotTable pivotTable = (XlsPivotTable) sheet.getPivotTables().get(0);
        // Calculate the data for the pivot table
        pivotTable.calculateData();

        // Hide the item detail with the value "3501" in the "Vendor No" pivot field
        ((XlsPivotField) pivotTable.getPivotFields().get("Vendor No")).hideItemDetail("3501", true);

        // Show the item detail with the value "3502" in the "Vendor No" pivot field
        ((XlsPivotField) pivotTable.getPivotFields().get("Vendor No")).hideItemDetail("3502", false);

        // Specify the file path for the resulting Excel file
        String result = "output/expandOrCollapseRowsInPivotTable_result.xlsx";
        // Save the workbook to the specified file path in Excel 2013 format
        workbook.saveToFile(result, ExcelVersion.Version2013);
        // Clean up any resources used by the workbook
        workbook.dispose();
    }
}
