import com.spire.xls.*;

public class copySheetWithinWorkbook {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the file from disk
        workbook.loadFromFile("data/template_Xls_4.xlsx");

        //Get the first and the second worksheets
        Worksheet sheet = workbook.getWorksheets().get(0);
        Worksheet sheet1 = workbook.getWorksheets().add("MySheet");
        CellRange sourceRange = sheet.getAllocatedRange();

        //Copy the first worksheet to the second one
        sheet.copy(sourceRange, sheet1, sheet.getFirstRow(), sheet.getFirstColumn(), true);

        String result = "output/copySheetWithinWorkbook_result.xlsx";

        //Save to file
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
