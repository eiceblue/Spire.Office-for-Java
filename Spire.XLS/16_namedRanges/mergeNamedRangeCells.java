import com.spire.xls.*;
import com.spire.xls.core.*;

public class mergeNamedRangeCells {
    public static void main(String[] args) {
        String inputFile="data/allNamedRanges.xlsx";
        String outputFile="output/mergeNamedRangeCells_result.xlsx";

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load an Excel file from the specified input file path
        workbook.loadFromFile(inputFile);

        // Get the first named range from the workbook's collection of named ranges
        INamedRange namedRange = workbook.getNameRanges().get(0);

        // Get the range referred to by the named range
        IXLSRange range = namedRange.getRefersToRange();

        // Merge the cells within the range
        range.merge();

        // Save the modified workbook to the specified output file path in Excel 2010 format
        workbook.saveToFile(outputFile, ExcelVersion.Version2010);

        // Release any resources used by the workbook
        workbook.dispose();
    }
}
