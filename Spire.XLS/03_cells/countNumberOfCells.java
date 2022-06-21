import com.spire.xls.*;

public class countNumberOfCells {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile( "data/Template_Xls_4.xlsx");

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Get the number of cells.
       System.out.println("Number of Cells: " + sheet.getCells().length);
    }
}
