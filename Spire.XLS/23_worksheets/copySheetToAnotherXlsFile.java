import com.spire.xls.*;

public class copySheetToAnotherXlsFile {
    public static void main(String[] args) {
        Workbook workbook = new Workbook();

        // Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Put some data into header rows (A1:A4)
        for (int i = 1; i < 6; i++) {
            sheet.getRange().get("A" + i).setText(String.format("Header Row %d", i));
            // sheet.Cells[i].Value = string.Format("Header Row {0}",i);
        }

        // Put some detail data (A5:A99)
        for (int i = 5; i < 100; i++) {
            sheet.getRange().get("A" + i).setText(String.format("Detail Row %d", i));
            //sheet.getCells()[i].setValue(String.format("Detail Row {0}",i));
        }

        // Define a pagesetup object based on the first worksheet
        PageSetup pageSetup = sheet.getPageSetup();

        // The first five rows are repeated in each page. It can be seen in print
        // preview
        pageSetup.setPrintTitleRows("$1:$5");

        // Create another Workbook
        Workbook workbook1 = new Workbook();

        // Get the first worksheet in the book
        Worksheet sheet1 = workbook1.getWorksheets().get(0);

        // Copy worksheet to destination worsheet in another Excel file
        sheet1.copyFrom(sheet);

        String result = "output/sourceFile.xlsx";
        String result1 = "output/copySheetToAnotherXlsFile_result.xlsx";

        // Save the source file we created
        workbook.saveToFile(result, ExcelVersion.Version2013);

        // Save the destination file
        workbook1.saveToFile(result1, ExcelVersion.Version2013);
    }
}
