import com.spire.xls.*;
import com.spire.xls.core.*;
import com.spire.xls.core.spreadsheet.collections.*;

public class applyColorScalesToDataRange {
    public static void main(String[] args) throws Exception {
        String output = "output/applyColorScalesToDataRange.xlsx";

        //create a workbook.
        Workbook workbook = new Workbook();

        //get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //insert data to cell range from A1 to C4.
        sheet.getCellRange("A1").setNumberValue( 582);
        sheet.getCellRange("A2").setNumberValue( 234);
        sheet.getCellRange("A3").setNumberValue( 314);
        sheet.getCellRange("A4").setNumberValue( 50);
        sheet.getCellRange("B1").setNumberValue( 150);
        sheet.getCellRange("B2").setNumberValue( 894);
        sheet.getCellRange("B3").setNumberValue(560);
        sheet.getCellRange("B4").setNumberValue( 900);
        sheet.getCellRange("C1").setNumberValue( 134);
        sheet.getCellRange("C2").setNumberValue( 700);
        sheet.getCellRange("C3").setNumberValue(920);
        sheet.getCellRange("C4").setNumberValue( 450);
        sheet.getAllocatedRange().setRowHeight(15 );
        sheet.getAllocatedRange().setColumnWidth(17);

        //add color scales.
        XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(sheet.getAllocatedRange());
        IConditionalFormat format = xcfs.addCondition();
        format.setFormatType( ConditionalFormatType.ColorScale);

        //save to file.
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
