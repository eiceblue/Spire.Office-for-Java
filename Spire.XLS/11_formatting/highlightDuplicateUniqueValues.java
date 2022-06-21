import com.spire.xls.*;
import com.spire.xls.core.*;
import com.spire.xls.core.spreadsheet.collections.*;
import java.awt.*;

public class highlightDuplicateUniqueValues {
    public static void main(String[] args) throws Exception {
        String input = "data/Template_Xls_6.xlsx";
        String output = "output/highlightDuplicateUniqueValues.xlsx";

        //create a workbook.
        Workbook workbook = new Workbook();

        //load the file from disk.
        workbook.loadFromFile(input);

        //get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //use conditional formatting to highlight duplicate values in range "C2:C10" with IndianRed color.
        XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(sheet.getCellRange("C2:C10"));
        IConditionalFormat format1 = xcfs.addCondition();
        format1.setFormatType( ConditionalFormatType.DuplicateValues);
        format1.setBackColor(Color.RED);

        //use conditional formatting to highlight unique values in range "C2:C10" with Yellow color.
        XlsConditionalFormats xcfs1 = sheet.getConditionalFormats().add();
        xcfs1.addRange(sheet.getCellRange("C2:C10"));
        IConditionalFormat format2 = xcfs.addCondition();
        format2.setFormatType( ConditionalFormatType.UniqueValues);
        format2.setBackColor( Color.YELLOW);

        //save to file.
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
