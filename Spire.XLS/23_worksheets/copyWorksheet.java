import com.spire.xls.*;

public class copyWorksheet {
    public static void main(String[] args) {
        // Create a new workbook object to hold the source workbook
        Workbook sourceWorkbook = new Workbook();

        // Load an existing workbook from the specified file path
        sourceWorkbook.loadFromFile("data/readImages.xlsx");

        // Get the first worksheet from the source workbook
        Worksheet srcWorksheet = sourceWorkbook.getWorksheets().get(0);

        // Create a new workbook object to hold the target workbook
        Workbook targetWorkbook = new Workbook();

        // Load an existing workbook as the target workbook
        targetWorkbook.loadFromFile("data/sample.xlsx");

        // Create a new worksheet in the target workbook with the name "added"
        Worksheet targetWorksheet = targetWorkbook.getWorksheets().add("added");

        // Copy the contents of the source worksheet to the target worksheet
        targetWorksheet.copyFrom(srcWorksheet);

        // Specify the file path for the resulting workbook
        String outputFile = "output/copyWorksheet_result.xlsx";

        // Save the target workbook to the specified file path with Excel 2013 format
        targetWorkbook.saveToFile(outputFile, ExcelVersion.Version2013);

        // Release resources associated with the source workbook
        sourceWorkbook.dispose();

        // Release resources associated with the target workbook
        targetWorkbook.dispose();
    }
}
