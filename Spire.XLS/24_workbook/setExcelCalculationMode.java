import com.spire.xls.*;

public class setExcelCalculationMode {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load data from the "createTable.xlsx" file into the workbook
        workbook.loadFromFile("data/createTable.xlsx");

        // Set the calculation mode of the workbook to Manual
        workbook.setCalculationMode(ExcelCalculationMode.Manual);

        // Specify the output file path for saving the result
        String outputFile = "output/setExcelCalculationMode_result.xlsx";

        // Save the workbook to the specified output file path in Excel 2013 format
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);

        // Dispose of the workbook object to release resources
        workbook.dispose();
    }
}
