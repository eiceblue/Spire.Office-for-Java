import com.spire.xls.*;

public class setHeightAndWidth {
    public static void main(String[] args) {
        //Create a workbook and load an Excel file from disk.
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/SetHeightAndWidth.xls");

        //Get the first worksheet.
        Worksheet worksheet = workbook.getWorksheets().get(0);

        //Set the width to 30.
        worksheet.setColumnWidth(4, 30);

        //Set the height to 30.
        worksheet.setRowHeight(4,30);

        //Save to file.
        workbook.saveToFile("output/SetHeightAndWidth.xlsx", ExcelVersion.Version2013);
    }
}
