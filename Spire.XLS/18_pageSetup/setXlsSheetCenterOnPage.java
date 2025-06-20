import com.spire.xls.*;

public class setXlsSheetCenterOnPage {
    public static void main(String[] args) {
        String inputFile="data/template_Xls_4.xlsx";
        String outputFile="output/setXlsSheetCenterOnPage_result.xlsx";

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the workbook from the specified inputFile
        workbook.loadFromFile(inputFile);

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Get the PageSetup object for the worksheet
        PageSetup pageSetup = sheet.getPageSetup();

        // Set the center horizontally option to true
        pageSetup.setCenterHorizontally(true);

        // Set the center vertically option to true
        pageSetup.setCenterVertically(true);

        // Save the workbook to the specified outputFile in Excel 2013 format
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);

        // Clean up resources by disposing of the workbook object
        workbook.dispose();
    }
}
