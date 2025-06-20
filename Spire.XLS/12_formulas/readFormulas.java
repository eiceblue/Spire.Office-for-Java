import com.spire.xls.*;

public class readFormulas {
    public static void main(String[] args) {
        String inputFile="data/readFormulas.xlsx";

        // Create a new workbook object
        Workbook workbook = new Workbook();
        // Load the workbook from the specified input file
        workbook.loadFromFile(inputFile);
        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Get the formula of cell C14
        String formula = sheet.getCellRange("C14").getFormula();
        // Get the numerical value calculated from the formula in cell C14
        double value = sheet.getCellRange("C14").getFormulaNumberValue();

        // Print the formula to the console
        System.out.println("Formula: " + formula);
        // Print the calculated value to the console
        System.out.println("Value: " + value);
    }
}
