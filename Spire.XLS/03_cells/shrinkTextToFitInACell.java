import com.spire.xls.*;

public class shrinkTextToFitInACell {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile("data/Template_Xls_1.xlsx");

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //The cell range to shrink text.
        CellRange cell = sheet.getRange().get("B13:C13");

        //Enable ShrinkToFit.
        CellStyle style = cell.getCellStyle();
        style.setShrinkToFit(true);

        String result = "output/ShrinkTextToFitInACell_result.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
