import java.util.*;
import com.spire.xls.*;

public class lockSpecificCellInNewExcel {
    public static void main(String[] args) {
        // Create a new workbook
        Workbook workbook = new Workbook();
        // Create an empty sheet in the workbook
        workbook.createEmptySheet();
        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Iterate through rows 0 to 254
        for (int i = 0; i < 255; i++) {
            // Disable locking for each row's style
            sheet.getRows()[i].getStyle().setLocked(false);
        }

        // Set the text of column 3 (fourth column) to "Locked"
        sheet.getColumns()[3].setText("Locked");
        // Lock the style of column 3 to prevent modifications
        sheet.getColumns()[3].getStyle().setLocked(true);

        // Protect the worksheet with password "123" and apply all protection options
        sheet.protect("123", EnumSet.of(SheetProtectionType.All));

        // Specify the file path and name for the output saved file
        String result = "output/lockSpecificColumnInNewlyXlsFile_result.xlsx";
        // Save the workbook to the specified file in Excel 2013 format
        workbook.saveToFile(result, ExcelVersion.Version2013);

        // Dispose of the workbook to release resources
        workbook.dispose();
    }
}
