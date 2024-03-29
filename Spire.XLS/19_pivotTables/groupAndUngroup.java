import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.pivottables.XlsPivotTable;

import java.util.EnumSet;

public class groupAndUngroup {
    public static void main(String args[]){
       //The input and output file paths
        String input="data/pivotTableGroupAndUngroup.xlsx";
        String groupOutput="output/groupPivotTable.xlsx";
        String upGroupOutput="output/upGroupPivotTable.xlsx";
        /**
         * Group
         */
        //Create a workbook
        Workbook workbook = new Workbook();
        //Load the input file
        workbook.loadFromFile(input);
        //Get sheet by name
        Worksheet sheet = workbook.getWorksheets().get("Sheet1");
        //Get the first pivot table of this sheet
        XlsPivotTable pt = (XlsPivotTable)sheet.getPivotTables().get(0);
        //Get pivot field by name
        PivotField r1 = (PivotField)pt.getPivotFields().get("Count");
        //Set group
        pt.setManualGroupField(r1,7,15, EnumSet.of(PivotGroupByType.RangeOfValues),2);
        //Save to a new file
        workbook.saveToFile(groupOutput, ExcelVersion.Version2013);
        //Close the workbook
        workbook.dispose();

        /**
         * UpGroup
         */
        Workbook workbook2 = new Workbook();
        //Load the file which generated by the code above
        workbook2.loadFromFile(groupOutput);
        //Get sheet by name
        Worksheet sheet2 = workbook2.getWorksheets().get("Sheet1");
        //Get the first pivot table of this sheet
        XlsPivotTable pt2 = (XlsPivotTable)sheet2.getPivotTables().get(0);
        //Get pivot field by name
        PivotField r2 = (PivotField)pt2.getPivotFields().get("Count");
        //UpGroup the grouped cell range
        pt2.setUngroup(r2);
        //Save to a new file
        workbook2.saveToFile(upGroupOutput, ExcelVersion.Version2013);
        //Close the workbook
        workbook2.dispose();
    }
}
