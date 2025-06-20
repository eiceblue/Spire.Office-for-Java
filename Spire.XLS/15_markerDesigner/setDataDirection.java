import com.spire.data.table.*;
import com.spire.xls.*;

public class setDataDirection {
    public static void main(String[] args) throws Exception {
        String input = "data/MarkerDesigner.xlsx";
        String output = "output/setDataDirection.xlsx";

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load an existing workbook from the specified input file
        workbook.loadFromFile(input);

        // Create a new DataTable object
        DataTable dt = new DataTable();

        // Set the table name of the DataTable as "data"
        dt.setTableName("data");

        // Create a new DataColumn with the column name "value" and add it to the DataTable's columns collection
        dt.getColumns().add(new DataColumn("value"));

        // Create three new DataRow objects for the DataTable
        DataRow drName1 = dt.newRow();
        DataRow drName2 = dt.newRow();
        DataRow drName3 = dt.newRow();

        // Set the value of the "value" column in each DataRow
        drName1.setString("value", "Text1");
        drName2.setString("value", "Text2");
        drName3.setString("value", "Text3");

        // Add the DataRows to the DataTable's rows collection
        dt.getRows().add(drName1);
        dt.getRows().add(drName2);
        dt.getRows().add(drName3);

        // Add the DataTable to the MarkerDesigner in the workbook
        workbook.getMarkerDesigner().addDataTable("data", dt);

        // Apply the marker design to the workbook
        workbook.getMarkerDesigner().apply();

        // Save the workbook to the specified output file path using Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Clean up and release resources used by the workbook
        workbook.dispose();
    }
}
