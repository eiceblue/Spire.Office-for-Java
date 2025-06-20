import com.spire.xls.*;
import com.spire.xls.core.INamedRange;

public class setFormulaWithNamedRange {
    public static void main(String[] args) {
        String inputFile="data/setFormulaWithNamedRange.xlsx";
        String outputFile="output/setFormulaWithNamedRange_result.xlsx";

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load data from the specified inputFile into the workbook
        workbook.loadFromFile(inputFile);

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Add a new named range to the workbook and assign it to the variable NamedRange
        INamedRange namedRange = workbook.getNameRanges().add("MyNamedRange");

        // Set the range referred to by the named range to be cell range B10 to B12 in the worksheet
        namedRange.setRefersToRange(sheet.getCellRange("B10:B12"));

        // Set the formula of cell B13 to calculate the sum of the named range "MyNamedRange"
        sheet.getCellRange("B13").setFormula("=SUM(MyNamedRange)");

        // Set the numeric values for cells B10, B11, and B12
        sheet.getCellRange("B10").setNumberValue(10);
        sheet.getCellRange("B11").setNumberValue(20);
        sheet.getCellRange("B12").setNumberValue(30);

        // Save the modified workbook to the specified outputFile using Excel 2013 format
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);

        // Dispose of the workbook object and release any associated resources
        workbook.dispose();
    }
}