import com.spire.data.table.*;
import com.spire.xls.*;

public class setDataDirection {
    public static void main(String[] args) throws Exception {
        String input = "data/MarkerDesigner.xlsx";
        String output = "output/setDataDirection.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();

        //load the document from disk
        workbook.loadFromFile(input);

        //create a DataTable
        DataTable dt = new DataTable();
        dt.setTableName("data");
        //define a field in it
        dt.getColumns().add(new DataColumn("value"));

        //add three rows to it
        DataRow drName1 = dt.newRow();
        DataRow drName2 = dt.newRow();
        DataRow drName3 = dt.newRow();
        drName1.setString("value","Text1");
        drName2.setString("value","Text2");
        drName3.setString("value","Text3");
        dt.getRows().add(drName1);
        dt.getRows().add(drName2);
        dt.getRows().add(drName3);

        //fill DataTable
        workbook.getMarkerDesigner().addDataTable("data", dt);
        workbook.getMarkerDesigner().apply();

        //save the document
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
