import com.spire.xls.*;
import com.spire.xls.core.IConditionalFormat;
import com.spire.xls.core.spreadsheet.collections.XlsConditionalFormats;

import java.awt.*;

public class conditionalFormatRuntime {
    public static void main(String[] args) throws Exception {
            String input = "data/ConditionalFormatRuntime.xlsx";
            String output = "output/conditionalFormatRuntime_output.xlsx";

            //load a file from a disk
            Workbook workbook = new Workbook();
            workbook.loadFromFile(input);

            //get the first sheet
            Worksheet sheet = workbook.getWorksheets().get(0);
            addComparisonRule1(sheet);
            addComparisonRule2(sheet);
            addComparisonRule3(sheet);
            addComparisonRule4(sheet);

            //save to file
            workbook.saveToFile(output, ExcelVersion.Version2013);
        }
        private static void addComparisonRule1(Worksheet sheet)
        {
            //create conditional formatting rule
            XlsConditionalFormats xcfs1 = sheet.getConditionalFormats().add();
            xcfs1.addRange(sheet.getCellRange("A1:D1"));
            IConditionalFormat cf1 = xcfs1.addCondition();
            cf1.setFormatType( ConditionalFormatType.CellValue);
            cf1.setFirstFormula("150");
            cf1.setOperator(ComparisonOperatorType.Greater);
            cf1.setFontColor(Color.RED);
            cf1.setBackColor( Color.BLUE);
        }
        private static void addComparisonRule2(Worksheet sheet)
        {
            XlsConditionalFormats xcfs2 = sheet.getConditionalFormats().add();
            xcfs2.addRange(sheet.getCellRange("A2:D2"));
            IConditionalFormat cf2 = xcfs2.addCondition();
            cf2.setFormatType( ConditionalFormatType.CellValue);
            cf2.setFirstFormula( "500");
            cf2.setOperator( ComparisonOperatorType.Less);
            //set border color
            cf2.setLeftBorderColor(Color.BLUE);
            cf2.setRightBorderColor( Color.BLUE);
            cf2.setTopBorderColor( Color.GREEN);
            cf2.setBottomBorderColor( Color.GREEN);
            cf2.setLeftBorderStyle( LineStyleType.Medium);
            cf2.setRightBorderStyle( LineStyleType.Thick);
            cf2.setTopBorderStyle(LineStyleType.Double);
            cf2.setBottomBorderStyle(LineStyleType.Double);
        }

        private static void addComparisonRule3(Worksheet sheet)
        {
            //create conditional formatting rule
            XlsConditionalFormats xcfs1 = sheet.getConditionalFormats().add();
            xcfs1.addRange(sheet.getCellRange("A3:D3"));
            IConditionalFormat cf1 = xcfs1.addCondition();
            cf1.setFormatType( ConditionalFormatType.CellValue);
            cf1.setFirstFormula("300");
            cf1.setSecondFormula( "500");
            cf1.setOperator(ComparisonOperatorType.Between);
            cf1.setBackColor( Color.YELLOW);
        }

        private static void addComparisonRule4(Worksheet sheet)
        {
            //create conditional formatting rule
            XlsConditionalFormats xcfs1 = sheet.getConditionalFormats().add();
            xcfs1.addRange(sheet.getCellRange("A4:D4"));
            IConditionalFormat cf1 = xcfs1.addCondition();
            cf1.setFormatType( ConditionalFormatType.CellValue);
            cf1.setFirstFormula( "100");
            cf1.setSecondFormula( "200");
            cf1.setOperator(ComparisonOperatorType.NotBetween);
            //set fill pattern type
            cf1.setFillPattern( ExcelPatternType.ReverseDiagonalStripe);
            //set foreground color
            cf1.setColor( Color.LIGHT_GRAY);

            //set background color
            cf1.setBackColor( Color.BLACK);
        }
}
