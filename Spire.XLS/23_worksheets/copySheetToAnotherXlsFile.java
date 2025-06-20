import com.spire.xls.*;

public class copySheetToAnotherXlsFile {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Loop through rows 1 to 5 and set the text in column A using a formatted string
        for (int i = 1; i < 6; i++) {
            sheet.getRange().get("A" + i).setText(String.format("Header Row %d", i));
        }

        // Loop through rows 5 to 99 and set the text in column A using a formatted string
        for (int i = 5; i < 100; i++) {
            sheet.getRange().get("A" + i).setText(String.format("Detail Row %d", i));
        }

        // Get the PageSetup object for the worksheet
        PageSetup pageSetup = sheet.getPageSetup();

        // Set the print title rows to be "$1:$5"
        pageSetup.setPrintTitleRows("$1:$5");

        // Create a new Workbook object
        Workbook workbook1 = new Workbook();

        // Get the first worksheet from the second workbook
        Worksheet sheet1 = workbook1.getWorksheets().get(0);

        // Copy the contents of the original worksheet to the new worksheet
        sheet1.copyFrom(sheet);

        // Specify the output file path for saving the modified workbooks
        String result = "output/copySheetToAnotherXlsFile_result.xlsx";
        String result1 = "output/copySheetToAnotherXlsFile_result.xlsx";

        // Save the first workbook to the specified output file path in Excel 2013 format
        workbook.saveToFile(result, ExcelVersion.Version2013);

        // Save the second workbook to the specified output file path in Excel 2013 format
        workbook1.saveToFile(result1, ExcelVersion.Version2013);

        // Dispose of the workbook resources to free up memory
        workbook.dispose();
        workbook1.dispose();
    }
}
