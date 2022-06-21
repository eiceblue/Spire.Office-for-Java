import com.spire.xls.*;

import java.util.*;

public class protectWithEditableRange {
    public static void main(String[] args) {
        // Create a workbook and load a file
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/protectWithEditableRange.xlsx");

        // Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Define the specified ranges to allow users to edit while sheet is protected
        sheet.addAllowEditRange("EditableRanges", sheet.getCellRange("B4:E12"));

        // Protect worksheet with a password.
        sheet.protect("TestPassword", EnumSet.of(SheetProtectionType.All));

        // Save the Excel file
        String output = "output/protectWithEditableRange_result.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
