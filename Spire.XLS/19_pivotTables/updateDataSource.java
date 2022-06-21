import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.pivottables.*;

public class updateDataSource {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load an excel file including pivot table
        workbook.loadFromFile("data/pivotTableExample.xlsx");

        //Modify data of data source
        Worksheet data = workbook.getWorksheets().get("Data");
        data.getRange().get("A2").setText("NewValue");
        data.getRange().get("D2").setNumberValue(28000);

        //Get the sheet in which the pivot table is located
        Worksheet sheet = workbook.getWorksheets().get("PivotTable");

        XlsPivotTable pt = (XlsPivotTable) sheet.getPivotTables().get(0);
        //Refresh and calculate
        pt.getCache().isRefreshOnLoad(true);
        pt.calculateData();

        String result = "output/updateDataSource_result.xlsx";

        //Save to file
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
