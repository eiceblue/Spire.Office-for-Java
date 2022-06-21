import com.spire.xls.*;

public class setSummaryColumnDirection {
    public static void main(String[] args) {
        //Create a workbook and load an Excel file from disk.
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/GroupRowsAndColumns.xls");

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Group columns.
        sheet.groupByColumns(1, 3, true);

        //Set summary columns to right of details.
        sheet.getPageSetup().isSummaryColumnRight(false);

        //Save to file.
        workbook.saveToFile("output/setSummaryColumnDirection.xlsx", ExcelVersion.Version2013);
    }
}
