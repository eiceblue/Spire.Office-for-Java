import com.spire.xls.*;

public class setPrintTitleOfXlsFile {
    public static void main(String[] args) {
        String inputFile="data/template_Xls_4.xlsx";
        String outputFile="output/setPrintTitleOfXlsFile_result.xlsx";

        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile(inputFile);

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        PageSetup pageSetup = sheet.getPageSetup();

        //Define column numbers A & B as title columns.
        pageSetup.setPrintTitleColumns("$A:$B");

        //Defining row numbers 1 & 2 as title rows.
        pageSetup.setPrintTitleRows("$1:$2");

        //Save to file.
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);

    }
}
