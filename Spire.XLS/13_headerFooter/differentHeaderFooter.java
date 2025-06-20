import com.spire.xls.*;

public class differentHeaderFooter {
    public static void main(String[] args) {
        String inputFile = "data/headerFooterSample.xlsx";
        String outputFile = "output/differentHeaderFooter_result.xlsx";

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load a workbook from a specified file path
        workbook.loadFromFile(inputFile);

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Set the text in cell A1 to "Page 1"
        sheet.getCellRange("A1").setText("Page 1");
        // Set the text in cell G1 to "Page 2"
        sheet.getCellRange("G1").setText("Page 2");

        // Enable different odd and even page headers and footers
        sheet.getPageSetup().setDifferentOddEven((byte)1);

        // Set the odd page header text format
        sheet.getPageSetup().setOddHeaderString( "&\"Arial\"&12&B&KFFC000 Odd_Header");
        // Set the odd page footer text format
        sheet.getPageSetup().setOddFooterString ( "&\"Arial\"&12&B&KFFC000 Odd_Footer");
        // Set the even page header text format
        sheet.getPageSetup().setEvenHeaderString ( "&\"Arial\"&12&B&KFF0000 Even_Header");
        // Set the even page footer text format
        sheet.getPageSetup().setEvenFooterString ( "&\"Arial\"&12&B&KFF0000 Even_Footer");

        // Change the view mode of the worksheet to Layout view
        sheet.setViewMode(ViewMode.Layout);

        // Save the workbook to a file in Excel 2013 format
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);

        //Release the resources used by the workbook
        workbook.dispose();
    }
}
