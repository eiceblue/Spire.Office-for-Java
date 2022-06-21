import com.spire.xls.*;

public class setDefaultRowHeight {
    public static void main(String[] args) {
        //Create a workbook and load an Excel file from disk.
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/DeleteRowsAndColumns.xls");

        //Get the first worksheet.
        Worksheet worksheet = workbook.getWorksheets().get(0);

        //Set default row height
        worksheet.setDefaultRowHeight(30);

        //Save to file.
        workbook.saveToFile("output/SetDefaultRowHeight.xlsx", ExcelVersion.Version2013);
    }
}
