import com.spire.xls.*;

public class setMarginsOfExcelSheet {
    public static void main(String[] args) {
        String inputFile="data/template_Xls_4.xlsx";
        String outputFile="output/setMarginsOfExcelSheet_result.xlsx";

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the workbook from the input file
        workbook.loadFromFile(inputFile);

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Get the PageSetup object for the worksheet
        PageSetup pageSetup = sheet.getPageSetup();

        // Set the bottom margin to 2 units
        pageSetup.setBottomMargin(2);

        // Set the left margin to 1 unit
        pageSetup.setLeftMargin(1);

        // Set the right margin to 1 unit
        pageSetup.setRightMargin(1);

        // Set the top margin to 3 units
        pageSetup.setTopMargin(3);

        // Save the modified workbook to the output file in Excel 2013 format
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);

        // Dispose of the workbook object to release resources
        workbook.dispose();
    }
}
