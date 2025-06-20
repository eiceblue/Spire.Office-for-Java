import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.pivottables.*;

public class setPivotFieldFormat {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load an Excel file named "pivotTableExample.xlsx" from the specified path
        workbook.loadFromFile("data/pivotTableExample.xlsx");

        // Get the Worksheet named "PivotTable" from the workbook
        Worksheet sheet = workbook.getWorksheets().get("PivotTable");

        // Get the first PivotTable from the Worksheet and cast it to XlsPivotTable
        XlsPivotTable pt = (XlsPivotTable) sheet.getPivotTables().get(0);

        // Get the first PivotField from the PivotTable and cast it to PivotField
        PivotField pf = (PivotField) pt.getPivotFields().get(0);

        // Set the sort type of the PivotField to ascending
        pf.setSortType(PivotFieldSortType.Ascending);

        // Enable top subtotal for the PivotField
        pf.setSubtotalTop(true);

        // Set the subtotal type of the PivotField to Count
        pf.setSubtotals(SubtotalTypes.Count);

        // Enable auto show for the PivotField
        pf.isAutoShow(true);

        // Specify the output file path for the modified workbook
        String result = "output/setPivotFieldFormat_result.xlsx";

        // Save the workbook to the specified file path in Excel 2013 format
        workbook.saveToFile(result, ExcelVersion.Version2013);

        // Release resources used by the workbook
        workbook.dispose();
    }
}
