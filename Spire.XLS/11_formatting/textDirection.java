import com.spire.xls.*;

public class textDirection {
    public static void main(String[] args) {
        // Create a new workbook
        Workbook workbook = new Workbook();

        // Get the first worksheet in the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Get the cell range B5
        CellRange cell = sheet.getCellRange("B5");

        // Set the text of the cell to "Hello Spire!"
        cell.setText("Hello Spire!");

        // Set the reading order of the cell to right-to-left
        cell.getStyle().setReadingOrder(ReadingOrderType.RightToLeft);

        String result = "output/textDirection_result.xlsx";
        // Save the workbook to a file in Excel 2013 format
        workbook.saveToFile(result, ExcelVersion.Version2013);

        // Release the resources used by the workbook
        workbook.dispose();
    }
}
