import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.pivottables.*;

public class updateDataSource {
    public static void main(String[] args) {
        // Create a new workbook object
        Workbook workbook = new Workbook();

        // Load an Excel file named "pivotTableExample.xlsx"
        workbook.loadFromFile("data/pivotTableExample.xlsx");

        // Get the worksheet named "Data"
        Worksheet data = workbook.getWorksheets().get("Data");

        // Set the text value of cell A2 in the "Data" worksheet to "NewValue"
        data.getRange().get("A2").setText("NewValue");

        // Set the numeric value of cell D2 in the "Data" worksheet to 28000
        data.getRange().get("D2").setNumberValue(28000);

        // Get the worksheet named "PivotTable"
        Worksheet sheet = workbook.getWorksheets().get("PivotTable");

        // Get the first pivot table from the "PivotTable" worksheet
        XlsPivotTable pt = (XlsPivotTable) sheet.getPivotTables().get(0);

        // Enable refresh on load for the pivot table cache
        pt.getCache().isRefreshOnLoad(true);

        // Calculate the data for the pivot table
        pt.calculateData();

        // Specify the output file path as "output/updateDataSource_result.xlsx"
        String result = "output/updateDataSource_result.xlsx";

        // Save the modified workbook to a new file with Excel 2013 format
        workbook.saveToFile(result, ExcelVersion.Version2013);

        // Release resources associated with the workbook
        workbook.dispose();
    }
}
