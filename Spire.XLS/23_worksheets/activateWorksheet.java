import com.spire.xls.*;

public class activateWorksheet {
    public static void main(String[] args) {
        // Create a workbook
        Workbook workbook = new Workbook();

        // Load the document from disk
        workbook.loadFromFile("data/worksheetSample2.xlsx");

        // Get the second worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(1);

        // Activate the sheet
        sheet.activate();

        // Save the document
        String output = "output/activateWorksheet_result.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
