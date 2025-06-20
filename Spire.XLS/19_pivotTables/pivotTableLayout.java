import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.pivottables.XlsPivotTable;

public class pivotTableLayout {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();
        // Load data from the specified Excel file
        workbook.loadFromFile("data/PivotTable.xlsx");

        // Get the first worksheet from the workbook
        Worksheet worksheet = workbook.getWorksheets().get(0);

        // Get the first pivot table from the worksheet
        XlsPivotTable xlsPivotTable = (XlsPivotTable)worksheet.getPivotTables().get(0);

        // Set the report layout of the pivot table to Tabular
        xlsPivotTable.getOptions().setReportLayout(PivotTableLayoutType.Tabular);

        // Save the modified workbook to the specified file in Excel 2013 format
        workbook.saveToFile("PivotLayoutTabular_output.xlsx", ExcelVersion.Version2013);

        // Clean up resources and release memory
        workbook.dispose();
    }
}
