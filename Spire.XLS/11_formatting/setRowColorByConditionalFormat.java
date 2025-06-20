import com.spire.xls.*;
import com.spire.xls.core.IConditionalFormat;
import com.spire.xls.core.spreadsheet.collections.XlsConditionalFormats;

import java.awt.*;

public class setRowColorByConditionalFormat {
    public static void main(String[] args) {
        String inputFile = "data/template_Xls_4.xlsx";
        String outputFile = "output/setRowColorByConditionalFormat_result.xlsx";

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the workbook from the input file
        workbook.loadFromFile(inputFile);

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Get the range of cells with data in the worksheet
        CellRange dataRange = sheet.getAllocatedRange();

        // Add conditional formats to apply formatting based on conditions

        // Create a new XlsConditionalFormats object
        XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        // Add the data range to the conditional format
        xcfs.addRange(dataRange);
        // Create a conditional format for even rows
        IConditionalFormat format1 = xcfs.addCondition();
        // Set the first formula to check if the row number is even using MOD function
        format1.setFirstFormula("=MOD(ROW(),2)=0");
        // Set the format type to Formula
        format1.setFormatType(ConditionalFormatType.Formula);
        // Set the background color to light gray for even rows
        format1.setBackColor(Color.lightGray);

        // Create another XlsConditionalFormats object
        XlsConditionalFormats xcfs1 = sheet.getConditionalFormats().add();
        // Add the same data range to the second conditional format
        xcfs1.addRange(dataRange);
        // Create a conditional format for odd rows
        IConditionalFormat format2 = xcfs.addCondition();
        // Set the first formula to check if the row number is odd using MOD function
        format2.setFirstFormula("=MOD(ROW(),2)=1");
        // Set the format type to Formula
        format2.setFormatType(ConditionalFormatType.Formula);
        // Set the background color to yellow for odd rows
        format2.setBackColor(Color.yellow);

        // Save the modified workbook to the output file in Excel 2013 format
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);

        //Release the resources used by the workbook
        workbook.dispose();
    }
}
