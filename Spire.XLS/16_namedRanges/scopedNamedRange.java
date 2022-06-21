import com.spire.xls.*;
import com.spire.xls.core.INamedRange;

public class scopedNamedRange {
    public static void main(String[] args) {
        String inputFile="data/scopedNamedRange.xlsx";
        String outputFile="output/scopedNamedRange_result.xlsx";

        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the Excel document from disk
        workbook.loadFromFile(inputFile);

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Add range name
        INamedRange namedRange = sheet.getNames().add("Range1");

        //Define the range
        namedRange.setRefersToRange(sheet.getCellRange("A1:D19"));

        //Save the file
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
