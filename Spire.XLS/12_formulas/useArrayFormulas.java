import com.spire.xls.*;

public class useArrayFormulas {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Get the first sheet
        Worksheet sheet =  workbook.getWorksheets().get(0);

        sheet.getCellRange("A1").setNumberValue(1);
        sheet.getCellRange("A2").setNumberValue(2);
        sheet.getCellRange("A3").setNumberValue(3);
        sheet.getCellRange("B1").setNumberValue(4);
        sheet.getCellRange("B2").setNumberValue(5);
        sheet.getCellRange("B3").setNumberValue(6);
        sheet.getCellRange("C1").setNumberValue(7);
        sheet.getCellRange("C2").setNumberValue(8);
        sheet.getCellRange("C3").setNumberValue(9);

        //Write array formula
        sheet.getCellRange("A5:C6").setFormulaArray("=LINEST(A1:A3,B1:C3,TRUE,TRUE)");

        //Calculate Formulas
        workbook.calculateAllValue();

        String result = "output/useArrayFormulas_result.xlsx";

        //Save to file
        workbook.saveToFile(result, ExcelVersion.Version2010);
    }
}
