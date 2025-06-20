import java.awt.*;
import com.spire.xls.*;

public class applyStyleToWorksheet {
	public static void main(String[] args) {
            // Create a new Workbook object
            Workbook workbook = new Workbook();

           // Load the workbook from the specified file path
            workbook.loadFromFile("data/worksheetSample1.xlsx");

           // Get the first worksheet from the workbook
            Worksheet sheet = workbook.getWorksheets().get(0);

           // Create a new CellStyle object named "newStyle"
            CellStyle style = workbook.getStyles().addStyle("newStyle");

           // Set the color of the style to CYAN
            style.setColor(Color.CYAN);

           // Set the font color of the style to white
            style.getFont().setColor(Color.white);

           // Set the font size of the style to 15
            style.getFont().setSize(15);

           // Make the font bold in the style
            style.getFont().isBold(true);

           // Apply the style to the worksheet
            sheet.applyStyle(style);

           // Specify the output file path for saving the modified workbook
            String output = "output/applyStyleToWorksheet_result.xlsx";

           // Save the workbook to the specified output file path in Excel 2013 format
            workbook.saveToFile(output, ExcelVersion.Version2013);

           // Dispose of the workbook resources to free up memory
            workbook.dispose();
    }
}
