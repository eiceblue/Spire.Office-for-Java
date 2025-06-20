import com.spire.data.table.*;
import com.spire.xls.*;

public class detectIsBlank {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/markerDesigner2.xlsx";
        String outputFile = "output/detectIsBlank_result.xlsx";

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load an Excel file from the specified input file path
        workbook.loadFromFile(inputFile);

        // Create a new DataTable object
        DataTable dt = new DataTable();

        // Set the table name for the DataTable as "data"
        dt.setTableName("data");

        // Create a new DataColumn with the name "value"
        DataColumn column = new DataColumn("value");

        // Add the DataColumn to the DataTable's columns collection
        dt.getColumns().add(column);

        // Create a new DataRow object for the first row
        DataRow row1 = dt.newRow();

        // Set the value at index 0 in the first row to 120
        row1.setObject(0, 120);

        // Create a new DataRow object for the second row
        DataRow row2 = dt.newRow();

        // Set the value at index 0 in the second row to 55
        row2.setObject(0, 55);

        // Create a new DataRow object for the third row
        DataRow row3 = dt.newRow();

        // Set the value at index 0 in the third row to an empty string
        row3.setObject(0, "");

        // Add the rows to the DataTable's rows collection
        dt.getRows().add(row1);
        dt.getRows().add(row2);
        dt.getRows().add(row3);

        // Add the DataTable named "data" to the workbook's marker designer
        workbook.getMarkerDesigner().addDataTable("data", dt);

        // Apply the marker design to the workbook
        workbook.getMarkerDesigner().apply();

        // Calculate all the formulas in the workbook
        workbook.calculateAllValue();

        // Save the workbook to the specified output file path in Excel 2013 format
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);

        // Release any resources used by the workbook
        workbook.dispose();
    }
}
