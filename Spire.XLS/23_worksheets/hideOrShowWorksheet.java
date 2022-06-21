import com.spire.xls.*;

public class hideOrShowWorksheet {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/worksheetSample3.xlsx");

        //Hide the sheet named "Sheet1"
        workbook.getWorksheets().get("Sheet1").setVisibility(WorksheetVisibility.Hidden);

        //Show the second sheet
        workbook.getWorksheets().get(1).setVisibility(WorksheetVisibility.Visible);

        //Save the document
        String output = "output/hideOrShowWorksheet_result.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
