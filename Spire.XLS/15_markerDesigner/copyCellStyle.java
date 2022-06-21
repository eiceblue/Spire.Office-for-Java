import com.spire.data.table.DataTable;
import com.spire.xls.*;

public class copyCellStyle {
    public static void main(String[] args) {

        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/MarkerDesigner1.xlsx");

        Worksheet sheet = workbook.getWorksheets().get(0);
        //Fill DataTable
        workbook.getMarkerDesigner().addDataTable("data",LoadForm1());
        workbook.getMarkerDesigner().apply();

        //Save the document
        String output = "output/CopyCellStyle_out.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
    private static DataTable LoadForm1()
    {
        //Create a workbook and load an Excel file from disk.
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/MarkerDesigner-DataSample.xls");

        //Initialize worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);
        return sheet.exportDataTable();
    }
}
