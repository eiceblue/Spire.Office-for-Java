import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.pivottables.*;

public class setFormatOptions {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();
        //Load an excel file including pivot table
        workbook.loadFromFile("data/PivotTableExample.xlsx");

        //Get the sheet in which the pivot table is located
        Worksheet sheet = workbook.getWorksheets().get("PivotTable");

        XlsPivotTable pt = (XlsPivotTable)sheet.getPivotTables().get(0);
        //Set the PivotTable report is automatically formatted
        pt.getOptions().isAutoFormat(true);

        //Setting the PivotTable report shows grand totals for rows.
        pt.setShowRowGrand(true);

        //Setting the PivotTable report shows grand totals for columns.
        pt.setShowColumnGrand(true);

        //Setting the PivotTable report displays a custom string in cells that contain null values.
        pt.setDisplayNullString(true);
        pt.setNullString("null");

        //Setting the PivotTable report's layout
        pt.setPageFieldOrder(PagesOrderType.DownThenOver);

        String result = "output/SetFormatOptions_out.xlsx";

        //Save to file
        workbook.saveToFile(result, ExcelVersion.Version2010);
    }
}
