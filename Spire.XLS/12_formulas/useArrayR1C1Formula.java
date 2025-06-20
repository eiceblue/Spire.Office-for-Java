import com.spire.xls.*;

public class useArrayR1C1Formula {
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

        // Set text and formatting for a specific cell range in the worksheet
        sheet.getCellRange("B4").setText("Sum:");
        sheet.getCellRange("B4").getStyle().setHorizontalAlignment(HorizontalAlignType.Right);

        // Set an array formula using R1C1 notation for a specific cell in the worksheet
        sheet.getCellRange("C4").setFormulaArrayR1C1("=SUM(R[-3]C[-2]:R[-1]C)");

        // Calculate all the formulas and update their values
        workbook.calculateAllValue();

        // Specify the output file path and save the workbook in Excel 2010 format
        String result = "output/useArrayR1C1Formulas_result.xlsx";
        workbook.saveToFile(result, ExcelVersion.Version2010);

        // Release resources used by the workbook
        workbook.dispose();
    }
}
