import com.spire.xls.*;
import java.awt.*;

public class colorsAndPalette {
    public static void main(String[] args) throws Exception {
        String output = "output/colorsAndPalette.xlsx";

        //Create a new workbook
        Workbook workbook = new Workbook();

        //Change the palette color to Orchid at index 60
        workbook.changePaletteColor(Color.YELLOW, 60);

        //Get the first worksheet in the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);
        //Get the cell range B2
        CellRange cell = sheet.getCellRange("B2");
        //Set the text in the cell
        cell.setText("Welcome to use Spire.XLS");

        //Set the font color, size, and autofit the columns and rows of the cell
        cell.getStyle().getFont().setColor( Color.YELLOW);
        cell.getStyle().getFont().setSize(20);
        cell.autoFitColumns();
        cell.autoFitRows();

        //Save the workbook to the specified file with Excel 2010 format
        workbook.saveToFile(output, ExcelVersion.Version2010);

        //Release the resources used by the workbook
        workbook.dispose();
    }
}
