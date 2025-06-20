import com.spire.xls.*;
import java.awt.*;

public class formatCellsWithStyle {
    public static void main(String[] args) throws Exception {
        String input = "data/SampleB_2.xlsx";
        String output = "output/formatCellsWithStyle.xlsx";

        //Create a new Workbook object
        Workbook workbook = new Workbook();
        workbook.loadFromFile(input);

        //Create a new CellStyle object named "newStyle"
        CellStyle style = workbook.getStyles().addStyle("newStyle");

        //Set the color of the style to DarkGray
        style.setColor( Color.DARK_GRAY);

        //Set the font color of the style to White
        style.getFont().setColor( Color.WHITE);

        //Set the font name of the style to "Times New Roman"
        style.getFont().setFontName( "Times New Roman");

        //Set the font size of the style to 12
        style.getFont().setSize(12);

        //Make the font bold in the style
        style.getFont().isBold(true);

        // Set the rotation angle of the style to 45 degrees
        style.setRotation(45);

        //Set the horizontal alignment of the style to Center
        style.setHorizontalAlignment( HorizontalAlignType.Center);
        //Set the vertical alignment of the style to Center
        style.setVerticalAlignment(VerticalAlignType.Center);

        //Apply the style to the range A1:J1 in the first worksheet of the workbook
        workbook.getWorksheets().get(0).getCellRange("A1:J1").setCellStyleName( style.getName());

        //Save the workbook to the specified file in Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        //Release the resources used by the workbook
        workbook.dispose();
    }
}
