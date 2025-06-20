import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.shapes.*;

public class setInternalMarginOfTextbox {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load an existing Excel file from the specified path
        workbook.loadFromFile("data/template_Xls_4.xlsx");

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Add a TextBox shape to the worksheet at position (4, 2) with width 100 and height 300
        XlsTextBoxShape textbox = (XlsTextBoxShape) sheet.getTextBoxes().addTextBox(4, 2, 100, 300);

        // Set the text content of the TextBox
        textbox.setText("Insert TextBox in Excel and set the margin for the text");

        // Set the horizontal alignment of the TextBox to Center
        textbox.setHAlignment(CommentHAlignType.Center);

        // Set the vertical alignment of the TextBox to Center
        textbox.setVAlignment(CommentVAlignType.Center);

        // Set the inner left margin of the TextBox to 1 point
        textbox.setInnerLeftMargin(1);

        // Set the inner right margin of the TextBox to 3 points
        textbox.setInnerRightMargin(3);

        // Set the inner top margin of the TextBox to 1 point
        textbox.setInnerTopMargin(1);

        // Set the inner bottom margin of the TextBox to 1 point
        textbox.setInnerBottomMargin(1);

        // Specify the path for the output file
        String result = "output/setInternalMarginOfTextbox_result.xlsx";

        // Save the modified workbook to the output file in Excel 2013 format
        workbook.saveToFile(result, ExcelVersion.Version2013);

        // Dispose the workbook object to release resources
        workbook.dispose();
    }
}
