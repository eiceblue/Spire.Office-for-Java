import java.util.*;
import com.spire.xls.*;

public class mergeExcelFiles {
    public static void main(String[] args) {
        // Create a list of stored file paths
        List<String> files = new ArrayList<String>();

        // Add the file path to the list
        files.add("data/mergeExcelFiles-1.xlsx");
        files.add("data/mergeExcelFiles-2.xls");
        files.add("data/mergeExcelFiles-3.xlsx");

        // Create a new Excel workbook
        Workbook newbook = new Workbook();

        // Set the version of the new workbook to Excel 2013
        newbook.setVersion(ExcelVersion.Version2013);

        // Empty the worksheets in the new workbook
        newbook.getWorksheets().clear();

        // Create a temporary Excel workbook
        Workbook tempbook = new Workbook();

        // Go through the file list
        for (String file : files) {

            // Load files from the temporary workbook
            tempbook.loadFromFile(file);

            // Traverse the worksheets in the temporary workbook and copy them to the new workbook
            for (Object workSheet : tempbook.getWorksheets()) {
                Worksheet sheet = (Worksheet) workSheet;
                newbook.getWorksheets().addCopy(sheet, WorksheetCopyType.CopyAll);
            }
        }

        // Set the path of the output file
        String output = "output/mergeExcelFiles_result.xlsx";

        // Save the new workbook to a file, version Excel 2013
        newbook.saveToFile(output, ExcelVersion.Version2013);

        // Free the memory of the temporary workbook
        tempbook.dispose();

        // Free the memory of the new workbook
        newbook.dispose();
    }
}
