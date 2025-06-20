import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.pivottables.*;

public class disablePivotTableRibbon {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the workbook from the specified file "data/pivotTableExample.xlsx"
        workbook.loadFromFile("data/pivotTableExample.xlsx");

        // Get the worksheet named "PivotTable" from the workbook
        Worksheet sheet = workbook.getWorksheets().get("PivotTable");

        // Get the first PivotTable in the worksheet
        XlsPivotTable pt = (XlsPivotTable) sheet.getPivotTables().get(0);

        // Disable the wizard for the PivotTable
        pt.setEnableWizard(false);

        // Specify the output file path for the modified workbook
        String result = "output/disablePivotTableRibbon_result.xlsx";

        // Save the modified workbook to the specified output file using Excel 2013 format
        workbook.saveToFile(result, ExcelVersion.Version2013);

        // Dispose of the workbook object to release any associated resources
        workbook.dispose();
    }
}
