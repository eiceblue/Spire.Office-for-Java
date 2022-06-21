import com.spire.xls.*;
import com.spire.xls.core.*;

public class replaceTextInTextBox {
    public static void main(String[] args) {
        // Create a workbook
        Workbook workbook = new Workbook();

        // Load the document from disk
        workbook.loadFromFile("data/replaceTextInTextBox.xlsx");

        // Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        String tag = "TAG_1,TAG_2";
        String replace = "Spire.XLS for JAVA,Spire.XLS for .NET";
        for (int i = 0; i < tag.split(",").length; i++) {
            // Replace text in textbox
            ReplaceTextInTextBox(sheet, "<" + tag.split(",")[i] + ">", replace.split(",")[i]);
        }

        // Save the document
        String output = "output/replaceTextInTextBox_result.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }

    private static void ReplaceTextInTextBox(Worksheet sheet, String sFind, String sReplace) {
        for (int i = 0; i < sheet.getTextBoxes().getCount(); i++) {
            ITextBox tb = sheet.getTextBoxes().get(i);
            if (tb.getText() != "" && tb.getText() != null) {
                if (tb.getText().contains(sFind)) {
                    tb.setText(tb.getText().replace(sFind, sReplace));
                }
            }
        }
    }
}
