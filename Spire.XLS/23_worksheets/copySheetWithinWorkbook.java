import com.spire.xls.*;

public class copySheetWithinWorkbook {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load an existing Excel file named "template_Xls_4.xlsx"
        workbook.loadFromFile("data/template_Xls_4.xlsx");

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Add a new worksheet to the workbook and assign it to the 'sheet1' variable
        Worksheet sheet1 = workbook.getWorksheets().add("MySheet");

        // Get the range of cells that are allocated with data in the source worksheet
        CellRange sourceRange = sheet.getAllocatedRange();

        // Copy the source range from the source worksheet to the destination worksheet ('sheet1')
        // Starting from the first row and column of the source worksheet, and overwrite existing data
        sheet.copy(sourceRange, sheet1, sheet.getFirstRow(), sheet.getFirstColumn(), true);

        // Specify the output file path for the modified Workbook
        String result = "output/copySheetWithinWorkbook_result.xlsx";

        // Save the Workbook to the specified output file path in Excel 2013 format
        workbook.saveToFile(result, ExcelVersion.Version2013);

        // Clean up system resources by disposing of the Workbook object
        workbook.dispose();
    }
}
