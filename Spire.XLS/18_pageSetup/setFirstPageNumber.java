import com.spire.xls.*;

public class setFirstPageNumber {
    public static void main(String[] args) {
        String inputFile="data/template_Xls_4.xlsx";
        String outputFile="output/setFirstPageNumber_result.xlsx";

        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile(inputFile);

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Set the first page number of the worksheet pages.
        sheet.getPageSetup().setFirstPageNumber(2);

        //Save to file.
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
