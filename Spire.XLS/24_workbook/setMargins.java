import com.spire.xls.*;

public class setMargins {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/worksheetSample1.xlsx");

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Set margins for top, bottom, left and right, here the unit of measure is Inch
        sheet.getPageSetup().setTopMargin(0.3);
        sheet.getPageSetup().setBottomMargin(1);
        sheet.getPageSetup().setLeftMargin(0.2);
        sheet.getPageSetup().setRightMargin(1);
        //Set the header margin and footer margin
        sheet.getPageSetup().setHeaderMarginInch(0.1);
        sheet.getPageSetup().setFooterMarginInch(0.5);

        //Save the document
        String output = "output/setMargins_result.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
