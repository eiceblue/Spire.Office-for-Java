import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.autofilter.*;

public class filterCellsByString {
	public static void main(String[] args) {

		// Create a workbook.
		Workbook workbook = new Workbook();

		// Load the file from disk.
		workbook.loadFromFile("data/Template_Xls_6.xlsx");

		// Get the first worksheet.
		Worksheet sheet = workbook.getWorksheets().get(0);

		// Filter the cell which starts with "South".
		sheet.getAutoFilters().setRange(sheet.get("D1:D19"));
		FilterColumn filtercolumn = (FilterColumn) sheet.getAutoFilters().get(0);
		sheet.getAutoFilters().customFilter(filtercolumn, FilterOperatorType.Equal, "South*");
		sheet.getAutoFilters().filter();
		
		String result = "output/filterCellsByString_result.xlsx";

		// Save to file.
		workbook.saveToFile(result, ExcelVersion.Version2013);
	}
}