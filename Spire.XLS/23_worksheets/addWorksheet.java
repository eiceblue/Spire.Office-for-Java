import com.spire.xls.*;

public class addWorksheet {
	public static void main(String[] args) {
		// Create a new Workbook object
		Workbook workbook = new Workbook();
		// Load an existing Excel file named "addWorksheet.xlsx"
		workbook.loadFromFile("data/addWorksheet.xlsx");

		// Add a new worksheet to the Workbook and assign it to the 'sheet' variable
		Worksheet sheet = workbook.getWorksheets().add("AddedSheet");
		// Set the text "This is a new sheet" in cell C5 of the newly added worksheet
		sheet.getRange().get("C5").setText("This is a new sheet.");

		// Specify the output file path for the modified Workbook
		String output = "output/addWorksheet_result.xlsx";
		// Save the Workbook to the specified output file path in Excel 2013 format
		workbook.saveToFile(output, ExcelVersion.Version2013);
		// Clean up system resources by disposing of the Workbook object
		workbook.dispose();
	}
}
