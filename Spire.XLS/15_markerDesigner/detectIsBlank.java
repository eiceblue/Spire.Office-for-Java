import com.spire.data.table.*;
import com.spire.xls.*;

public class detectIsBlank {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/markerDesigner2.xlsx";
        String outputFile = "output/detectIsBlank_result.xlsx";

        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile(inputFile);

        //Create a DataTable
        DataTable dt = new DataTable();
        dt.setTableName("data");
        DataColumn column=new DataColumn("value");
        dt.getColumns().add(column);
        DataRow row1=dt.newRow();
        row1.setObject(0,120);
        DataRow row2=dt.newRow();
        row2.setObject(0,55);
        DataRow row3=dt.newRow();
        row3.setObject(0,"");
        dt.getRows().add(row1);
        dt.getRows().add(row2);
        dt.getRows().add(row3);

        //Create a DataTable
        workbook.getMarkerDesigner().addDataTable("data",dt);
        workbook.getMarkerDesigner().apply();

        //Calculate formulas
        workbook.calculateAllValue();

        //Save the document
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
