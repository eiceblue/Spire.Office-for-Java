import com.spire.data.table.DataTable;
import com.spire.xls.*;

public class markerDesigner {
    public static void main(String[] args) {
        String inputFile1 = "data/markerDesigner.xls";
        String inputFile2 = "data/markerDesigner-DataSample.xls";
        String outputFile = "output/markerDesigner_result.xlsx";

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load an Excel file from the specified input file path (inputFile1)
        workbook.loadFromFile(inputFile1);

        // Get the first worksheet in the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Add a parameter named "Variable1" with a value of 1234.5678 to the workbook's marker designer
        workbook.getMarkerDesigner().addParameter("Variable1", 1234.5678);

        // Add a DataTable named "Country" to the workbook's marker designer by calling the GetData method with the inputFile2 parameter
        workbook.getMarkerDesigner().addDataTable("Country", GetData(inputFile2));

        // Apply the marker design to the workbook
        workbook.getMarkerDesigner().apply();

        // Automatically adjust the row height of the allocated range in the worksheet
        sheet.getAllocatedRange().autoFitRows();

        // Automatically adjust the column width of the allocated range in the worksheet
        sheet.getAllocatedRange().autoFitColumns();

        // Save the modified workbook to the specified output file path in Excel 2013 format
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);

        // Release any resources used by the workbook
        workbook.dispose();
    }

    // Retrieves data from an input file and returns it as a DataTable.
    private static DataTable GetData(String inputFile2)
    {
        // Create a new instance of Workbook.
        Workbook workbook = new Workbook();

        // Load the specified input file into the Workbook.
        workbook.loadFromFile(inputFile2);

        // Get the first worksheet from the Workbook.
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Export the data from the worksheet to a DataTable.
        return sheet.exportDataTable();
    }
}
