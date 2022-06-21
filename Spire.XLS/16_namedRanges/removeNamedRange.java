import com.spire.xls.*;

public class removeNamedRange {
    public static void main(String[] args) {
        String inputFile="data/allNamedRanges.xlsx";
        String outputFile="output/removeNamedRange_result.xlsx";

        //Create a workbook and load the document from disk
        Workbook workbook = new Workbook();
        workbook.loadFromFile(inputFile);

        //Remove the named range by index
        workbook.getNameRanges().removeAt(0);

        //Remove the named range by name
        workbook.getNameRanges().remove("NameRange2");

        //Save the file
        workbook.saveToFile(outputFile, ExcelVersion.Version2010);
    }
}
