import com.spire.xls.*;

public class unlockSimpleSheet {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the workbook from the specified file "data/template_Xls_4.xlsx"
        workbook.loadFromFile("data/template_Xls_4.xlsx");

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Remove protection from the worksheet
        sheet.unprotect();

        // Specify the output file path for the modified workbook
        String result = "output/unlockSimpleSheet_result.xlsx";

        // Save the modified workbook to the specified output file in Excel 2013 format
        workbook.saveToFile(result, ExcelVersion.Version2013);

        // Dispose of the workbook object to release resources
        workbook.dispose();
    }
}
