import com.spire.xls.*;
import java.awt.*;

public class getStyleSetStyle {
    public static void main(String[] args) throws Exception {

        String input = "data/templateAz.xlsx";
        String output = "output/getStyleSetStyle.xlsx";

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the workbook from the input file
        workbook.loadFromFile(input);

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Get the cell range "B4" from the worksheet
        CellRange range = sheet.getCellRange("B4");

        // Get the cell style of the range
        CellStyle style = range.getCellStyle();
        // Set the font name to "Calibri"
        style.getFont().setFontName("Calibri");
        // Make the font bold
        style.getFont().isBold(true);
        // Set the font size to 15
        style.getFont().setSize(15);
        // Set the font color to blue
        style.getFont().setColor(Color.BLUE);
        // Apply the style to the range
        range.setStyle(style);

        // Save the modified workbook to the output file in Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Release the resources used by the workbook
        workbook.dispose();
    }
}
