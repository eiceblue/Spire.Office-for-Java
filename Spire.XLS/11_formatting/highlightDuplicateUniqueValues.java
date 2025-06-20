import com.spire.xls.*;
import com.spire.xls.core.*;
import com.spire.xls.core.spreadsheet.collections.*;
import java.awt.*;

public class highlightDuplicateUniqueValues {
    public static void main(String[] args) throws Exception {
        String input = "data/Template_Xls_6.xlsx";
        String output = "output/highlightDuplicateUniqueValues.xlsx";

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the workbook from the input file
        workbook.loadFromFile(input);

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Add conditional formats to apply formatting based on conditions

        // Create a new XlsConditionalFormats object
        XlsConditionalFormats xcfs = sheet.getConditionalFormats().add();
        // Add the cell range "C2:C10" to the conditional format
        xcfs.addRange(sheet.getCellRange("C2:C10"));
        // Create a conditional format for duplicate values
        IConditionalFormat format1 = xcfs.addCondition();
        // Set the format type to DuplicateValues
        format1.setFormatType(ConditionalFormatType.DuplicateValues);
        // Set the background color to red for cells with duplicate values
        format1.setBackColor(Color.RED);

        // Create another XlsConditionalFormats object
        XlsConditionalFormats xcfs1 = sheet.getConditionalFormats().add();
        // Add the same cell range "C2:C10" to the second conditional format
        xcfs1.addRange(sheet.getCellRange("C2:C10"));
        // Create a conditional format for unique values
        IConditionalFormat format2 = xcfs.addCondition();
        // Set the format type to UniqueValues
        format2.setFormatType(ConditionalFormatType.UniqueValues);
        // Set the background color to yellow for cells with unique values
        format2.setBackColor(Color.YELLOW);

        // Save the modified workbook to the output file in Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        //Release the resources used by the workbook
        workbook.dispose();
    }
}
