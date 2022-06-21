import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.pivottables.*;

public class clearPivotFields {
    public static void main(String[] args)throws Exception {
        String input = "data/PivotTableExample.xlsx";
        String output = "output/clearPivotFields.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();

        //load an excel file including pivot table
        workbook.loadFromFile(input);

        //get the sheet in which the pivot table is located
        Worksheet sheet = workbook.getWorksheets().get("PivotTable");
        XlsPivotTable pt = (XlsPivotTable)sheet.getPivotTables().get(0);

        //clear all the data fields
        pt.getDataFields().clear();
        pt.calculateData();

        //save to file
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
