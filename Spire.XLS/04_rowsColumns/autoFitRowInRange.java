import com.spire.xls.*;

public class autoFitRowInRange {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/AutoFitSample.xlsx");

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Auto fit the second row of the worksheet
        sheet.autoFitRow(2, 1, 2, false);

        //Save the document
        String output = "output/autoFitRowInRange_result.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);

    }
}
