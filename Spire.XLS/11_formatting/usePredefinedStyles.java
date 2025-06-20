import com.spire.xls.*;

import java.awt.*;

public class usePredefinedStyles {
    public static void main(String[] args) {
        // Create a new workbook object
        Workbook workbook = new Workbook();

        // Get the first worksheet in the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Create a new cell style named "newStyle"
        CellStyle style = workbook.getStyles().addStyle("newStyle");
        style.getFont().setFontName("Calibri");
        style.getFont().isBold(true);
        style.getFont().setSize(15);
        style.getFont().setColor(Color.blue);

        // Get the cell range B5
        CellRange range =sheet.getCellRange("B5");
        // Set the text of the cell and apply the "newStyle" to it
        range.setText("Welcome to use Spire.XLS");
        range.setCellStyleName(style.getName());

        // Auto-fit the columns in the range
        range.autoFitColumns();

        String result = "output/usePredefinedStyles_result.xlsx";

        // Save the modified workbook to a new file
        workbook.saveToFile(result, ExcelVersion.Version2013);


       // Release the resources used by the workbook
        workbook.dispose();
    }
}
