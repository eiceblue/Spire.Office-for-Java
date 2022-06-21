import com.spire.xls.*;
import com.spire.xls.core.*;

public class namedRanges {
    public static void main(String[] args) {
        String inputFile="data/namedRanges.xlsx";
        String outputFile="output/namedRanges_result.xlsx";

        //Create a workbook and load the document from disk
        Workbook workbook = new Workbook();
        workbook.loadFromFile(inputFile);

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Create a named range
        INamedRange NamedRange = workbook.getNameRanges().add("NewNamedRange");

        //Set the range of the named range
        NamedRange.setRefersToRange(sheet.getCellRange("A8:E12"));

        //Save to document
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
