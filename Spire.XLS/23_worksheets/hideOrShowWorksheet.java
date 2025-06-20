import com.spire.xls.*;

public class hideOrShowWorksheet {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the Excel file from the specified path
        workbook.loadFromFile("data/worksheetSample3.xlsx");

        // Set the visibility of the worksheet named "Sheet1" to Hidden
        workbook.getWorksheets().get("Sheet1").setVisibility(WorksheetVisibility.Hidden);

        // Set the visibility of the second worksheet to Visible
        workbook.getWorksheets().get(1).setVisibility(WorksheetVisibility.Visible);

        // Specify the output file path for saving the modified workbook
        String output = "output/hideOrShowWorksheet_result.xlsx";

        // Save the workbook to the specified output path in Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Dispose the workbook to release resources
        workbook.dispose();
    }
}
