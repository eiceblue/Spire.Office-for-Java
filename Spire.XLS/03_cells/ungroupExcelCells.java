import com.spire.xls.*;

public class ungroupExcelCells {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile("data/Template_Xls_3.xlsx");

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Ungroup the row 10 to 12.
        sheet.ungroupByRows(10, 12);

        //Ungroup the row 16 to 19.
        sheet.ungroupByRows(16, 19);

        String result = "output/ungroupExcelCells_result.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
