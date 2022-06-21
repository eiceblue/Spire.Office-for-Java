import com.spire.xls.*;

public class hideRowsAndColumns {
    public static void main(String[] args) {
        //Create a workbook and load an Excel file from disk.
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/HideRowsAndColumns.xls");

        //Get the first worksheet.
        Worksheet worksheet = workbook.getWorksheets().get(0);

        //Hide the column of the worksheet.
        worksheet.hideColumn(2);

        //Hide the row of the worksheet.
        worksheet.hideRow(4);

        //Save to file.
        workbook.saveToFile("output/HideRowsAndColumns.xlsx", ExcelVersion.Version2013);
    }
}
