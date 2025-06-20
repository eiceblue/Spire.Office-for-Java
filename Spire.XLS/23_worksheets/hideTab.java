import com.spire.xls.*;
public class hideTab {
    public static void main(String[] args) {
        // Create a new workbook object
        Workbook workbook = new Workbook();

        // Load an existing Excel file named "WorksheetSample2.xlsx"
        workbook.loadFromFile("data/WorksheetSample2.xlsx");

        // Hide the worksheet tabs in the workbook
        workbook.setShowTabs(false);

        // Specify the output file path and name as "output/HideTab_out.xlsx"
        String output = "output/HideTab_out.xlsx";

        // Save the modified workbook to the specified output file in Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Dispose of the workbook object to release any resources used
        workbook.dispose();
    }
}
