import com.spire.xls.*;

public class addTableWithFilter {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile("data/Template_Xls_4.xlsx");

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Create a List Object named in Table.
        sheet.getListObjects().create("Table", sheet.get(1, 1, sheet.getLastRow(), sheet.getLastColumn()));

        //Set the BuiltInTableStyle for List object.
        sheet.getListObjects().get(0).setBuiltInTableStyle(TableBuiltInStyles.TableStyleLight9);

        String result = "output/addTableWithFilter_result.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
