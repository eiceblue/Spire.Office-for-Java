import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.shapes.*;

public class textBoxWithWrapText {
    public static void main(String[] args)throws Exception {
        String input = "data/TextBoxSampleB.xlsx";
        String output = "output/textBoxWithWrapText.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();

        //load the document from disk
        workbook.loadFromFile(input);

        //get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //get the text box
        XlsTextBoxShape shape = (XlsTextBoxShape)sheet.getTextBoxes().get(0);

        //set wrap text
        shape.isWrapText(true);

        //save the document
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
