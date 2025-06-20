import com.spire.xls.*;
import com.spire.xls.core.*;
import com.spire.xls.core.spreadsheet.pivottables.XlsPivotTable;
import java.util.Date;

public class groupPivotTableByDate {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the workbook from the specified file path
        workbook.loadFromFile("data/GroupPivotTableByDate.xlsx");

        // Get the first worksheet in the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Get the first pivot table in the worksheet
        XlsPivotTable pt = (XlsPivotTable)sheet.getPivotTables().get(0);

        // Get the first row field in the pivot table
        IPivotField field = pt.getRowFields().get(0);

        // Set the start and end dates for grouping
        Date start = new  Date("2023/1/5");
        Date end = new  Date("2023/3/2");

        // Set the group by type to days
        PivotGroupByTypes[] types = new PivotGroupByTypes[] { PivotGroupByTypes.Days };

        // Create a new group with the specified start and end dates, group by type, and interval
        field.createGroup(start, end, types, 10);

        // Calculate the pivot table data
        pt.calculateData();

        // Refresh the pivot table cache
        pt.getCache().isRefreshOnLoad(true);

        // Set the output file name
        String result = "output/GroupPivotTableByDate_output.xlsx";

        // Save the workbook to the specified file path with the specified Excel version
        workbook.saveToFile(result, FileFormat.Version2016);

        // Dispose the workbook object to release resources
        workbook.dispose();
    }
}
