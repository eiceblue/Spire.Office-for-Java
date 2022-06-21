import com.spire.xls.*;

public class readFormulas {
    public static void main(String[] args) {
        String inputFile="data/readFormulas.xlsx";

        Workbook workbook = new Workbook();
        workbook.loadFromFile(inputFile);
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Get the formula and value
        String formula = sheet.getCellRange("C14").getFormula();
        double value = sheet.getCellRange("C14").getFormulaNumberValue();

        //Print
        System.out.println("Formula: " + formula);
        System.out.println("value: " + value);
    }
}
