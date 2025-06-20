import com.spire.xls.*;
import com.spire.xls.core.*;
import com.spire.xls.core.spreadsheet.collections.*;

public class applyColorScalesToDataRange {
    public static void main(String[] args) throws Exception {
        String output = "output/applyColorScalesToDataRange.xlsx";

        //Create a new instance of Workbook
        Workbook workbook = new Workbook();

        //Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Set numeric values for cells A1 to C4 in the worksheet
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

        //Set the row height and column width for the allocated range in the worksheet
        sheet.getAllocatedRange().setRowHeight(15 );
        sheet.getAllocatedRange().setColumnWidth(17);

       //Add conditional formatting to the worksheet
        XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        xcfs.addRange(sheet.getAllocatedRange());
        IConditionalFormat format = xcfs.addCondition();
        format.setFormatType( ConditionalFormatType.ColorScale);

        //Save the workbook to the specified output file path in Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        //Release the resources used by the workbook
        workbook.dispose();
    }
}
