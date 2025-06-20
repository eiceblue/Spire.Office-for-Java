import com.spire.xls.*;

public class setPrintQualityOfXlsFile {
    public static void main(String[] args) {
        String inputFile="data/template_Xls_4.xlsx";
        String outputFile="output/setPrintQualityOfXlsFile_result.xlsx";

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the workbook from an input file
        workbook.loadFromFile(inputFile);

        // Retrieve the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Set the print quality of the worksheet to 180
        sheet.getPageSetup().setPrintQuality(180);

        // Save the workbook to an output file in Excel 2013 format
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);

        // Dispose of the workbook object to free up resources
        workbook.dispose();
    }
}
