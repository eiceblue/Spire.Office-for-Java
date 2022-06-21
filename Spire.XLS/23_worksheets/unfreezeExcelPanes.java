import com.spire.xls.*;

public class unfreezeExcelPanes {
    public static void main(String[] args) {
        // Create a workbook
        Workbook workbook = new Workbook();

        // Load the file from disk
        workbook.loadFromFile("data/template_Xls_2.xlsx");

        // Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Unfreeze the panes
        sheet.removePanes();

        // Save the document
        String output = "output/unfreezeExcelPanes_result.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);

    }
}
