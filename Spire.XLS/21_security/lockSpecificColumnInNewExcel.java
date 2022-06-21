import java.util.*;

import com.spire.xls.*;

public class lockSpecificColumnInNewExcel {
    public static void main(String[] args) {
        // Create a workbook
        Workbook workbook = new Workbook();

        // Create an empty worksheet
        workbook.createEmptySheet();

        // Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Loop through all the columns in the worksheet and unlock them
        for (int i = 0; i < 255; i++) {
            sheet.getRows()[i].getStyle().setLocked(false);
        }

        // Lock the fourth column in the worksheet
        sheet.getColumns()[3].setText("Locked");
        sheet.getColumns()[3].getStyle().setLocked(true);

        // Set the password
        sheet.protect("123", EnumSet.of(SheetProtectionType.All));

        String result = "output/lockSpecificColumnInNewlyXlsFile_result.xlsx";

        // Save to file
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
