import com.spire.xls.*;

public class hideOrShowRowColumnHeaders {
    public static void main(String[] args) {
        //Create a workbook and load an Excel file from disk.
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/DeleteRowsAndColumns.xls");

        //Get the first worksheet.
        Worksheet worksheet = workbook.getWorksheets().get(0);

        //Hide the headers of rows and columns
        worksheet.setRowColumnHeadersVisible(false);

        //Show the headers of rows and columns
        //worksheet.RowColumnHeadersVisible = true;

        String result = "output/Result-HideOrShowRowColumnHeaders.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);

    }
}
