import com.spire.xls.*;

public class removeWorksheet {
	public static void main(String[] args) {
		//Create a workbook and load a file
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/removeWorksheet.xlsx");
        
        //Remove a worksheet by sheet index
        workbook.getWorksheets().removeAt(1);
        
        //Save the document
        String output = "output/removeWorksheet_result.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
	}
}
