import com.spire.xls.*;

public class copyCellFormat {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile("data/Template_Xls_1.xlsx");

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Copy the cell format from column 2 and apply to cells of column 5.
        int count = sheet.getRows().length;
        for (int i = 1; i < count + 1; i++) {
            sheet.getRange().get("E"+i).setStyle(sheet.getRange().get("B"+i).getStyle());
        }

        String result = "output/copyCellFormat_result.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }

}
