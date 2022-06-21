import com.spire.xls.*;

public class autoFitColumnInRange {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/AutoFitSample.xlsx");

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Auto fit the Column of the worksheet
        sheet.autoFitColumn(2, 2, 5);

        //Save the document
        String output = "output/autoFitColumnInRange_result.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
