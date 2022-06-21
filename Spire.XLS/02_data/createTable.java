import com.spire.xls.*;

public class createTable {
    public static void main(String[] args) {
        //Create a workbook and load an Excel file from disk.
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/CreateTable.xlsx");

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Add a new List Object to the worksheet.
        sheet.getListObjects().create("table", sheet.getCellRange(1, 1, 19, 5));

        //Add Default Style to the table.
        sheet.getListObjects().get(0).setBuiltInTableStyle(TableBuiltInStyles.TableStyleLight9);

        //Save to file.
        workbook.saveToFile("output/createTable_result.xlsx", ExcelVersion.Version2013);
    }
}
