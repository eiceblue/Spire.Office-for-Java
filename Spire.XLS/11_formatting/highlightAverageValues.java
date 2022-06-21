import com.spire.xls.*;
import com.spire.xls.core.*;
import com.spire.xls.core.spreadsheet.collections.*;
import java.awt.*;

public class highlightAverageValues {
    public static void main(String[] args) throws Exception {
        String input = "data/Template_Xls_6.xlsx";
        String output = "output/highlightAverageValues.xlsx";

        //create a workbook.
        Workbook workbook = new Workbook();

        //load the file from disk.
        workbook.loadFromFile(input);

        //get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //add conditional format1.
        XlsConditionalFormats format1 = sheet.getConditionalFormats().add();
        //set the cell range to apply the formatting.
        format1.addRange(sheet.getCellRange("E2:E10"));
        //add below average condition.
        IConditionalFormat cf1 = format1.addAverageCondition(AverageType.Below);
        //highlight cells below average values.
        cf1.setBackColor(Color.BLUE);

        //add conditional format2.
        XlsConditionalFormats format2 = sheet.getConditionalFormats().add();
        //set the cell range to apply the formatting.
        format2.addRange(sheet.getCellRange("E2:E10"));
        //add above average condition.
        IConditionalFormat cf2 = format1.addAverageCondition(AverageType.Above);
        //highlight cells above average values.
        cf2.setBackColor(Color.ORANGE);

        //save to file.
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
