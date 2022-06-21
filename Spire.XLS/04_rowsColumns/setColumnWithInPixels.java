import com.spire.xls.*;

public class setColumnWithInPixels {
    public static void main(String[] args) {
        //Create a workbook and load an Excel file from disk.
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/DeleteRowsAndColumns.xls");

        //Get the first worksheet.
        Worksheet worksheet = workbook.getWorksheets().get(0);

        //Set the width of the third column to 400 pixels.
        worksheet.setColumnWidthInPixels(3, 400);

        String result = "output/Result-SetColumnWithInPixels.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);

    }
}
