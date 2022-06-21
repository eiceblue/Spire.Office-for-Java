import com.spire.xls.*;

import java.awt.*;

public class usingStyleObject {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Add a new worksheet to the Excel object
        Worksheet sheet = workbook.getWorksheets().add("new sheet");

        //Access the "B1" cell from the worksheet
        CellRange cell = sheet.getCellRange("B1");

        //Add some value to the "B1" cell
        cell.setText("Hello Spire!");

        //Create a new style
        CellStyle style = workbook.getStyles().addStyle("newStyle");

        //Set the vertical alignment of the text in the "B1" cell
        style.setVerticalAlignment(VerticalAlignType.Center);

        //Set the horizontal alignment of the text in the "B1" cell
        style.setHorizontalAlignment(HorizontalAlignType.Center);

        //Set the font color of the text in the "B1" cell
        style.getFont().setColor(Color.blue);

        //Shrink the text to fit in the cell
        style.setShrinkToFit(true);

        //Set the bottom border color of the cell to GreenYellow
        style.getBorders().getByBordersLineType(BordersLineType.EdgeBottom).setColor(Color.yellow);

        //Set the bottom border type of the cell to Medium
        style.getBorders().getByBordersLineType(BordersLineType.EdgeBottom).setLineStyle(LineStyleType.Medium);

        //Assign the Style object to the "B1" cell
        cell.setStyle(style);

        //Apply the same style to some other cells
        sheet.getCellRange("B4").setStyle(style);
        sheet.getCellRange("B4").setText("Test");
        sheet.getCellRange("C3").setCellStyleName(style.getName());
        sheet.getCellRange("C3").setText("Welcome to use Spire.XLS");
        sheet.getCellRange("D4").setStyle(style);

        String result = "output/usingStyleObject_result.xlsx";

        //Save to file
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
