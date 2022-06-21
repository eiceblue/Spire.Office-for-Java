import com.spire.xls.*;
import com.spire.xls.core.*;

public class mergeNamedRangeCells {
    public static void main(String[] args) {
        String inputFile="data/allNamedRanges.xlsx";
        String outputFile="output/mergeNamedRangeCells_result.xlsx";

        //Create a workbook and load the document from disk
        Workbook workbook = new Workbook();
        workbook.loadFromFile(inputFile);

        //Get specific named range by index
        INamedRange NamedRange = workbook.getNameRanges().get(0);

        //Get the range of the named range
        IXLSRange range = NamedRange.getRefersToRange();

        //Merge cells
        range.merge();

        //Save the file
        workbook.saveToFile(outputFile, ExcelVersion.Version2010);
    }
}
