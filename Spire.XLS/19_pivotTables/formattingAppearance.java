import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.pivottables.XlsPivotTable;

public class formattingAppearance {
    public static void main(String[] args){
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the Excel file from the specified path
        workbook.loadFromFile("data/PivotTableExample.xlsx");

        // Get the worksheet named "PivotTable"
        Worksheet sheet = workbook.getWorksheets().get("PivotTable");

        // Get the first PivotTable in the worksheet
        XlsPivotTable pt = (XlsPivotTable)sheet.getPivotTables().get(0);

        // Set the built-in style of the PivotTable to PivotStyleLight10
        pt.setBuiltInStyle(PivotBuiltInStyles.PivotStyleLight10);

        // Enable the grid drop zone for the PivotTable
        pt.getOptions().setShowGridDropZone(true);

        // Set the row layout type of the PivotTable to Compact
        pt.getOptions().setRowLayout(PivotTableLayoutType.Compact);

        // Specify the path and name of the output file
        String result = "output/FormattingAppearance_result.xlsx";

        // Save the modified Workbook to the specified output file in Excel 2010 format
        workbook.saveToFile(result, ExcelVersion.Version2010);

        // Clean up resources and release memory used by the Workbook
        workbook.dispose();
    }
}
