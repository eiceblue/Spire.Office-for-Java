import com.spire.data.table.DataTable;
import com.spire.xls.*;

public class copyCellStyle {
    public static void main(String[] args) {

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load an existing workbook from the specified file path
        workbook.loadFromFile("data/MarkerDesigner1.xlsx");

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Add a DataTable named "data" using the LoadForm1() method
        workbook.getMarkerDesigner().addDataTable("data", LoadForm1());

        // Apply the marker design to the workbook
        workbook.getMarkerDesigner().apply();

        // Specify the output file path for saving the modified workbook
        String output = "output/CopyCellStyle_out.xlsx";

        // Save the workbook to the specified file path using Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Clean up and release resources used by the workbook
        workbook.dispose();
    }
    // Load Form1 data from an Excel file and return it as a DataTable
    private static DataTable LoadForm1() {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the Excel file "MarkerDesigner-DataSample.xls" into the workbook
        workbook.loadFromFile("data/MarkerDesigner-DataSample.xls");

        // Get the first worksheet in the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Export the data from the worksheet as a DataTable and return it
        return sheet.exportDataTable();
    }
}
