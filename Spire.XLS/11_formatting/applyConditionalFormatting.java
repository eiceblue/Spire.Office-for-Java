import com.spire.xls.*;
import com.spire.xls.core.*;
import com.spire.xls.core.spreadsheet.collections.*;
import java.awt.*;

public class applyConditionalFormatting {
    public static void main(String[] args) throws Exception {
        String output = "output/applyConditionalFormatting.xlsx";

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

        //create conditional formatting rule.
        XlsConditionalFormats xcfs1 = sheet.getConditionalFormats().add();
        xcfs1.addRange(sheet.getAllocatedRange());
        IConditionalFormat format1 = xcfs1.addCondition();
        format1.setFormatType( ConditionalFormatType.CellValue);
        format1.setFirstFormula( "800");
        format1.setOperator( ComparisonOperatorType.Greater);
        format1.setFontColor(Color.RED);
        format1.setBackColor( Color.LIGHT_GRAY);

        //create conditional formatting rule.
        XlsConditionalFormats xcfs2 = sheet.getConditionalFormats().add();
        xcfs2.addRange(sheet.getAllocatedRange());
        IConditionalFormat format2 = xcfs1.addCondition();
        format2.setFormatType( ConditionalFormatType.CellValue);
        format2.setFirstFormula( "300");
        format2.setOperator( ComparisonOperatorType.Less);
        format2.setFontColor( Color.GREEN);
        format2.setBackColor(Color.BLUE);

        //save to file.
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
