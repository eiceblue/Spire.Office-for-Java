import com.spire.xls.*;

public class setPrintQualityOfXlsFile {
    public static void main(String[] args) {
        String inputFile="data/template_Xls_4.xlsx";
        String outputFile="output/setPrintQualityOfXlsFile_result.xlsx";

        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile(inputFile);

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Set the print quality of the worksheet to 180 dpi.
        sheet.getPageSetup().setPrintQuality(180);

        //Save to file.
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
