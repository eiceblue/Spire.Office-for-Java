import com.spire.xls.*;

public class freezePanes {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the Excel file from the specified path
        workbook.loadFromFile("data/freezePanes.xlsx");

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Freeze panes at row 2, column 1 (second row, first column)
        sheet.freezePanes(2, 1);

        // Specify the output file path for saving the modified workbook
        String output = "output/freezePanes_result.xlsx";

        // Save the workbook to the specified output path in Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Dispose the workbook to release resources
        workbook.dispose();
    }
}
