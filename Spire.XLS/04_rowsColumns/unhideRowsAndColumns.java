import com.spire.xls.*;

public class unhideRowsAndColumns {
    public static void main(String[] args) {
        //Create a workbook and load an Excel file from disk.
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/CommonTemplate1.xlsx");

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Unhide the row
        sheet.showRow(15);

        //Unhide the column
        sheet.showColumn(4);

        //Save to file.
        workbook.saveToFile("output/unhideRowsAndColumns.xlsx", ExcelVersion.Version2013);
    }
}
