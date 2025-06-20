import com.spire.xls.*;

public class zoomFactor {
    public static void main(String[] args) {
        // Create a new Workbook object.
        Workbook workbook = new Workbook();

        // Load an existing Excel file named "zoomFactor.xlsx" from the specified path.
        workbook.loadFromFile("data/zoomFactor.xlsx");

        // Get the first worksheet from the workbook.
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Set the zoom factor of the worksheet to 85%.
        sheet.setZoom(85);

        // Specify the output file path for saving the modified workbook.
        String output = "output/zoomFactor_result.xlsx";

        // Save the workbook to the specified output file path in Excel 2013 format.
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Dispose of system resources associated with the workbook.
        workbook.dispose();
    }
}
