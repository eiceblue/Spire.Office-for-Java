import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.shapes.*;

public class setInternalMarginOfTextbox {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the file from disk
        workbook.loadFromFile("data/template_Xls_4.xlsx");

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Add a textbox to the sheet and set its position and size
        XlsTextBoxShape textbox = (XlsTextBoxShape) sheet.getTextBoxes().addTextBox(4, 2, 100, 300);

        //Set the text on the textbox
        textbox.setText("Insert TextBox in Excel and set the margin for the text");
        textbox.setHAlignment(CommentHAlignType.Center);
        textbox.setVAlignment(CommentVAlignType.Center);

        //Set the inner margins of the contents
        textbox.setInnerLeftMargin(1);
        textbox.setInnerRightMargin(3);
        textbox.setInnerTopMargin(1);
        textbox.setInnerBottomMargin(1);

        String result = "output/setInternalMarginOfTextbox_result.xlsx";

        //Save to file
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
