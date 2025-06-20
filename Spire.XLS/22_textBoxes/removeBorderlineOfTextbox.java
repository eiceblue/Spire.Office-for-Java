import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.shapes.*;

public class removeBorderlineOfTextbox {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Set the Excel version for the workbook to 2013
        workbook.setVersion(ExcelVersion.Version2013);

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Set the name of the worksheet to "Remove Borderline"
        sheet.setName("Remove Borderline");

        // Add a new chart to the worksheet
        Chart chart = sheet.getCharts().add();

        // Add a TextBox shape to the chart at position (50, 50) with width 100 and height 600
        XlsTextBoxShape textbox1 = (XlsTextBoxShape)chart.getTextBoxes().addTextBox(50, 50, 100, 600);
        textbox1.setText("The solution with borderline");

        // Add another TextBox shape to the chart at position (1000, 50) with width 100 and height 600
        XlsTextBoxShape textbox2 = (XlsTextBoxShape)chart.getTextBoxes().addTextBox(1000, 50, 100, 600);
        textbox2.setText("The solution without borderline");

        // Set the line weight of textbox2 to 0, effectively removing the border line around it
        textbox2.getLine().setWeight(0);

        // Specify the path for the output file
        String result = "output/RemoveBorderlineOfTextbox_out.xlsx";

        // Save the modified workbook to the output file in Excel 2013 format
        workbook.saveToFile(result, ExcelVersion.Version2013);

        // Dispose the workbook object to release resources
        workbook.dispose();
    }
}
