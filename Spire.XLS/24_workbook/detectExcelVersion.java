import com.spire.xls.*;

public class detectExcelVersion {
    public static void main(String[] args) {
        // Create an array of file paths for the Excel files to be processed
        String[] files = new String[] { "data/ExcelSample97_N.xls", "data/WorksheetSample4.xlsx", "data/ExcelSample_N.xlsb" };

        // Iterate through each file path in the array
        for (String file : files) {
            // Create a new Workbook object
            Workbook workbook = new Workbook();

            // Load the Excel file from the specified file path
            workbook.loadFromFile(file);

            // Get the version of the loaded workbook
            ExcelVersion version = workbook.getVersion();

            // Print the version information to the console
            System.out.println(version);

            // Clean up and release any resources used by the workbook
            workbook.dispose();
        }
    }
}
