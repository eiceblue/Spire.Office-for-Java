import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.pivottables.*;

public class formatDataField {
	public static void main(String[] args) {
		Workbook workbook = new Workbook();
        workbook.loadFromFile("data/formatDataField.xlsx");
        Worksheet sheet = workbook.getWorksheets().get(0);
        
        // Access the PivotTable
        XlsPivotTable pt = (XlsPivotTable)sheet.getPivotTables().get(0);
        // Access the data field.
        PivotDataField pivotDataField = pt.getDataFields().get(0);
        // Set data display format
        pivotDataField.setShowDataAs(PivotFieldFormatType.PercentageOfColumn);

        String result = "output/formatDataField_result.xlsx";
        workbook.saveToFile(result, ExcelVersion.Version2013);
	}
}
