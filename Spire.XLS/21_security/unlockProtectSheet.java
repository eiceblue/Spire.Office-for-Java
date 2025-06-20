import com.spire.xls.*;

public class unlockProtectSheet {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load an existing Excel file named "UnprotectProtectSheet.xlsx" from the specified path
        workbook.loadFromFile("data/UnprotectProtectSheet.xlsx");

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Unprotect the worksheet with password "e-iceblue"
        sheet.unprotect("e-iceblue");

        // Specify the output file path as "output/UnprotectProtectSheet_out.xlsx"
        String result = "output/UnprotectProtectSheet_out.xlsx";

        // Save the modified workbook to a new file with Excel 2013 format
        workbook.saveToFile(result, ExcelVersion.Version2013);

        // Release resources associated with the workbook
        workbook.dispose();
    }

}
