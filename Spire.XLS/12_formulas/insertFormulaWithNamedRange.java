import com.spire.xls.*;
import com.spire.xls.core.INamedRange;

public class insertFormulaWithNamedRange {
    public static void main(String[] args) {
        // Create a new workbook object
        Workbook workbook = new Workbook();
        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Set the value of cell A1 to "1"
        sheet.getCellRange("A1").setValue("1");
        // Set the value of cell A2 to "1"
        sheet.getCellRange("A2").setValue("1");

        // Create a named range object and add it to the workbook's named ranges collection
        INamedRange NamedRange = workbook.getNameRanges().add("NewNamedRange");
        // Set the local name of the named range to the formula "=SUM(A1+A2)"
        NamedRange.setNameLocal("=SUM(A1+A2)");

        // Set the formula of cell C1 to the named range "NewNamedRange"
        sheet.getCellRange("C1").setFormula("NewNamedRange");

        // Specify the file path where the result will be saved
        String result = "output/insertFormulaWithNamedRange_result.xlsx";
        // Save the workbook to the specified file path in Excel 2013 format
        workbook.saveToFile(result, ExcelVersion.Version2013);

        // Release resources used by the workbook
        workbook.dispose();
    }
}
