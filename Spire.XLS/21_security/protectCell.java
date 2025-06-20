import java.util.*;
import com.spire.xls.*;

public class protectCell {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the workbook from the specified file "data/protectCell.xlsx"
        workbook.loadFromFile("data/protectCell.xlsx");

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Set cell B3 as locked
        sheet.getRange().get("B3").getStyle().setLocked(true);

        // Set cell C3 as unlocked
        sheet.getRange().get("C3").getStyle().setLocked(false);

        // Protect the worksheet with password "TestPassword" and allow all types of protection
        sheet.protect("TestPassword", EnumSet.of(SheetProtectionType.All));

        // Specify the output file path for the modified workbook
        String result = "output/protectCell_result.xlsx";

        // Save the modified workbook to the specified output file in Excel 2013 format
        workbook.saveToFile(result, ExcelVersion.Version2013);

        // Dispose of the workbook object to release resources
        workbook.dispose();
    }
}
