import com.spire.xls.*;
import com.spire.xls.core.*;
import java.awt.*;

public class formatNamedRangeCells {
    public static void main(String[] args) {
        String inputFile = "data/allNamedRanges.xlsx";
        String outputFile = "output/formatNamedRangeCells_result.xlsx";

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load an existing workbook from the specified input file
        workbook.loadFromFile(inputFile);

        // Get the first named range from the workbook
        INamedRange namedRange = workbook.getNameRanges().get(0);

        // Get the range referred to by the named range
        IXLSRange range = namedRange.getRefersToRange();

        // Set the color of the range to yellow
        range.getStyle().setColor(Color.yellow);

        // Set the font of the range to bold
        range.getStyle().getFont().isBold(true);

        // Save the modified workbook to the specified output file using Excel 2010 format
        workbook.saveToFile(outputFile, ExcelVersion.Version2010);

        // Clean up and release resources used by the workbook
        workbook.dispose();
    }
}
