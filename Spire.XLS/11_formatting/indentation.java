import com.spire.xls.*;

public class indentation {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Add a new worksheet to the Excel object
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Access the "B5" cell from the worksheet
        CellRange cell = sheet.getCellRange("B5");

        //Add some value to the "B5" cell
        cell.setText("Hello Spire!");

        //Set the indentation level of the text (inside the cell) to 2
        cell.getStyle().setIndentLevel(2);

        //Save to file
        String result = "output/indentation_result.xlsx";
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
