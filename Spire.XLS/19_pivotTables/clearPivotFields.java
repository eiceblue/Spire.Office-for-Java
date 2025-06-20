import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.pivottables.*;

public class clearPivotFields {
    public static void main(String[] args)throws Exception {
        String input = "data/PivotTableExample.xlsx";
        String output = "output/clearPivotFields.xlsx";

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the workbook from the input file
        workbook.loadFromFile(input);

        // Get the worksheet named "PivotTable"
        Worksheet sheet = workbook.getWorksheets().get("PivotTable");

        // Get the first PivotTable in the worksheet
        XlsPivotTable pt = (XlsPivotTable)sheet.getPivotTables().get(0);

        // Clear all data fields in the PivotTable
        pt.getDataFields().clear();

        // Calculate the data in the PivotTable
        pt.calculateData();

        // Save the workbook to the output file using Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Dispose the workbook object to release resources
        workbook.dispose();
    }
}
