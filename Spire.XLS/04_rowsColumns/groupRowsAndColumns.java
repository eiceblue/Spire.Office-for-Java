import com.spire.xls.*;

public class groupRowsAndColumns {
    public static void main(String[] args) {
        //Create a workbook and load an Excel file from disk.
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/GroupRowsAndColumns.xls");

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Group rows.
        sheet.groupByRows(1,5,false);

        //Group columns.
        sheet.groupByColumns(1,3,false);

        //Save to file.
        workbook.saveToFile("output/GroupRowsAndColumns.xlsx", ExcelVersion.Version2013);
    }
}
