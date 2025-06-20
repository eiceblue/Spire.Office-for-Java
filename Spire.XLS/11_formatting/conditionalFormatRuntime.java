import com.spire.xls.*;
import com.spire.xls.core.IConditionalFormat;
import com.spire.xls.core.spreadsheet.collections.XlsConditionalFormats;
import java.awt.*;

public class conditionalFormatRuntime {
    public static void main(String[] args) throws Exception {
            String input = "data/ConditionalFormatRuntime.xlsx";
            String output = "output/conditionalFormatRuntime_output.xlsx";

            //Create a new workbook
            Workbook workbook = new Workbook();

            //Load a workbook from a file
            workbook.loadFromFile(input);

            //Get the first worksheet in the workbook
            Worksheet sheet = workbook.getWorksheets().get(0);

            //Add comparison rule 1 to the worksheet
            addComparisonRule1(sheet);
            //Add comparison rule 2 to the worksheet
            addComparisonRule2(sheet);
            //Add comparison rule 3 to the worksheet
            addComparisonRule3(sheet);
            //Add comparison rule 4 to the worksheet
            addComparisonRule4(sheet);

            //Save the workbook to the specified file with Excel 2013 format
            workbook.saveToFile(output, ExcelVersion.Version2013);

            //Release the resources used by the workbook
            workbook.dispose();
        }
        private static void addComparisonRule1(Worksheet sheet)
        {
            //Add conditional formats to the worksheet for range A1:D1
            XlsConditionalFormats xcfs1 = sheet.getConditionalFormats().add();
            xcfs1.addRange(sheet.getCellRange("A1:D1"));
            //Add a condition for the conditional format
            IConditionalFormat cf1 = xcfs1.addCondition();
            cf1.setFormatType( ConditionalFormatType.CellValue);
            cf1.setFirstFormula("150");
            cf1.setOperator(ComparisonOperatorType.Greater);
            cf1.setFontColor(Color.RED);
            cf1.setBackColor( Color.BLUE);
        }
        private static void addComparisonRule2(Worksheet sheet)
        {
            //Add conditional formats to the worksheet for range A2:D2
            XlsConditionalFormats xcfs2 = sheet.getConditionalFormats().add();
            xcfs2.addRange(sheet.getCellRange("A2:D2"));
            //Add a condition for the conditional format
            IConditionalFormat cf2 = xcfs2.addCondition();
            cf2.setFormatType( ConditionalFormatType.CellValue);
            cf2.setFirstFormula( "500");
            cf2.setOperator( ComparisonOperatorType.Less);
            //Set border color
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
            //Add conditional formats to the worksheet for range A3:D3
            XlsConditionalFormats xcfs1 = sheet.getConditionalFormats().add();
            xcfs1.addRange(sheet.getCellRange("A3:D3"));
            //Add a condition for the conditional format
            IConditionalFormat cf1 = xcfs1.addCondition();
            cf1.setFormatType( ConditionalFormatType.CellValue);
            cf1.setFirstFormula("300");
            cf1.setSecondFormula( "500");
            cf1.setOperator(ComparisonOperatorType.Between);
            cf1.setBackColor( Color.YELLOW);
        }

        private static void addComparisonRule4(Worksheet sheet)
        {
            //Add conditional formats to the worksheet for range A4:D4
            XlsConditionalFormats xcfs1 = sheet.getConditionalFormats().add();
            xcfs1.addRange(sheet.getCellRange("A4:D4"));
            //Add a condition for the conditional format
            IConditionalFormat cf1 = xcfs1.addCondition();
            cf1.setFormatType( ConditionalFormatType.CellValue);
            cf1.setFirstFormula( "100");
            cf1.setSecondFormula( "200");
            cf1.setOperator(ComparisonOperatorType.NotBetween);
            cf1.setFillPattern( ExcelPatternType.ReverseDiagonalStripe);
            cf1.setColor( Color.LIGHT_GRAY);
            cf1.setBackColor( Color.BLACK);
        }
}
