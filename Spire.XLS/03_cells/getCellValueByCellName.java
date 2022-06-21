import com.spire.xls.*;

public class getCellValueByCellName {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile( "data/Template_Xls_4.xlsx");

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Specify a cell by its name.
        CellRange cell = sheet.getRange().get("A2");

        StringBuilder content = new StringBuilder();

        //Get value of cell "A2".
        content.append("The value of cell A2 is: " + cell.getValue()+"\n");

        System.out.println(content);
    }
}
