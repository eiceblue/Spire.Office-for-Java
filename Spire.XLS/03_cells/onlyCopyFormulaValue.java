import com.spire.xls.*;

import java.util.EnumSet;

public class onlyCopyFormulaValue {
    public static void main(String[] args) {
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/CopyOnlyFormulaValue.xlsx");

        Worksheet sheet = workbook.getWorksheets().get(0);
        CopyRangeOptions copyOptions = CopyRangeOptions.OnlyCopyFormulaValue;
        CellRange sourceRange = sheet.getCellRange("A6:E6");
        sheet.copy(sourceRange, sheet.getCellRange("A8:E8"), EnumSet.of(copyOptions));


        sourceRange.copy(sheet.getCellRange("A10:E10"), EnumSet.of(copyOptions));

        workbook.saveToFile("output/onlyCopyFormulaValue_result.xlsx", ExcelVersion.Version2010);
    }
}
