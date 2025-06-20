import com.spire.xls.*;
import com.spire.xls.core.*;

public class namedRanges {
    public static void main(String[] args) {
        String inputFile="data/namedRanges.xlsx";
        String outputFile="output/namedRanges_result.xlsx";

        // Create a new Workbook object
        Workbook workbook = new Workbook();
        // Load data from the specified inputFile into the workbook
        workbook.loadFromFile(inputFile);

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Add a new named range to the workbook and assign it to the variable NamedRange
        INamedRange namedRange = workbook.getNameRanges().add("NewNamedRange");

        // Set the range referred to by the named range to be cell range A8 to E12 in the worksheet
        namedRange.setRefersToRange(sheet.getCellRange("A8:E12"));

        // Save the modified workbook to the specified outputFile using Excel 2013 format
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);

        // Dispose of the workbook object and release any associated resources
        workbook.dispose();
    }
}
