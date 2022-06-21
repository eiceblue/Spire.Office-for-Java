import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.pivottables.XlsPivotTable;

public class formattingAppearance {
    public static void main(String[] args){
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load an excel file including pivot table
        workbook.loadFromFile("data/PivotTableExample.xlsx");
        //Get the sheet in which the pivot table is located
        Worksheet sheet = workbook.getWorksheets().get("PivotTable");

        XlsPivotTable pt = (XlsPivotTable)sheet.getPivotTables().get(0);

        //Format appearance
        pt.setBuiltInStyle(PivotBuiltInStyles.PivotStyleLight10);

        pt.getOptions().setShowGridDropZone(true);
        pt.getOptions().setRowLayout(PivotTableLayoutType.Compact);


        String result = "output/FormattingAppearance_result.xlsx";

        //Save to file
        workbook.saveToFile(result, ExcelVersion.Version2010);
    }
}
