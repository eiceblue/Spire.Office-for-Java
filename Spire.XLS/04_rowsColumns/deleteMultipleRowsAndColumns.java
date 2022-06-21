import com.spire.xls.*;

public class deleteMultipleRowsAndColumns {
    public static void main(String[] args) {
        //Create a workbook and load an Excel file from disk.
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/DeleteRowsAndColumns.xls");

        //Get the first worksheet.
        Worksheet worksheet = workbook.getWorksheets().get(0);

        //Delete 4 rows from the fifth row.
        worksheet.deleteRow(5, 4);

        //Delete 2 columns from the second column.
        worksheet.deleteColumn(2, 2);

        //Save to file.
        workbook.saveToFile("output/DeleteMultipleRowsAndColumns.xlsx", ExcelVersion.Version2013);
    }
}
