import com.spire.xls.*;

public class setOtherPrintingOptions {
    public static void main(String[] args) {
        String inputFile="data/template_Xls_4.xlsx";
        String outputFile="output/setOtherPrintingOptions_result.xlsx";

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load an Excel file from the specified input file path
        workbook.loadFromFile(inputFile);

        // Get the first worksheet in the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Get the PageSetup object from the worksheet
        PageSetup pageSetup = sheet.getPageSetup();

        // Set the option to print gridlines on the page setup
        pageSetup.isPrintGridlines(true);

        // Set the option to print headings on the page setup
        pageSetup.isPrintHeadings(true);

        // Set the page setup to black and white
        pageSetup.setBlackAndWhite(true);

        // Set the type of comments to print on the page setup
        pageSetup.setPrintComments(PrintCommentType.InPlace);

        // Set the type of errors to print on the page setup
        pageSetup.setPrintErrors(PrintErrorsType.NA);

        // Set the page setup to draft mode
        pageSetup.setDraft(true);

        // Save the modified workbook to the specified output file path in Excel 2013 format
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);

        // Release any resources used by the workbook
        workbook.dispose();
    }
}
