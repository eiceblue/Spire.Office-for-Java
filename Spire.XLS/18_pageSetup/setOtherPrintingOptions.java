import com.spire.xls.*;

public class setOtherPrintingOptions {
    public static void main(String[] args) {
        String inputFile="data/template_Xls_4.xlsx";
        String outputFile="output/setOtherPrintingOptions_result.xlsx";

        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile(inputFile);

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Get the reference of the PageSetup of the worksheet.
        PageSetup pageSetup = sheet.getPageSetup();

        //Allow to print gridlines.
        pageSetup.isPrintGridlines(true);

        //Allow to print row/column headings.
        pageSetup.isPrintHeadings(true);

        //Allow to print worksheet in black & white mode.
        pageSetup.setBlackAndWhite(true);

        //Allow to print comments as displayed on worksheet.
        pageSetup.setPrintComments(PrintCommentType.InPlace);

        //Allow to print cell errors as N/A.
        pageSetup.setPrintErrors(PrintErrorsType.NA);

        //Allow to print worksheet with draft quality.
        pageSetup.setDraft(true);

        //Save to file.
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
