import java.awt.*;
import com.spire.xls.*;

public class setTabColor {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();
        // Load an Excel file from the specified path
        workbook.loadFromFile("data/setTabColor.xlsx");

        // Get the first worksheet from the Workbook
        Worksheet worksheet = workbook.getWorksheets().get(0);
        // Set the tab color of the worksheet to red
        worksheet.setTabColor(Color.red);

        // Get the second worksheet from the Workbook
        worksheet = workbook.getWorksheets().get(1);
        // Set the tab color of the worksheet to green
        worksheet.setTabColor(Color.green);

        // Get the third worksheet from the Workbook
        worksheet = workbook.getWorksheets().get(2);
        // Set the tab color of the worksheet to cyan
        worksheet.setTabColor(Color.CYAN);

        // Specify the output file path for saving the modified Workbook
        String output = "output/setTabColor_result.xlsx";
        // Save the Workbook to the specified file path in Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Release any resources used by the Workbook object
        workbook.dispose();
    }
}
