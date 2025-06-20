import com.spire.xls.*;

public class removeNamedRange {
    public static void main(String[] args) {
        String inputFile="data/allNamedRanges.xlsx";
        String outputFile="output/removeNamedRange_result.xlsx";

        // Create a new Workbook object
        Workbook workbook = new Workbook();
        // Load data from the specified inputFile into the workbook
        workbook.loadFromFile(inputFile);

        // Remove the named range at index 0 from the workbook's collection of named ranges
        workbook.getNameRanges().removeAt(0);

        // Remove the named range with the name "NameRange2" from the workbook's collection of named ranges
        workbook.getNameRanges().remove("NameRange2");

        // Save the modified workbook to the specified outputFile using Excel 2010 format
        workbook.saveToFile(outputFile, ExcelVersion.Version2010);

        // Dispose of the workbook object and release any associated resources
        workbook.dispose();
    }
}
