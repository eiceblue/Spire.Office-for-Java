import java.util.*;

import com.spire.xls.*;

public class lockSpecificCellInNewExcel {
    public static void main(String[] args) {
        // Create a workbook
        Workbook workbook = new Workbook();

        // Create an empty worksheet
        workbook.createEmptySheet();

        // Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Loop through all the rows in the worksheet and unlock them
        for (int i = 0; i < 255; i++) {
            sheet.getRows()[i].getStyle().setLocked(false);
        }

        // Lock specific cell in the worksheet
        sheet.getRange().get("A1").setText("Locked");
        sheet.getRange().get("A1").getStyle().setLocked(true);

        // Lock specific cell range in the worksheet
        sheet.getRange().get("C1:E3").setText("Locked");
        sheet.getRange().get("C1:E3").getStyle().setLocked(true);

        // Set the password
        sheet.protect("123", EnumSet.of(SheetProtectionType.All));

        String result = "output/lockSpecificCellInNewlyXlsFile_result.xlsx";

        // Save to file
        workbook.saveToFile(result, ExcelVersion.Version2013);

    }
}
