import com.spire.xls.*;

public class differentHeaderFooterOnFirstPage {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Set the text in cell A1 to "Hello World"
        sheet.getCellRange("A1").setText("Hello World");
        // Set the text in cell F30 to "Hello World"
        sheet.getCellRange("F30").setText("Hello World");
        // Set the text in cell G150 to "Hello World"
        sheet.getCellRange("G150").setText("Hello World");

        // Enable different header and footer for the first page only
        sheet.getPageSetup().setDifferentFirst((byte)1);

        // Set the header text for the first page
        sheet.getPageSetup().setFirstHeaderString("Different First page");

        // Set the footer text for the first page
        sheet.getPageSetup().setFirstFooterString("Different First footer");

        // Set the left header text for all pages
        sheet.getPageSetup().setLeftHeader("Demo of Spire.XLS");
        // Set the center footer text for all pages
        sheet.getPageSetup().setCenterFooter("Footer by Spire.XLS");

        String result = "output/addDifferentHeaderFooterForTheFirstPage_result.xlsx";

        // Save the workbook to a file with the specified name, in Excel 2013 format
        workbook.saveToFile(result, ExcelVersion.Version2013);

        // Release the resources used by the workbook
        workbook.dispose();
    }
}
