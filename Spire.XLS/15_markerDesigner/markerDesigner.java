import com.spire.data.table.DataTable;
import com.spire.xls.*;

public class markerDesigner {
    public static void main(String[] args) {
        String inputFile1 = "data/markerDesigner.xls";
        String inputFile2 = "data/markerDesigner-DataSample.xls";
        String outputFile = "output/markerDesigner_result.xlsx";

        //Create a workbook and load an Excel file from disk.
        Workbook workbook = new Workbook();
        workbook.loadFromFile(inputFile1);

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Fill parameter.
        workbook.getMarkerDesigner().addParameter("Variable1",1234.5678);

        //Fill DataTable.
        workbook.getMarkerDesigner().addDataTable("Country",GetData(inputFile2));
        workbook.getMarkerDesigner().apply();

        //Set the worksheet AutoFit property.
        sheet.getAllocatedRange().autoFitRows();
        sheet.getAllocatedRange().autoFitColumns();

        //Save to file.
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }

    private static DataTable GetData(String inputFile2)
    {
        //Create a workbook and load an Excel file from disk.
        Workbook workbook = new Workbook();
        workbook.loadFromFile(inputFile2);

        //Initialize worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);
        return sheet.exportDataTable();
    }
}
