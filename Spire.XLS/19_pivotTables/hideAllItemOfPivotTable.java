import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.pivottables.*;

public class hideAllItemOfPivotTable {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();
        // Load data from the specified Excel file
        workbook.loadFromFile("data/pivotTable.xlsx");
        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Get the first pivot table from the worksheet
        XlsPivotTable pivotTable = (XlsPivotTable)sheet.getPivotTables().get(0);
        // Get the PivotField object for the "Product" field
        PivotField pivotField = (PivotField)pivotTable.getPivotFields().get("Product");
        // Hide all items in the "Product" field
        pivotField.hideAllItem(true);

        // Calculate the data in the pivot table
        pivotTable.calculateData();

        // Save the modified workbook to the specified file in Excel 2013 format
        workbook.saveToFile("output/hideAllItemOfPivotTable.xlsx", FileFormat.Version2013);

        // Clean up resources and release memory
        workbook.dispose();
    }
}
