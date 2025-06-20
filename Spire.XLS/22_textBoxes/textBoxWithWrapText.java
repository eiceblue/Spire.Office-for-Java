import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.shapes.*;

public class textBoxWithWrapText {
    public static void main(String[] args)throws Exception {
        String input = "data/TextBoxSampleB.xlsx";
        String output = "output/textBoxWithWrapText.xlsx";

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load an existing Excel file from the specified input path
        workbook.loadFromFile(input);

        // Get the first Worksheet from the Workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Get the TextBox shape at index 0 from the Worksheet
        XlsTextBoxShape shape = (XlsTextBoxShape) sheet.getTextBoxes().get(0);

        // Enable text wrapping for the TextBox shape
        shape.isWrapText(true);

        // Save the modified Workbook to a new file in Excel 2013 format with the specified output path
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Dispose the Workbook object
        workbook.dispose();
    }
}
