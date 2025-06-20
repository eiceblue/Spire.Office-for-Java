import com.spire.xls.*;

public class showOrHideGridLine {
    public static void main(String[] args) {
        // Create a new Workbook object.
        Workbook workbook = new Workbook();

        // Load the Excel file from the specified path.
        workbook.loadFromFile("data/worksheetSample2.xlsx");

        // Get the first worksheet from the workbook.
        Worksheet sheet1 = workbook.getWorksheets().get(0);

        // Get the second worksheet from the workbook.
        Worksheet sheet2 = workbook.getWorksheets().get(1);

        // Set the grid lines visibility to false for sheet1.
        sheet1.setGridLinesVisible(false);

        // Set the grid lines visibility to true for sheet2.
        sheet2.setGridLinesVisible(true);

        // Specify the output path for the modified workbook.
        String output = "output/showOrHideGridLine_result.xlsx";

        // Save the modified workbook to the specified output path in Excel 2013 format.
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Release any resources associated with the workbook.
        workbook.dispose();
    }
}
