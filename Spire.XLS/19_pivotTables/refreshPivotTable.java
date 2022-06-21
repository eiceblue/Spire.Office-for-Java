import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.pivottables.*;

public class refreshPivotTable {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the file from disk
        workbook.loadFromFile("data/template_Xls_7.xlsx");

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(1);

        //Update the data source of PivotTable
        sheet.getRange().get("D2").setValue("999");

        //Get the PivotTable that was built on the data source
        XlsPivotTable pt = (XlsPivotTable) workbook.getWorksheets().get(0).getPivotTables().get(0);

        //Refresh the data of PivotTable
        pt.getCache().isRefreshOnLoad(true);

        //Save to file
        String result = "output/refreshPivotTable_result.xlsx";
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
