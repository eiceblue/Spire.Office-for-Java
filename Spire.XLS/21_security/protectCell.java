import java.util.*;

import com.spire.xls.*;

public class protectCell {
    public static void main(String[] args) {
        //Create a workbook and load a file
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/protectCell.xlsx");

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Protect cell
        sheet.getRange().get("B3").getStyle().setLocked(true);
        sheet.getRange().get("C3").getStyle().setLocked(false);

        sheet.protect("TestPassword", EnumSet.of(SheetProtectionType.All));

        //Save the document and launch it
        String result = "output/protectCell_result.xlsx";
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
