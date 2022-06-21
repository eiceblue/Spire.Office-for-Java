import com.spire.xls.*;
import com.spire.xls.core.INamedRange;

public class insertFormulaWithNamedRange {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Set value
        sheet.getCellRange("A1").setValue("1");
        sheet.getCellRange("A2").setValue("1");

        //Create a named range
        INamedRange NamedRange = workbook.getNameRanges().add("NewNamedRange");

        NamedRange.setNameLocal("=SUM(A1+A2)");

        //Set the formula
        sheet.getCellRange("C1").setFormula("NewNamedRange");

        //Save the Excel file
        String result = "output/insertFormulaWithNamedRange_result.xlsx";
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
