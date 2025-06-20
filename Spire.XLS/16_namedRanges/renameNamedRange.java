import com.spire.xls.*;

public class renameNamedRange {
    public static void main(String[] args) {
        String inputFile="data/allNamedRanges.xlsx";
        String outputFile="output/renameNamedRange_result.xlsx";

        // Create a new Workbook object to represent an Excel workbook
        Workbook workbook = new Workbook();

        // Load the contents of the input file into the Workbook object
        workbook.loadFromFile(inputFile);

        // Retrieve the first named range in the workbook and set its name to "RenameRange"
        workbook.getNameRanges().get(0).setName("RenameRange");

        // Save the modified workbook to the specified output file in Excel 2010 format
        workbook.saveToFile(outputFile, ExcelVersion.Version2010);

        // Clean up and release any resources associated with the workbook
        workbook.dispose();
    }
}
