import com.spire.xls.*;

public class changeFontAndSize {
    public static void main(String[] args) {
        String inputFile = "data/changeFontAndSizeForHeaderAndFooter.xlsx";
        String outputFile = "output/changeFontAndSizeForHeaderAndFooter_result.xlsx";

        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile(inputFile);

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Set the new font and size for the header and footer
        String text = sheet.getPageSetup().getLeftHeader();

        //"Arial Unicode MS" is font name, "18" is font size
        text = "&\"Arial Unicode MS\"&18 Header Footer Sample by Spire.XLS ";
        sheet.getPageSetup().setLeftHeader(text);
        sheet.getPageSetup().setRightFooter(text);

        //Save to file.
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
