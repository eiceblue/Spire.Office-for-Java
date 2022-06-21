import com.spire.xls.*;

public class addPageBreakInXlsFile {
    public static void main(String[] args) {
        // Create a workbook.
        Workbook workbook = new Workbook();

        // Load the file from disk.
        workbook.loadFromFile("data/template_Xls_4.xlsx");

        // Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Add page break in Excel file.
        sheet.getHPageBreaks().add(sheet.getRange().get("E4"));
        sheet.getVPageBreaks().add(sheet.getRange().get("C4"));

        String result = "output/addPageBreakInXlsFile_result.xlsx";

        // Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
