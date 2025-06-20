import com.spire.xls.*;
import java.awt.*;

public class formatARow {
    public static void main(String[] args) throws Exception {
        String output = "output/formatARow.xlsx";

        //Create a new workbook object
        Workbook workbook = new Workbook();

        //Get the first worksheet in the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Add a new cell style named "newStyle"
        CellStyle style = workbook.getStyles().addStyle("newStyle");

        //Set the vertical alignment of the style to center
        style.setVerticalAlignment( VerticalAlignType.Center);

        //Set the horizontal alignment of the style to center
        style.setHorizontalAlignment(HorizontalAlignType.Center);

        //Set the font color of the style to blue
        style.getFont().setColor(Color.BLUE);

        //Enable the "shrink to fit" option for the style
        style.setShrinkToFit(true);

        //Set the bottom border color of the style to orange
        style.getBorders().getByBordersLineType(BordersLineType.EdgeBottom).setColor(Color.ORANGE);

        //Set the line style of the bottom border of the style to dotted
        style.getBorders().getByBordersLineType(BordersLineType.EdgeBottom).setLineStyle( LineStyleType.Dotted);

        //Apply the "newStyle" cell style to all cells in row 1
        sheet.getRows()[1].setCellStyleName( style.getName());

        //Set the text of all cells in row 1 to "Test"
        sheet.getRows()[1].setText( "Test");

        //Save the modified workbook to the specified file in Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        //Release the resources used by the workbook
        workbook.dispose();
    }
}
