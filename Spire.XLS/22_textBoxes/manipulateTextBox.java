import com.spire.xls.*;
import com.spire.xls.core.*;

public class manipulateTextBox {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load an existing Excel file from the specified path
        workbook.loadFromFile("data/manipulateTextBoxControl.xlsx");

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Get the first TextBox shape from the worksheet
        ITextBox tb = sheet.getTextBoxes().get(0);

        // Set the text content of the TextBox
        tb.setText("Spire.XLS for Java");

        // Set the horizontal alignment of the TextBox to Center
        tb.setHAlignment(CommentHAlignType.Center);

        // Set the vertical alignment of the TextBox to Center
        tb.setVAlignment(CommentVAlignType.Center);

        // Specify the path for the output file
        String output = "output/manipulateTextBoxControl_result.xlsx";

        // Save the modified workbook to the output file in Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Dispose the workbook object to release resources
        workbook.dispose();
    }
}
