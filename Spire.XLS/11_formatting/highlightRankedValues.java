import com.spire.xls.*;
import com.spire.xls.core.*;
import com.spire.xls.core.spreadsheet.collections.*;
import java.awt.*;

public class highlightRankedValues {
    public static void main(String[] args) throws Exception {
        String input = "data/Template_Xls_6.xlsx";
        String output = "output/highlightRankedValues.xlsx";

        //create a workbook.
        Workbook workbook = new Workbook();

        //load the file from disk.
        workbook.loadFromFile(input);

        //get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //apply conditional formatting to range ��D2:D10�� to highlight the top 2 values.
        XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(sheet.getCellRange("D2:D10"));
        IConditionalFormat format1 = xcfs.addTopBottomCondition(TopBottomType.Top, 2);
        format1.setFormatType( ConditionalFormatType.TopBottom);
        format1.setBackColor(Color.RED);

        //apply conditional formatting to range ��E2:E10�� to highlight the bottom 2 values.
        XlsConditionalFormats xcfs1 = sheet.getConditionalFormats().add();
        xcfs1.addRange(sheet.getCellRange("E2:E10"));
        IConditionalFormat format2 = xcfs1.addTopBottomCondition(TopBottomType.Bottom,2);
        format2.setFormatType(ConditionalFormatType.TopBottom);
        format2.setBackColor( Color.green);

        //save to file.
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
