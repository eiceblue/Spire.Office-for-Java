import com.spire.xls.*;

public class useArrayR1C1Formula {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        sheet.getCellRange("A1").setNumberValue(1);
        sheet.getCellRange("A2").setNumberValue(2);
        sheet.getCellRange("A3").setNumberValue(3);
        sheet.getCellRange("B1").setNumberValue(4);
        sheet.getCellRange("B2").setNumberValue(5);
        sheet.getCellRange("B3").setNumberValue(6);
        sheet.getCellRange("C1").setNumberValue(7);
        sheet.getCellRange("C2").setNumberValue(8);
        sheet.getCellRange("C3").setNumberValue(9);

        sheet.getCellRange("B4").setText("Sum:");
        sheet.getCellRange("B4").getStyle().setHorizontalAlignment(HorizontalAlignType.Right);
        //Write array  R1C1 formula
        sheet.getCellRange("C4").setFormulaArrayR1C1("=SUM(R[-3]C[-2]:R[-1]C)");

        //Calculate Formulas
        workbook.calculateAllValue();

        String result = "output/useArrayR1C1Formulas_result.xlsx";

        //Save to file
        workbook.saveToFile(result, ExcelVersion.Version2010);
    }
}
