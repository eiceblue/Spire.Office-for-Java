import com.spire.xls.*;

public class insertHtmlStringIntoCell {
	public static void main(String[] args) {
		//create a workbook
		Workbook workbook = new Workbook();
		//get the first worksheet
		Worksheet worksheet = workbook.getWorksheets().get(0);
		//html code
		String htmlCode = "<div>first line<br>second line<br>third line</div>";
		//get the A1 range
		CellRange range = worksheet.getCellRange("A1");
		//insert html string
		range.setHtmlString(htmlCode);
		//save the document
		workbook.saveToFile("output/insertHtmlStringIntoCell.xlsx", ExcelVersion.Version2013);
	}
}