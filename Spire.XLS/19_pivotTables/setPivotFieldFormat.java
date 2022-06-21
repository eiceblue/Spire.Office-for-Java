import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.pivottables.*;

public class setPivotFieldFormat {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load an excel file including pivot table
        workbook.loadFromFile("data/pivotTableExample.xlsx");

        //Get the sheet in which the pivot table is located
        Worksheet sheet = workbook.getWorksheets().get("PivotTable");

        XlsPivotTable pt = (XlsPivotTable) sheet.getPivotTables().get(0);
        PivotField pf = (PivotField) pt.getPivotFields().get(0);

        //Setting the field auto sort ascend
        pf.setSortType(PivotFieldSortType.Ascending);

        //Setting Subtotal auto show
        pf.setSubtotalTop(true);

        //Setting Subtotal as Count type
        pf.setSubtotals(SubtotalTypes.Count);

        //Setting the field auto show
        pf.isAutoShow(true);

        String result = "output/setPivotFieldFormat_result.xlsx";

        //Save to file
        workbook.saveToFile(result, ExcelVersion.Version2013);

    }
}
