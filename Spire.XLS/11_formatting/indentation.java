import com.spire.xls.*;

public class indentation {
    public static void main(String[] args) {
        //Create a new Workbook object
        Workbook workbook = new Workbook();

        //Get the first worksheet in the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Get the CellRange object representing the cell at B5
        CellRange cell = sheet.getCellRange("B5");

        //Set the text of the cell to "Hello Spire!"
        cell.setText("Hello Spire!");

        //Set the indentation level of the cell's style to 2
        cell.getStyle().setIndentLevel(2);

        String result = "output/indentation_result.xlsx";
        //Save the workbook to the specified file in Excel 2010 format
        workbook.saveToFile(result, ExcelVersion.Version2013);

        //Release the resources used by the workbook
        workbook.dispose();
    }
}
