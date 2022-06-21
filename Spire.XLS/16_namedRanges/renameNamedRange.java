import com.spire.xls.*;

public class renameNamedRange {
    public static void main(String[] args) {
        String inputFile="data/allNamedRanges.xlsx";
        String outputFile="output/renameNamedRange_result.xlsx";

        //Create a workbook and load the document from disk
        Workbook workbook = new Workbook();
        workbook.loadFromFile(inputFile);

        //Rename the named range
        workbook.getNameRanges().get(0).setName("RenameRange");

        //Save the file
        workbook.saveToFile(outputFile, ExcelVersion.Version2010);
    }
}
