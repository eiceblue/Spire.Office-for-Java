import com.spire.xls.*;

public class differentHeaderFooter {
    public static void main(String[] args) {
        String inputFile = "data/headerFooterSample.xlsx";
        String outputFile = "output/differentHeaderFooter_result.xlsx";

        //Create a Workbook
        Workbook wb = new Workbook();

        //Load an Excel from disk
        wb.loadFromFile(inputFile);

        //Get the first worksheet
        Worksheet sheet = wb.getWorksheets().get(0);

        //Set text in range
        sheet.getCellRange("A1").setText("Page 1");
        sheet.getCellRange("G1").setText("Page 2");

        //Set the different header footer for Odd and Even pages
        sheet.getPageSetup().setDifferentOddEven((byte)1);

        //Set the header with font, size, bold and color
        sheet.getPageSetup().setOddHeaderString( "&\"Arial\"&12&B&KFFC000 Odd_Header");
        sheet.getPageSetup().setOddFooterString ( "&\"Arial\"&12&B&KFFC000 Odd_Footer");
        sheet.getPageSetup().setEvenHeaderString ( "&\"Arial\"&12&B&KFF0000 Even_Header");
        sheet.getPageSetup().setEvenFooterString ( "&\"Arial\"&12&B&KFF0000 Even_Footer");

        //Set the view mode as layout
        sheet.setViewMode(ViewMode.Layout);

        //Save the Excel file
        wb.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
