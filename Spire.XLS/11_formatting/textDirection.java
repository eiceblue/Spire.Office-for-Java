import com.spire.xls.*;

public class textDirection {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Add a new worksheet to the Excel object
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Access the "B5" cell from the worksheet
        CellRange cell = sheet.getCellRange("B5");

        //Add some value to the "B5" cell
        cell.setText("Hello Spire!");

        //Set the reading order from right to left of the text in the "B5" cell
        cell.getStyle().setReadingOrder(ReadingOrderType.RightToLeft);

        //Save to file
        String result = "output/textDirection_result.xlsx";
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
