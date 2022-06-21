import com.spire.xls.*;

public class setSummaryRowDirection {
    public static void main(String[] args) {
        //Create a workbook and load an Excel file from disk.
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/GroupRowsAndColumns.xls");

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Group rows
        sheet.groupByRows(1, 3, true);

        //Set summary rows below details.
        sheet.getPageSetup().isSummaryRowBelow(false);

        //Save to file.
        workbook.saveToFile("output/setSummaryRowDirection.xlsx", ExcelVersion.Version2013);
    }
}
