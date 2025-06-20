import com.spire.xls.*;
import com.spire.xls.core.IConditionalFormat;
import com.spire.xls.core.spreadsheet.collections.XlsConditionalFormats;

import java.awt.*;

public class simpleConditionalFormatting {
    public static void main(String[] args) {
        String inputFile="data/conditionalFormatting.xlsx";
        String outputFile = "output/simpleConditionalFormatting_result.xlsx";

        // Create a new workbook object
        Workbook workbook = new Workbook();
        // Load the workbook from a file
        workbook.loadFromFile(inputFile);

        // Get the first worksheet in the workbook
        Worksheet oldsheet = workbook.getWorksheets().get(0);

        // Add conditional formatting rules to the existing sheet
        addConditionalFormattingForExistingSheet(oldsheet);

        // Save the modified workbook to a new file
        workbook.saveToFile(outputFile, ExcelVersion.Version2010);

        // Release the resources used by the workbook
        workbook.dispose();
    }
    private static void addConditionalFormattingForExistingSheet(Worksheet sheet)
    {
        // Set row height and column width for the entire allocated range
        sheet.getAllocatedRange().setRowHeight(15);
        sheet.getAllocatedRange().setColumnWidth(16);

        // Add conditional formatting for range A1:D1
        XlsConditionalFormats xcfs1 = sheet.getConditionalFormats().add();
        xcfs1.addRange(sheet.getCellRange("A1:D1"));
        IConditionalFormat cf1 = xcfs1.addCondition();
        cf1.setFormatType(ConditionalFormatType.CellValue);
        cf1.setFirstFormula("150");
        cf1.setOperator(ComparisonOperatorType.Greater);
        cf1.setFontColor(Color.red);
        cf1.setBackColor(Color.pink);

        // Add conditional formatting for range A2:D2
        XlsConditionalFormats xcfs2 = sheet.getConditionalFormats().add();
        xcfs2.addRange(sheet.getCellRange("A2:D2"));
        IConditionalFormat cf2 = xcfs2.addCondition();
        cf2.setFormatType(ConditionalFormatType.CellValue);
        cf2.setFirstFormula("300");
        cf2.setOperator(ComparisonOperatorType.Less);
        cf2.setLeftBorderColor(Color.pink);
        cf2.setRightBorderColor(Color.pink);
        cf2.setTopBorderColor(Color.blue);
        cf2.setBottomBorderColor(Color.blue);
        cf2.setLeftBorderStyle(LineStyleType.Medium);
        cf2.setRightBorderStyle(LineStyleType.Thick);
        cf2.setTopBorderStyle(LineStyleType.Double);
        cf2.setBottomBorderStyle(LineStyleType.Double);

        // Add conditional formatting for range A3:D3
        XlsConditionalFormats xcfs3 = sheet.getConditionalFormats().add();
        xcfs3.addRange(sheet.getCellRange("A3:D3"));
        IConditionalFormat cf3 = xcfs3.addCondition();
        cf3.setFormatType(ConditionalFormatType.DataBar);
        cf3.getDataBar().setBarColor(Color.yellow);

        // Add conditional formatting for range A4:D4
        XlsConditionalFormats xcfs4 = sheet.getConditionalFormats().add();
        xcfs4.addRange(sheet.getCellRange("A4:D4"));
        IConditionalFormat cf4 = xcfs4.addCondition();
        cf4.setFormatType(ConditionalFormatType.IconSet);
        cf4.getIconSet().setIconSetType(IconSetType.ThreeTrafficLights1);

        // Add conditional formatting for range A5:D5
        XlsConditionalFormats xcfs5 = sheet.getConditionalFormats().add();
        xcfs5.addRange(sheet.getCellRange("A5:D5"));
        IConditionalFormat cf5 = xcfs5.addCondition();
        cf5.setFormatType(ConditionalFormatType.ColorScale);

        // Add conditional formatting for range A6:D6
        XlsConditionalFormats xcfs6 = sheet.getConditionalFormats().add();
        xcfs6.addRange(sheet.getCellRange("A6:D6"));
        IConditionalFormat cf6 = xcfs6.addCondition();
        cf6.setFormatType(ConditionalFormatType.DuplicateValues);
        cf6.setBackColor(Color.orange);
    }
}
