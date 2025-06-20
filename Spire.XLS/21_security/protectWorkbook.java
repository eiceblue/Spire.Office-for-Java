import com.spire.xls.*;

public class protectWorkbook {
    public static void main(String[] args) {
        // Create a new workbook object
        Workbook workbook = new Workbook();

        // Load an existing Excel file named "worksheetSample1.xlsx" from the specified path
        workbook.loadFromFile("data/worksheetSample1.xlsx");

        // Protect the entire workbook with password "e-iceblue"
        workbook.protect("e-iceblue");

        // Specify the output file path as "output/protectWorkbook_result.xlsx"
        String output = "output/protectWorkbook_result.xlsx";

        // Save the protected workbook to a new file with Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Release resources associated with the workbook
        workbook.dispose();
    }
}
