import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.pivottables.*;

public class hideAllItemOfPivotTable {
    public static void main(String[] args) {
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/pivotTable.xlsx");
        Worksheet sheet = workbook.getWorksheets().get(0);

        XlsPivotTable pivotTable = (XlsPivotTable)sheet.getPivotTables().get(0);
        PivotField pivotField = (PivotField)pivotTable.getPivotFields().get("Product");
        pivotField.hideAllItem(true);

        pivotTable.calculateData();

        workbook.saveToFile("output/hideAllItemOfPivotTable.xlsx",FileFormat.Version2013);
    }
}
