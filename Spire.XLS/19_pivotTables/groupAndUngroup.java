import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.pivottables.XlsPivotTable;
import java.util.EnumSet;

public class groupAndUngroup {
    public static void main(String args[]){

        String input="data/pivotTableGroupAndUngroup.xlsx";
        String groupOutput="output/groupPivotTable.xlsx";
        String upGroupOutput="output/upGroupPivotTable.xlsx";
        /**
         * Group
         */
        // Create a new Workbook object
        Workbook workbook = new Workbook();
        // Load data from the specified input file
        workbook.loadFromFile(input);
        // Get the first worksheet named "Sheet1" from the workbook
        Worksheet sheet = workbook.getWorksheets().get("Sheet1");
        // Get the first pivot table from the worksheet
        XlsPivotTable pt = (XlsPivotTable)sheet.getPivotTables().get(0);
        // Get the PivotField object for the "Count" field
        PivotField r1 = (PivotField)pt.getPivotFields().get("Count");
        // Manually group the values in the "Count" field based on a range of values
        pt.setManualGroupField(r1, 7, 15, EnumSet.of(PivotGroupByType.RangeOfValues), 2);
        // Save the modified workbook to a new file in Excel 2013 format
        workbook.saveToFile(groupOutput, ExcelVersion.Version2013);
        // Clean up resources and release memory
        workbook.dispose();

        /**
         * Ungroup
         */
        // Create another Workbook object
        Workbook workbook2 = new Workbook();
        // Load data from the previous grouped output file
        workbook2.loadFromFile(groupOutput);
        // Get the first worksheet named "Sheet1" from the workbook
        Worksheet sheet2 = workbook2.getWorksheets().get("Sheet1");
        // Get the first pivot table from the worksheet
        XlsPivotTable pt2 = (XlsPivotTable)sheet2.getPivotTables().get(0);
        // Get the PivotField object for the "Count" field
        PivotField r2 = (PivotField)pt2.getPivotFields().get("Count");
        // Ungroup the values in the "Count" field
        pt2.setUngroup(r2);
        // Save the modified workbook to a new file in Excel 2013 format
        workbook2.saveToFile(upGroupOutput, ExcelVersion.Version2013);
        // Clean up resources and release memory
        workbook2.dispose();
    }
}
