import com.spire.xls.*;

public class registerAddInFunction {
    public static void main(String[] args) {
        String inputFile = "data/test.xlam";
        String outputFile="output/registerAddInFunction_result.xlsx";

        //Create a workbook
        Workbook workbook = new Workbook();

        //Register AddIn function
        workbook.getAddInFunctions().add(inputFile, "TEST_UDF");
        workbook.getAddInFunctions().add(inputFile, "TEST_UDF1");

        //Get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Call AddIn function
        sheet.getCellRange("A1").setFormula("=TEST_UDF()");
        sheet.getCellRange("A2").setFormula("=TEST_UDF1()");

        //Save to file
        workbook.saveToFile(outputFile, ExcelVersion.Version2010);
    }
}
