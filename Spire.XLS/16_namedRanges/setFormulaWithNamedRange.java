import com.spire.xls.*;
import com.spire.xls.core.INamedRange;

public class setFormulaWithNamedRange {
    public static void main(String[] args) {
        String inputFile="data/setFormulaWithNamedRange.xlsx";
        String outputFile="output/setFormulaWithNamedRange_result.xlsx";

        //Create a workbook
        Workbook workbook = new Workbook();

        //Create an empty sheet
        workbook.loadFromFile(inputFile);

        //Get the sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Create a named range
        INamedRange NamedRange = workbook.getNameRanges().add("MyNamedRange");
        //Refers to range
        NamedRange.setRefersToRange(sheet.getCellRange("B10:B12"));

        //Set the formula of range to named range
        sheet.getCellRange("B13").setFormula("=SUM(MyNamedRange)");

        //Set value of ranges
        sheet.getCellRange("B10").setNumberValue(10);
        sheet.getCellRange("B11").setNumberValue(20);
        sheet.getCellRange("B12").setNumberValue(30);

        //Save the Excel file
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}