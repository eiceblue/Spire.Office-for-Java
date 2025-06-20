import com.spire.xls.*;

public class setMargins {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load data from the "worksheetSample1.xlsx" file into the workbook
        workbook.loadFromFile("data/worksheetSample1.xlsx");

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Set the top, bottom, left, and right margins of the page setup for the worksheet
        sheet.getPageSetup().setTopMargin(0.3);
        sheet.getPageSetup().setBottomMargin(1);
        sheet.getPageSetup().setLeftMargin(0.2);
        sheet.getPageSetup().setRightMargin(1);

        // Set the header and footer margins in inches for the page setup of the worksheet
        sheet.getPageSetup().setHeaderMarginInch(0.1);
        sheet.getPageSetup().setFooterMarginInch(0.5);

        // Specify the output file path for saving the result
        String output = "output/setMargins_result.xlsx";

        // Save the workbook to the specified output file path in Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Dispose of the workbook object to release resources
        workbook.dispose();
    }
}
