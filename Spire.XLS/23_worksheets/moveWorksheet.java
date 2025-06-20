import com.spire.xls.*;

public class moveWorksheet {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load an existing Excel file from the specified path
        workbook.loadFromFile("data/worksheetSample2.xlsx");

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Move the worksheet to the index position 2
        sheet.moveWorksheet(2);

        // Specify the output file path for saving the modified workbook
        String output = "output/moveWorksheet_result.xlsx";

        // Save the modified workbook to the specified file path, using Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Clean up resources and release memory associated with the workbook
        workbook.dispose();
    }
}
