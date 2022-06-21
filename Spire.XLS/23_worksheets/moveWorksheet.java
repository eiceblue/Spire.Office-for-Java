import com.spire.xls.*;

public class moveWorksheet {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/worksheetSample2.xlsx");

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Move worksheet
        sheet.moveWorksheet(2);

        //Save the document
        String output = "output/moveWorksheet_result.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
