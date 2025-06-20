import com.spire.xls.*;
import com.spire.xls.core.*;
import com.spire.xls.core.spreadsheet.collections.*;
import java.awt.*;

public class highlightAverageValues {
    public static void main(String[] args) throws Exception {
        String input = "data/Template_Xls_6.xlsx";
        String output = "output/highlightAverageValues.xlsx";

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the workbook from the input file
        workbook.loadFromFile(input);

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Add conditional formats to apply formatting based on conditions

        // Create a new XlsConditionalFormats object
        XlsConditionalFormats format1 = sheet.getConditionalFormats().add();
        // Add the cell range "E2:E10" to the conditional format
        format1.addRange(sheet.getCellRange("E2:E10"));
        // Create an average condition of type "Below"
        IConditionalFormat cf1 = format1.addAverageCondition(AverageType.Below);
        // Set the background color to blue for cells that meet the average condition
        cf1.setBackColor(Color.BLUE);

        // Create another XlsConditionalFormats object
        XlsConditionalFormats format2 = sheet.getConditionalFormats().add();
        // Add the same cell range "E2:E10" to the second conditional format
        format2.addRange(sheet.getCellRange("E2:E10"));
        // Create an average condition of type "Above"
        IConditionalFormat cf2 = format1.addAverageCondition(AverageType.Above);
        // Set the background color to orange for cells that meet the average condition
        cf2.setBackColor(Color.ORANGE);

        // Save the modified workbook to the output file in Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        //Release the resources used by the workbook
        workbook.dispose();
    }
}
