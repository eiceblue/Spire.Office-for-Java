import com.spire.xls.*;
import java.awt.*;

public class formatAColumn {
    public static void main(String[] args) throws Exception {
        String output = "output/formatAColumn.xlsx";

        //Create a new workbook
        Workbook workbook = new Workbook();

        //Get the first worksheet in the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Add a new cell style named "newStyle"
        CellStyle style = workbook.getStyles().addStyle("newStyle");

        //Set the vertical alignment of the style to center
        style.setVerticalAlignment( VerticalAlignType.Center);

        //Set the horizontal alignment of the style to center
        style.setHorizontalAlignment( HorizontalAlignType.Center);

        //Set the font color of the style to blue
        style.getFont().setColor( Color.BLUE);

        //Enable the "shrink to fit" option for the style
        style.setShrinkToFit(true);

        //Set the bottom border color and style of the style
        style.getBorders().getByBordersLineType(BordersLineType.EdgeBottom).setColor( Color.ORANGE);
        style.getBorders().getByBordersLineType(BordersLineType.EdgeBottom).setLineStyle( LineStyleType.Dotted);

        //Apply the "newStyle" cell style to all cells in column 0
        sheet.getColumns()[0].setCellStyleName(style.getName());
        //Set the text of all cells in column 0 to "Test"
        sheet.getColumns()[0].setText( "Test");

        //Save the modified workbook to a new file named "formatAColumn.xlsx" using Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        //Release the resources used by the workbook
        workbook.dispose();
    }
}
