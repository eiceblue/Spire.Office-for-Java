import com.spire.xls.*;

public class setFirstPageNumber {
    public static void main(String[] args) {
        String inputFile="data/template_Xls_4.xlsx";
        String outputFile="output/setFirstPageNumber_result.xlsx";

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load an Excel file from the specified input file path
        workbook.loadFromFile(inputFile);

        // Get the first worksheet in the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Set the first page number of the worksheet's page setup to 2
        sheet.getPageSetup().setFirstPageNumber(2);

        // Save the modified workbook to the specified output file path in Excel 2013 format
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);

        // Release any resources used by the workbook
        workbook.dispose();
    }
}
