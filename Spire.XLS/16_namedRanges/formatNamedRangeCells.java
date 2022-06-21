import com.spire.xls.*;
import com.spire.xls.core.*;

import java.awt.*;

public class formatNamedRangeCells {
    public static void main(String[] args) {
        String inputFile = "data/allNamedRanges.xlsx";
        String outputFile = "output/formatNamedRangeCells_result.xlsx";

        //Create a workbook and load the document from disk
        Workbook workbook = new Workbook();
        workbook.loadFromFile(inputFile);

        //Get specific named range by index
        INamedRange NamedRange = workbook.getNameRanges().get(0);

        //Get the cell range of the named range
        IXLSRange range = NamedRange.getRefersToRange();

        //Set color for the range
        range.getStyle().setColor(Color.yellow);

        //Set the font as bold
        range.getStyle().getFont().isBold(true);

        //Save the file
        workbook.saveToFile(outputFile, ExcelVersion.Version2010);
    }
}
