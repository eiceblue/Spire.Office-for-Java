import com.spire.xls.*;

public class unfreezeExcelPanes {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load an Excel file from the specified path
        workbook.loadFromFile("data/template_Xls_2.xlsx");

        // Get the first worksheet from the Workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Remove all panes from the worksheet
        sheet.removePanes();

        // Specify the output file path for saving the modified Workbook
        String output = "output/unfreezeExcelPanes_result.xlsx";
        // Save the Workbook to the specified file path in Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Release any resources used by the Workbook object
        workbook.dispose();
    }
}
