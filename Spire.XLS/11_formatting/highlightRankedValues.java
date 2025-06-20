import com.spire.xls.*;
import com.spire.xls.core.*;
import com.spire.xls.core.spreadsheet.collections.*;
import java.awt.*;

public class highlightRankedValues {
    public static void main(String[] args) throws Exception {
        String input = "data/Template_Xls_6.xlsx";
        String output = "output/highlightRankedValues.xlsx";

        // Create a new workbook
        Workbook workbook = new Workbook();
        workbook.loadFromFile(input);

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Add conditional formats to the worksheet for range D2:D10
        XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(sheet.getCellRange("D2:D10"));

        // Add a top-bottom conditional format to highlight the top 2 values in range D2:D10
        IConditionalFormat format1 = xcfs.addTopBottomCondition(TopBottomType.Top, 2);
        format1.setFormatType(ConditionalFormatType.TopBottom);
        format1.setBackColor(Color.RED);

        // Add conditional formats to the worksheet for range E2:E10
        XlsConditionalFormats xcfs1 = sheet.getConditionalFormats().add();
        xcfs1.addRange(sheet.getCellRange("E2:E10"));

        // Add a top-bottom conditional format to highlight the bottom 2 values in range E2:E10
        IConditionalFormat format2 = xcfs1.addTopBottomCondition(TopBottomType.Bottom, 2);
        format2.setFormatType(ConditionalFormatType.TopBottom);
        format2.setBackColor(Color.GREEN);

        // Save the modified workbook to an output file in Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        //Release the resources used by the workbook
        workbook.dispose();
    }
}
