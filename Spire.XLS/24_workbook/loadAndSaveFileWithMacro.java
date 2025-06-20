import com.spire.xls.*;

public class loadAndSaveFileWithMacro {
    public static void main(String[] args) {
        // Create a new instance of Workbook
        Workbook workbook = new Workbook();

        // Load an existing Excel file with macros from the specified path
        workbook.loadFromFile("data/macroSample.xls");

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Set the text "This is a simple test!" to cell A5 in the worksheet
        sheet.getRange().get("A5").setText("This is a simple test!");

        // Specify the output file path for saving the modified workbook
        String output = "output/loadAndSaveFileWithMacro_result.xls";

        // Save the workbook as an Excel 97-2003 file format
        workbook.saveToFile(output, ExcelVersion.Version97to2003);

        // Clean up and release resources used by the workbook
        workbook.dispose();
    }
}
