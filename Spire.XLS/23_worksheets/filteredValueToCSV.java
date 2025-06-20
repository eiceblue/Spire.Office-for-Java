import com.spire.xls.*;

public class filteredValueToCSV {
    public static void main(String[] args) throws Exception {
        String input = "data/FilteredSample.xlsx";
        String output = "output/filteredValueToCSV.csv";

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the Excel file from the specified input path
        workbook.loadFromFile(input);

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Save the worksheet to the specified output path, with space as delimiter and without auto-filtering
        sheet.saveToFile(output, " ", false);

        // Dispose the workbook to release resources
        workbook.dispose();
    }
}
