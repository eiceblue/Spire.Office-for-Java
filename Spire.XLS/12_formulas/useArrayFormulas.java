import com.spire.xls.*;

public class useArrayFormulas {
    public static void main(String[] args) {
        // Create a new workbook object
        Workbook workbook = new Workbook();

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Set numeric values for specific cell ranges in the worksheet
        sheet.getCellRange("A1").setNumberValue(1);
        sheet.getCellRange("A2").setNumberValue(2);
        sheet.getCellRange("A3").setNumberValue(3);
        sheet.getCellRange("B1").setNumberValue(4);
        sheet.getCellRange("B2").setNumberValue(5);
        sheet.getCellRange("B3").setNumberValue(6);
        sheet.getCellRange("C1").setNumberValue(7);
        sheet.getCellRange("C2").setNumberValue(8);
        sheet.getCellRange("C3").setNumberValue(9);

        // Set an array formula for a range of cells in the worksheet
        sheet.getCellRange("A5:C6").setFormulaArray("=LINEST(A1:A3,B1:C3,TRUE,TRUE)");

        // Calculate all the formulas and update their values
        workbook.calculateAllValue();

        // Specify the output file path and save the workbook in Excel 2010 format
        String result = "output/useArrayFormulas_result.xlsx";
        workbook.saveToFile(result, ExcelVersion.Version2010);

        // Release resources used by the workbook
        workbook.dispose();
    }
}
