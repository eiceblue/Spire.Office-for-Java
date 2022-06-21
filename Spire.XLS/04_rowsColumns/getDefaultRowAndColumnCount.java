import com.spire.xls.*;

public class getDefaultRowAndColumnCount {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();
        //Clear all worksheets
        workbook.getWorksheets().clear();

        //Create a new worksheet
        Worksheet sheet = workbook.createEmptySheet();

        //Get row and column count
        int rowCount = sheet.getRows().length;
        int columnCount = sheet.getColumns().length;

        System.out.println(rowCount);
        System.out.println(columnCount);
    }
}
