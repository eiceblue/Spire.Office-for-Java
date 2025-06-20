import com.spire.xls.*;

public class setHeaderAndFooterMargins {
    public static void main(String[] args) {
        String inputFile="data/template_Xls_4.xlsx";
        String outputFile="output/setHeaderAndFooterMargins_result.xlsx";

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the workbook from the input file
        workbook.loadFromFile(inputFile);

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Get the PageSetup object for the worksheet
        PageSetup pageSetup = sheet.getPageSetup();

        // Set the header margin to 2 inches
        pageSetup.setHeaderMarginInch(2);

        // Set the footer margin to 2 inches
        pageSetup.setFooterMarginInch(2);

        // Save the modified workbook to the output file in Excel 2013 format
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);

        // Dispose of the workbook object to release resources
        workbook.dispose();
    }
}
