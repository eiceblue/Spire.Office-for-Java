import com.spire.xls.*;
import java.awt.*;

public class formatCellsWithStyle {
    public static void main(String[] args) throws Exception {
        String input = "data/SampleB_2.xlsx";
        String output = "output/formatCellsWithStyle.xlsx";

        //load the document from disk
        Workbook workbook = new Workbook();
        workbook.loadFromFile(input);

        //create a style
        CellStyle style = workbook.getStyles().addStyle("newStyle");

        //set the shading color
        style.setColor( Color.DARK_GRAY);

        //set the font color
        style.getFont().setColor( Color.WHITE);

        //set font name
        style.getFont().setFontName( "Times New Roman");

        //set font size
        style.getFont().setSize(12);

        //set bold for the font
        style.getFont().isBold(true);

        //set text rotation
        style.setRotation(45);

        //set alignment
        style.setHorizontalAlignment( HorizontalAlignType.Center);
        style.setVerticalAlignment(VerticalAlignType.Center);

        //set the style for the specific range
        workbook.getWorksheets().get(0).getCellRange("A1:J1").setCellStyleName( style.getName());

        //save the result file
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
