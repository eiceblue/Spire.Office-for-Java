import com.spire.xls.*;
import java.awt.*;

public class copyDataWithStyle {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Get the default first worksheet
        Worksheet worksheet = workbook.getWorksheets().get(0);

        //Set the values for some cells.
        CellRange cells = worksheet.getRange().get("A1:J50");
        for (int i = 1; i <= 50; i++) {
            for (int j = 1; j <= 10; j++) {
                String text = String.format((i - 1) + "," + (j - 1));
                cells.get(i, j).setText(text);
            }
        }
        //Get a source range (A1:D3).
        CellRange srcRange = worksheet.getRange().get("A1:D3");

        //Create a style object.
        CellStyle style = workbook.getStyles().addStyle("style");

        //Specify the font attribute.
        style.getFont().setFontName("Calibri");

        //Specify the shading color.
        style.getFont().setColor(Color.red);

        //Specify the border attributes.
        style.getBorders().getByBordersLineType(BordersLineType.EdgeTop).setLineStyle(LineStyleType.Thin);
        style.getBorders().getByBordersLineType(BordersLineType.EdgeTop).setColor(Color.blue);
        style.getBorders().getByBordersLineType(BordersLineType.EdgeBottom).setLineStyle(LineStyleType.Thin);
        style.getBorders().getByBordersLineType(BordersLineType.EdgeBottom).setColor(Color.blue);
        style.getBorders().getByBordersLineType(BordersLineType.EdgeRight).setLineStyle(LineStyleType.Thin);
        style.getBorders().getByBordersLineType(BordersLineType.EdgeRight).setColor(Color.blue);

        srcRange.setCellStyleName(style.getName());

        //Set the destination range
        CellRange destRange = worksheet.getRange().get("A12:D14");

        //Copy the range data with style
        srcRange.copy(destRange,true,true);

        //String for output file
        String outputFile = "output/copyDataWithStyle_result.xlsx";

        //Save the file
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }

}
