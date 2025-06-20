import com.spire.xls.*;
public class showTab {
    public static void main(String[] args) {
        // Create a new Workbook object.
        Workbook workbook = new Workbook();

        // Load an existing Excel file from the specified path.
        workbook.loadFromFile("data/WorksheetSample4.xlsx");

        // Set the show tabs option to true, which displays the worksheet tabs in the Excel application.
        workbook.setShowTabs(true);

        // Specify the output file path for saving the modified workbook.
        String output = "output/ShowTab_out.xlsx";

        // Save the workbook to the specified output file path in Excel 2013 format.
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Dispose of system resources associated with the workbook.
        workbook.dispose();
    }
}
