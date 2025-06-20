import com.spire.xls.*;

public class decryptWorkbook {
    public static void main(String[] args) {
        String fileName = "data/decryptWorkbook.xlsx";

        // Check if the specified Excel file is password protected
        boolean value = Workbook.isPasswordProtected(fileName);

        // If the file is password protected
        if (value) {
            // Create a new Workbook object
            Workbook workbook = new Workbook();

            // Set the open password for the workbook
            workbook.setOpenPassword("eiceblue");

            // Load and open the password-protected workbook
            workbook.loadFromFile(fileName);

            // Remove the protection from the workbook
            workbook.unProtect();

            // Specify the output path for the decrypted workbook
            String output = "output/decryptWorkbook_result.xlsx";

            // Save the decrypted workbook to the specified output path in Excel 2013 format
            workbook.saveToFile(output, ExcelVersion.Version2013);

            // Clean up and release any resources used by the workbook
            workbook.dispose();
        }
    }
}
