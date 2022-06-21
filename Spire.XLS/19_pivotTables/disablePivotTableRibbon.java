import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.pivottables.*;

public class disablePivotTableRibbon {
    public static void main(String[] args) {
        Workbook workbook = new Workbook();

        //Load an excel file including pivot table
        workbook.loadFromFile("data/pivotTableExample.xlsx");
        //Get the sheet in which the pivot table is located
        Worksheet sheet = workbook.getWorksheets().get("PivotTable");

        XlsPivotTable pt = (XlsPivotTable) sheet.getPivotTables().get(0);
        //Disable ribbon for this pivot table
        pt.setEnableWizard(false);

        //Save to file
        String result = "output/disablePivotTableRibbon_result.xlsx";
        workbook.saveToFile(result, ExcelVersion.Version2013);

    }
}
