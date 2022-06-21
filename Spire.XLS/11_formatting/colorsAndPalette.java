import com.spire.xls.*;
import java.awt.*;

public class colorsAndPalette {
    public static void main(String[] args) throws Exception {
        String output = "output/colorsAndPalette.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();

        //adding Orchid color to the palette at 60th index
        workbook.changePaletteColor(Color.YELLOW, 60);

        //get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        CellRange cell = sheet.getCellRange("B2");
        cell.setText("Welcome to use Spire.XLS");

        //set the Orchid (custom) color to the font
        cell.getStyle().getFont().setColor( Color.YELLOW);
        cell.getStyle().getFont().setSize(20);
        cell.autoFitColumns();
        cell.autoFitRows();

        //save to file
        workbook.saveToFile(output, ExcelVersion.Version2010);
    }
}
