import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.pivottables.*;

public class expandOrCollapseRows {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the file from disk
        workbook.loadFromFile("data/template_Xls_7.xlsx");

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Get the data in Pivot Table
        XlsPivotTable pivotTable = (XlsPivotTable) sheet.getPivotTables().get(0);

        //Calculate Data
        pivotTable.calculateData();

        //Collapse the rows
        ((XlsPivotField) pivotTable.getPivotFields().get("Vendor No")).hideItemDetail("3501", true);

        //Expand the rows
        ((XlsPivotField) pivotTable.getPivotFields().get("Vendor No")).hideItemDetail("3502", false);

        //Save to file
        String result = "output/expandOrCollapseRowsInPivotTable_result.xlsx";
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
