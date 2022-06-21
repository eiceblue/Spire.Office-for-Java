import com.spire.xls.*;

public class hideCellContent {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile("data/Template_Xls_1.xlsx");

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Hide the area by setting the number format as ";;;".
        sheet.getRange().get("C5:D6").setNumberFormat(";;;");

        String result = "output/hideCellContentBySettingNumberFormat_result.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);

    }
}
