import com.spire.xls.*;

public class changeFontAndSize {
    public static void main(String[] args) {
        String inputFile = "data/changeFontAndSizeForHeaderAndFooter.xlsx";
        String outputFile = "output/changeFontAndSizeForHeaderAndFooter_result.xlsx";

        // Create a new workbook object
        Workbook workbook = new Workbook();

        // Load an existing workbook from a file
        workbook.loadFromFile(inputFile);

        // Get the first worksheet in the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);


        String text = sheet.getPageSetup().getLeftHeader();

        //"Arial Unicode MS" is font name, "18" is font size
        text = "&\"Arial Unicode MS\"&18 Header Footer Sample by Spire.XLS ";

        // Update the left header text with a custom string and font size
        sheet.getPageSetup().setLeftHeader(text);

        // Update the right footer text with a custom string and font size
        sheet.getPageSetup().setRightFooter(text);

        // Save the modified workbook to a file
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);

        // Release the resources used by the workbook
        workbook.dispose();
    }
}
