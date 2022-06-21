import com.spire.xls.*;

public class setPrintAreaOfXlsFile {
    public static void main(String[] args) {
        String inputFile="data/template_Xls_4.xlsx";
        String outputFile="output/setPrintAreaOfXlsFile_result.xlsx";

        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile(inputFile);

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Get the reference of the PageSetup of the worksheet.
        PageSetup pageSetup = sheet.getPageSetup();

        //Specify the cells range of the print area.
        pageSetup.setPrintArea("A1:E5");

        //Save to file.
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
