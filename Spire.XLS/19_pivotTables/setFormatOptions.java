import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.pivottables.*;

public class setFormatOptions {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load an existing Excel file into the Workbook
        workbook.loadFromFile("data/PivotTableExample.xlsx");

        // Get the worksheet named "PivotTable" from the Workbook
        Worksheet sheet = workbook.getWorksheets().get("PivotTable");

        // Get the first PivotTable from the worksheet
        XlsPivotTable pt = (XlsPivotTable)sheet.getPivotTables().get(0);

        // Enable automatic formatting for the PivotTable
        pt.getOptions().isAutoFormat(true);

        // Show row grand totals in the PivotTable
        pt.setShowRowGrand(true);

        // Show column grand totals in the PivotTable
        pt.setShowColumnGrand(true);

        // Display the string "null" for cells with null values in the PivotTable
        pt.setDisplayNullString(true);
        pt.setNullString("null");

        // Set the page field order in the PivotTable to DownThenOver
        pt.setPageFieldOrder(PagesOrderType.DownThenOver);

        // Specify the output file path and name
        String result = "output/SetFormatOptions_out.xlsx";

        // Save the Workbook to the specified file in Excel 2010 format
        workbook.saveToFile(result, ExcelVersion.Version2010);

        // Release resources associated with the Workbook
        workbook.dispose();
    }
}
