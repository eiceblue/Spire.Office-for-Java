import com.spire.xls.*;

public class activateWorksheet {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the workbook from the specified file path
        workbook.loadFromFile("data/worksheetSample2.xlsx");

        // Get the second worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(1);

        // Activate the worksheet
        sheet.activate();

        // Specify the output file path for saving the modified workbook
        String output = "output/activateWorksheet_result.xlsx";

        // Save the workbook to the specified output file path in Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Dispose of the workbook resources to free up memory
        workbook.dispose();
    }
}
