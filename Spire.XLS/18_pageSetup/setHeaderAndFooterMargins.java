import com.spire.xls.*;

public class setHeaderAndFooterMargins {
    public static void main(String[] args) {
        String inputFile="data/template_Xls_4.xlsx";
        String outputFile="output/setHeaderAndFooterMargins_result.xlsx";

        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile(inputFile);

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Get the PageSetup object of the first worksheet.
        PageSetup pageSetup = sheet.getPageSetup();

        //Set the margins of header and footer.
        pageSetup.setHeaderMarginInch(2);
        pageSetup.setFooterMarginInch(2);

        //Save to file.
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
