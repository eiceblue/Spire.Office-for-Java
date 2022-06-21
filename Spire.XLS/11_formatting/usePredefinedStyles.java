import com.spire.xls.*;

import java.awt.*;

public class usePredefinedStyles {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Create a new style
        CellStyle style = workbook.getStyles().addStyle("newStyle");
        style.getFont().setFontName("Calibri");
        style.getFont().isBold(true);
        style.getFont().setSize(15);
        style.getFont().setColor(Color.blue);

        //Get "B5" cell
        CellRange range =sheet.getCellRange("B5");
        range.setText("Welcome to use Spire.XLS");
        range.setCellStyleName(style.getName());
        range.autoFitColumns();

        String result = "output/usePredefinedStyles_result.xlsx";

        //Save to file
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
