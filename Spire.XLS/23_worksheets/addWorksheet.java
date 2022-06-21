import com.spire.xls.*;

public class addWorksheet {
	public static void main(String[] args) {
		// Load a Workbook from disk 
		Workbook workbook = new Workbook();
		workbook.loadFromFile("data/addWorksheet.xlsx");

		// Add a new worksheet named AddedSheet
		Worksheet sheet = workbook.getWorksheets().add("AddedSheet");
		sheet.getRange().get("C5").setText("This is a new sheet.");

		// Save to file
		String output = "output/addWorksheet_result.xlsx";
		workbook.saveToFile(output, ExcelVersion.Version2013);
	}
}
