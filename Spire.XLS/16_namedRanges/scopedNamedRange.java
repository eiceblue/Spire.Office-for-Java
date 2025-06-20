import com.spire.xls.*;
import com.spire.xls.core.INamedRange;

public class scopedNamedRange {
    public static void main(String[] args) {
        String inputFile="data/scopedNamedRange.xlsx";
        String outputFile="output/scopedNamedRange_result.xlsx";

        // Create a new Workbook object
        Workbook workbook = new Workbook();
        // Load data from the specified inputFile into the workbook
        workbook.loadFromFile(inputFile);

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Add a new named range to the worksheet and assign it to the variable namedRange
        INamedRange namedRange = sheet.getNames().add("Range1");

        // Set the range referred to by the named range to be cell range A1 to D19 in the worksheet
        namedRange.setRefersToRange(sheet.getCellRange("A1:D19"));

        // Save the modified workbook to the specified outputFile using Excel 2013 format
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);

        // Dispose of the workbook object and release any associated resources
        workbook.dispose();
    }
}
