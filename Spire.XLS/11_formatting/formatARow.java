import com.spire.xls.*;
import java.awt.*;

public class formatARow {
    public static void main(String[] args) throws Exception {
        String output = "output/formatARow.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();

        //get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //create a new style
        CellStyle style = workbook.getStyles().addStyle("newStyle");

        //set the vertical alignment of the text
        style.setVerticalAlignment( VerticalAlignType.Center);

        //set the horizontal alignment of the text
        style.setHorizontalAlignment(HorizontalAlignType.Center);

        //set the font color of the text
        style.getFont().setColor(Color.BLUE);

        //shrink the text to fit in the cell
        style.setShrinkToFit(true);

        //set the bottom border color of the cell to OrangeRed
        style.getBorders().getByBordersLineType(BordersLineType.EdgeBottom).setColor(Color.ORANGE);

        //set the bottom border type of the cell to Dotted
        style.getBorders().getByBordersLineType(BordersLineType.EdgeBottom).setLineStyle( LineStyleType.Dotted);

        //apply the style to the second row
        sheet.getRows()[1].setCellStyleName( style.getName());
        sheet.getRows()[1].setText( "Test");

        //Save to file
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
