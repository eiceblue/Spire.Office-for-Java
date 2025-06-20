import com.spire.xls.*;

public class addPageBreakInXlsFile {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load an existing Excel file
        workbook.loadFromFile("data/template_Xls_4.xlsx");

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Add a horizontal page break at cell E4 in the worksheet
        sheet.getHPageBreaks().add(sheet.getRange().get("E4"));

        // Add a vertical page break at cell C4 in the worksheet
        sheet.getVPageBreaks().add(sheet.getRange().get("C4"));

        // Specify the output file path and name for the modified Excel file
        String result = "output/addPageBreakInXlsFile_result.xlsx";

        // Save the workbook to the specified file in Excel 2013 format
        workbook.saveToFile(result, ExcelVersion.Version2013);

        // Dispose of the workbook object to free up resources
        workbook.dispose();
    }
}
