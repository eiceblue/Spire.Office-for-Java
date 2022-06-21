import com.spire.xls.*;

public class duplicateCellRange {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile( "data/Template_Xls_1.xlsx");

        //Get the first worksheet.c
        Worksheet sheet = workbook.getWorksheets().get(0);
        //Copy data from source range to destination range and maintain the format.
        sheet.copy(sheet.getRange().get("A6:F6"), sheet.getRange().get("A16:F16"), true);

        String result = "output/duplicateCellRange_result.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
