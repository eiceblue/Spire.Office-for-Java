import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.pivottables.XlsPivotTable;

public class consolidationFunctions {
    public static void main(String[] args) {
        String inputFile="data/pivotTableExample.xlsx";
        String outputFile="output/consolidationFunctions_result.xlsx";

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the workbook from the specified input file
        workbook.loadFromFile(inputFile);

        // Get the worksheet named "PivotTable" from the workbook
        Worksheet sheet = workbook.getWorksheets().get("PivotTable");

        // Get the first PivotTable from the worksheet
        XlsPivotTable pt = (XlsPivotTable)sheet.getPivotTables().get(0);

        // Set the subtotal type of the first data field to Average
        pt.getDataFields().get(0).setSubtotal(SubtotalTypes.Average);

        // Set the subtotal type of the second data field to Maximum
        pt.getDataFields().get(1).setSubtotal(SubtotalTypes.Max);

        // Calculate the data in the PivotTable
        pt.calculateData();

        // Save the modified workbook to the specified output file in Excel 2010 format
        workbook.saveToFile(outputFile, ExcelVersion.Version2010);

        // Dispose the workbook object to release resources
        workbook.dispose();
    }
}
