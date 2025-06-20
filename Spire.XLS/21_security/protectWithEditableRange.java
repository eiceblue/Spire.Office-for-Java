import com.spire.xls.*;

import java.util.*;

public class protectWithEditableRange {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the workbook from the specified file "data/protectWithEditableRange.xlsx"
        workbook.loadFromFile("data/protectWithEditableRange.xlsx");

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Add an editable range named "EditableRanges" for cells B4 to E12
        sheet.addAllowEditRange("EditableRanges", sheet.getCellRange("B4:E12"));

        // Protect the worksheet with password "TestPassword" and allow all types of protection
        sheet.protect("TestPassword", EnumSet.of(SheetProtectionType.All));

        // Specify the output file path for the modified workbook
        String output = "output/protectWithEditableRange_result.xlsx";

        // Save the modified workbook to the specified output file in Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Dispose of the workbook object to release resources
        workbook.dispose();
    }
}
