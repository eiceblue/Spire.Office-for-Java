import com.spire.xls.*;
import com.spire.xls.core.*;
import com.spire.xls.core.spreadsheet.collections.*;
import com.spire.xls.core.spreadsheet.conditionalformatting.*;
import java.awt.*;

public class conditionallyFormatDate {
    public static void main(String[] args) {
        //Create a new workbook
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile("data/Template_Xls_6.xlsx");

        //Get the first worksheet in the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Add conditional formats to the worksheet for the allocated range
        XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(sheet.getAllocatedRange());
        //Add a time period condition (last 7 days) to the conditional format
        IConditionalFormat conditionalFormat = xcfs.addTimePeriodCondition(TimePeriodType.Last7Days);
        conditionalFormat.setBackColor(Color.orange);

        String result = "output/ConditionallyFormatDate_out.xlsx";

        //Save the workbook to the specified file with Excel 2013 format
        workbook.saveToFile(result, ExcelVersion.Version2013);

        //Release the resources used by the workbook
        workbook.dispose();
    }
}
