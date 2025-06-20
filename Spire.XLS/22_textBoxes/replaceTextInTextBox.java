import com.spire.xls.*;
import com.spire.xls.core.*;

public class replaceTextInTextBox {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load an existing Excel file from the specified path
        workbook.loadFromFile("data/replaceTextInTextBox.xlsx");

        // Get the first Worksheet from the Workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Specify the tag values to search for and their corresponding replacements
        String tag = "TAG_1,TAG_2";
        String replace = "Spire.XLS for JAVA,Spire.XLS for .NET";

        // Iterate over each tag and its replacement
        for (int i = 0; i < tag.split(",").length; i++) {
            ReplaceTextInTextBox(sheet, "<" + tag.split(",")[i] + ">", replace.split(",")[i]);
        }

        // Specify the output file path
        String output = "output/replaceTextInTextBox_result.xlsx";

        // Save the modified Workbook to a new file in Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Dispose the Workbook object
        workbook.dispose();
    }

    // Helper method to replace text in TextBox shapes within a Worksheet
    private static void ReplaceTextInTextBox(Worksheet sheet, String sFind, String sReplace) {
        // Iterate over each TextBox shape in the Worksheet
        for (int i = 0; i < sheet.getTextBoxes().getCount(); i++) {
            ITextBox tb = sheet.getTextBoxes().get(i);

            // Check if the TextBox has non-empty text
            if (tb.getText() != "" && tb.getText() != null) {
                // Check if the text contains the specified search string
                if (tb.getText().contains(sFind)) {
                    // Replace the search string with the replacement string
                    tb.setText(tb.getText().replace(sFind, sReplace));
                }
            }
        }
    }
}
