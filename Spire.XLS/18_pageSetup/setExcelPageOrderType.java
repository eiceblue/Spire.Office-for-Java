import com.spire.xls.*;

public class setExcelPageOrderType {
    public static void main(String[] args) {

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the workbook from the specified file "data/Template_Xls_4.xlsx"
        workbook.loadFromFile("data/Template_Xls_4.xlsx");

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Get the PageSetup object for the worksheet
        PageSetup pageSetup = sheet.getPageSetup();

        // Set the order type of the pages to "OverThenDown"
        pageSetup.setOrder(OrderType.OverThenDown);

        // Specify the output file path and name
        String result = "output/SetExcelPageOrderType_out.xlsx";

        // Save the modified workbook to the specified file in Excel 2013 format
        workbook.saveToFile(result, ExcelVersion.Version2013);

        // Dispose of the workbook object to release resources
        workbook.dispose();
    }
}
