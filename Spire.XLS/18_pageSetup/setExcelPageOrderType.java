import com.spire.xls.*;

public class setExcelPageOrderType {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile("data/Template_Xls_4.xlsx");

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Get the reference of the PageSetup of the worksheet.
        PageSetup pageSetup = sheet.getPageSetup();

        //Set the order type of the pages to over then down.
        pageSetup.setOrder(OrderType.OverThenDown);

        String result = "output/SetExcelPageOrderType_out.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);

    }
}
