import com.spire.xls.*;

public class differentHeaderFooterOnFirstPage {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);
        sheet.getCellRange("A1").setText("Hello World");
        sheet.getCellRange("F30").setText("Hello World");
        sheet.getCellRange("G150").setText("Hello World");

        //Set the value to show the headers/footers for first page are different from the other pages.
        sheet.getPageSetup().setDifferentFirst((byte)1);

        //Set the header and footer for the first page.
        sheet.getPageSetup().setFirstHeaderString("Different First page");
        sheet.getPageSetup().setFirstFooterString("Different First footer");

        //Set the other pages' header and footer.
        sheet.getPageSetup().setLeftHeader("Demo of Spire.XLS");
        sheet.getPageSetup().setCenterFooter("Footer by Spire.XLS");

        String result = "output/addDifferentHeaderFooterForTheFirstPage_result.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
