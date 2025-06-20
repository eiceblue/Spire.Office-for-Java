import com.spire.xls.*;

public class useR1C1Formula {
    public static void main(String[] args) {
        // Create a new workbook
        Workbook workbook = new Workbook();

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Set number values in cells
        sheet.getCellRange("A1").setNumberValue(1);
        sheet.getCellRange("A2").setNumberValue(2);
        sheet.getCellRange("A3").setNumberValue(3);
        sheet.getCellRange("B1").setNumberValue(4);
        sheet.getCellRange("B2").setNumberValue(5);
        sheet.getCellRange("B3").setNumberValue(6);
        sheet.getCellRange("C1").setNumberValue(7);
        sheet.getCellRange("C2").setNumberValue(8);
        sheet.getCellRange("C3").setNumberValue(9);

        // Set text and alignment for cell B4
        sheet.getCellRange("B4").setText("Sum:");
        sheet.getCellRange("B4").getStyle().setHorizontalAlignment(HorizontalAlignType.Right);

        // Set formula for cell C4 using R1C1 notation
        sheet.getCellRange("C4").setFormulaR1C1("=SUM(R[-3]C[-2]:R[-1]C)");

        // Calculate all values in the workbook
        workbook.calculateAllValue();

        // Save the workbook to a file
        String result = "output/useR1C1Formula_result.xlsx";
        workbook.saveToFile(result, ExcelVersion.Version2010);

        // Release resources used by the workbook
        workbook.dispose();
    }
}
