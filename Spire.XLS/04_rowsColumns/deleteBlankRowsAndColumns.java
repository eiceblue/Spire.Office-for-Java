import com.spire.xls.*;

public class deleteBlankRowsAndColumns {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile("data/Template_Xls_2.xlsx");

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Delete blank rows from the worksheet.
        for (int i = sheet.getRows().length - 1; i >= 0; i--) {
            if (sheet.getRows()[i].isBlank()) {
                sheet.deleteRow(i + 1);
            }
        }

        //Delete blank columns from the worksheet.
        for (int j = sheet.getColumns().length - 1; j >= 0; j--) {
            if (sheet.getColumns()[j].isBlank()) {
                sheet.deleteColumn(j + 1);
            }
        }

        String result = "output/deleteBlankRowsAndColumns_result.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);

    }
}
