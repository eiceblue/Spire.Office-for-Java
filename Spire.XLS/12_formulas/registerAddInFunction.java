import com.spire.xls.*;

public class registerAddInFunction {
    public static void main(String[] args) {
        String inputFile = "data/test.xlam";
        String outputFile = "output/registerAddInFunction_result.xlsx";

        // Create a new workbook object
        Workbook workbook = new Workbook();

        // Add custom add-in functions to the workbook from the specified input file
        workbook.getAddInFunctions().add(inputFile, "TEST_UDF");
        workbook.getAddInFunctions().add(inputFile, "TEST_UDF1");

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Set the formula of cell A1 to use the "TEST_UDF" function
        sheet.getCellRange("A1").setFormula("=TEST_UDF()");
        // Set the formula of cell A2 to use the "TEST_UDF1" function
        sheet.getCellRange("A2").setFormula("=TEST_UDF1()");

        // Save the workbook to the specified output file in Excel 2010 format
        workbook.saveToFile(outputFile, ExcelVersion.Version2010);

        // Release resources used by the workbook
        workbook.dispose();
    }
}
