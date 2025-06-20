import com.spire.xls.*;
import com.spire.xls.core.IConditionalFormat;
import com.spire.xls.core.spreadsheet.collections.XlsConditionalFormats;

import java.awt.*;

public class setConditionalFormatFormula {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Add conditional formats to apply formatting based on conditions

        // Create a new XlsConditionalFormats object
        XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        // Add the cell range "B5" to the conditional format
        xcfs.addRange(sheet.getCellRange("B5"));
        // Create a conditional format based on cell value
        IConditionalFormat format = xcfs.addCondition();
        // Set the format type to CellValue
        format.setFormatType(ConditionalFormatType.CellValue);
        // Set the first formula to "1000"
        format.setFirstFormula("1000");
        // Set the comparison operator to Greater
        format.setOperator(ComparisonOperatorType.Greater);
        // Set the background color to orange for cells meeting the condition
        format.setBackColor(Color.orange);

        // Set values and formulas in specific cells of the worksheet
        sheet.getCellRange("B1").setNumberValue(40);
        sheet.getCellRange("B2").setNumberValue(500);
        sheet.getCellRange("B3").setNumberValue(300);
        sheet.getCellRange("B4").setNumberValue(400);
        sheet.getCellRange("B5").setFormula("=SUM(B1:B4)");

        // Add text to describe the conditional format
        sheet.getCellRange("C5").setText("If Sum of B1:B4 is greater than 1000, B5 will have orange background.");

        // Save the modified workbook to the output file in Excel 2013 format
        String outputFile = "output/setConditionalFormatFormula_result.xlsx";
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);

        //Release the resources used by the workbook
        workbook.dispose();
    }
}
