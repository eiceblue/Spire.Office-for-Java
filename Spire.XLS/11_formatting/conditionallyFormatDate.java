import com.spire.xls.*;
import com.spire.xls.core.*;
import com.spire.xls.core.spreadsheet.collections.*;
import com.spire.xls.core.spreadsheet.conditionalformatting.*;

import java.awt.*;

public class conditionallyFormatDate {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile("data/Template_Xls_6.xlsx");

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Highlight cells that contain a date occurring in the last 7 days.
        XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(sheet.getAllocatedRange());
        IConditionalFormat conditionalFormat = xcfs.addTimePeriodCondition(TimePeriodType.Last7Days);
        conditionalFormat.setBackColor(Color.orange);

        String result = "output/ConditionallyFormatDate_out.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
