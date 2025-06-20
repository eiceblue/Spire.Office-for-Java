import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.pivottables.*;

public class formatDataField {
	public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();
        // Load data from the specified Excel file
        workbook.loadFromFile("data/formatDataField.xlsx");
        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Get the first pivot table from the worksheet
        XlsPivotTable pt = (XlsPivotTable)sheet.getPivotTables().get(0);

        // Get the first data field from the pivot table
        PivotDataField pivotDataField = pt.getDataFields().get(0);
        // Set the display format of the data field to "Percentage Of Column"
        pivotDataField.setShowDataAs(PivotFieldFormatType.PercentageOfColumn);

        // Specify the output file path for the modified workbook
        String result = "output/formatDataField_result.xlsx";
        // Save the modified workbook to the specified file in Excel 2013 format
        workbook.saveToFile(result, ExcelVersion.Version2013);
        // Clean up resources and release memory
        workbook.dispose();
	}
}
