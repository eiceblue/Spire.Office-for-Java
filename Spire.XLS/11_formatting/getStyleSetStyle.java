import com.spire.xls.*;
import java.awt.*;

public class getStyleSetStyle {
    public static void main(String[] args) throws Exception {
        String input = "data/templateAz.xlsx";
        String output = "output/getStyleSetStyle.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();

        //load a excel document
        workbook.loadFromFile(input);

        //get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //get "B4" cell
        CellRange range = sheet.getCellRange("B4");

        //get the style of cell
        CellStyle style = range.getCellStyle();
        style.getFont().setFontName("Calibri");
        style.getFont().isBold( true);
        style.getFont().setSize( 15);
        style.getFont().setColor( Color.BLUE);
        range.setStyle( style);

        //save to file
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
