import com.spire.xls.*;

public class hideZeroValues {
    public static void main(String[] args) throws Exception {
        String input = "data/sampleB_2.xlsx";
        String output = "output/hideZeroValues.xlsx";

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the Excel file from the specified input path
        workbook.loadFromFile(input);

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Set the display of zeros in the worksheet to false
        sheet.isDisplayZeros(false);

        // Save the modified workbook to the specified output path in Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Dispose the workbook to release resources
        workbook.dispose();
    }
}
