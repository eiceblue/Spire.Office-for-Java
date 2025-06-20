import com.spire.xls.*;

public class encryptWorkbook {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load workbook data from the specified file
        workbook.loadFromFile("data/encryptWorkbook.xlsx");

        // Protect the workbook with a password ("eiceblue")
        workbook.protect("eiceblue");

        // Specify the output file path
        String output = "output/encryptWorkbook_result.xlsx";

        // Save the protected workbook to the specified output file in Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Release resources associated with the workbook
        workbook.dispose();
    }
}
