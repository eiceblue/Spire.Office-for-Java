import com.spire.xls.*;

public class insertRowsAndColumns {
    public static void main(String[] args) {
        //Create a workbook and load an Excel file from disk.
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/InsertRowsAndColumns.xls");

        //Get the first worksheet.
        Worksheet worksheet = workbook.getWorksheets().get(0);

        //Insert a row into the worksheet.
        worksheet.insertRow(2);

        //Insert a column into the worksheet.
        worksheet.insertColumn(2);

        //Insert multiple rows into the worksheet.
        worksheet.insertRow(5, 2);

        //Insert multiple columns into the worksheet.
        worksheet.insertColumn(5, 2);

        //Save to file.
        workbook.saveToFile("output/InsertRowsAndColumns.xlsx", ExcelVersion.Version2013);
    }
}
