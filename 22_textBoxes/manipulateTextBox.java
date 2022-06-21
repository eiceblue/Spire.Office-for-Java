import com.spire.xls.*;
import com.spire.xls.core.*;

public class manipulateTextBox {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/manipulateTextBoxControl.xlsx");

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Get the first textbox
        ITextBox tb = sheet.getTextBoxes().get(0);

        //Change the text of textbox
        tb.setText("Spire.XLS for Java");

        //Set the alignment of textbox as center
        tb.setHAlignment(CommentHAlignType.Center);
        tb.setVAlignment(CommentVAlignType.Center);

        //Save the document
        String output = "output/manipulateTextBoxControl_result.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
