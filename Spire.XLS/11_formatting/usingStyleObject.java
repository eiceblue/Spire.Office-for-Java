import com.spire.xls.*;

import java.awt.*;

public class usingStyleObject {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Add a new worksheet with the name "new sheet"
        Worksheet sheet = workbook.getWorksheets().add("new sheet");

        // Get the cell range of cell B1 in the worksheet
        CellRange cell = sheet.getCellRange("B1");

        // Set the text in cell B1 to "Hello Spire!"
        cell.setText("Hello Spire!");

        // Create a new CellStyle object and give it a name "newStyle"
        CellStyle style = workbook.getStyles().addStyle("newStyle");

        // Set the vertical alignment of the style to Center
        style.setVerticalAlignment(VerticalAlignType.Center);

        // Set the horizontal alignment of the style to Center
        style.setHorizontalAlignment(HorizontalAlignType.Center);

        // Set the font color of the style to blue
        style.getFont().setColor(Color.blue);

        // Enable shrink to fit for the style
        style.setShrinkToFit(true);

        // Set the bottom border color of the style to yellow
        style.getBorders().getByBordersLineType(BordersLineType.EdgeBottom).setColor(Color.yellow);

        // Set the bottom border's line style to Medium
        style.getBorders().getByBordersLineType(BordersLineType.EdgeBottom).setLineStyle(LineStyleType.Medium);

        // Apply the style to the cell range B1
        cell.setStyle(style);

        // Apply the style to other cell ranges in the worksheet
        sheet.getCellRange("B4").setStyle(style);
        sheet.getCellRange("B4").setText("Test");
        sheet.getCellRange("C3").setCellStyleName(style.getName());
        sheet.getCellRange("C3").setText("Welcome to use Spire.XLS");
        sheet.getCellRange("D4").setStyle(style);

        String result = "output/usingStyleObject_result.xlsx";
        // Save the modified workbook to the output file specified in Excel 2013 format
        workbook.saveToFile(result, ExcelVersion.Version2013);

        // Release the resources used by the workbook
        workbook.dispose();
    }
}
