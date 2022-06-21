import com.spire.xls.*;

public class setXlsSheetCenterOnPage {
    public static void main(String[] args) {
        String inputFile="data/template_Xls_4.xlsx";
        String outputFile="output/setXlsSheetCenterOnPage_result.xlsx";

        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile(inputFile);

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Get the PageSetup object of the first page.
        PageSetup pageSetup = sheet.getPageSetup();

        //Set the worksheet center on page.
        pageSetup.setCenterHorizontally(true);
        pageSetup.setCenterVertically(true);

        //Save to file.
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
