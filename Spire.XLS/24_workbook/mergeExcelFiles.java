import java.util.*;

import com.spire.xls.*;

public class mergeExcelFiles {
    public static void main(String[] args) {
        List<String> files = new ArrayList<String>();
        files.add("data/mergeExcelFiles-1.xlsx");
        files.add("data/mergeExcelFiles-2.xls");
        files.add("data/mergeExcelFiles-3.xlsx");

        Workbook newbook = new Workbook();
        newbook.setVersion(ExcelVersion.Version2013);
        // Clear all worksheets
        newbook.getWorksheets().clear();

        // Create a workbook
        Workbook tempbook = new Workbook();

        for (String file : files) {
            // Load the file
            tempbook.loadFromFile(file);
            for (Object workSheet : tempbook.getWorksheets()) {
                Worksheet sheet = (Worksheet) workSheet;
                // Copy every sheet in a workbook
                newbook.getWorksheets().addCopy(sheet, WorksheetCopyType.CopyAll);
            }
        }

        // Save the file
        String output = "output/mergeExcelFiles_result.xlsx";
        newbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
