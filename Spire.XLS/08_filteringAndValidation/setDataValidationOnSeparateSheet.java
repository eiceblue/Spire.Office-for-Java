import com.spire.xls.*;

public class setDataValidationOnSeparateSheet {
    public static void main(String[] args) {
        String input = "data/SetDataValidationOnSeparateSheet.xlsx";
        String output = "output/setDataValidationOnSeparateSheet_output.xlsx";

        //load a woekbook
        Workbook workbook = new Workbook();
        workbook.loadFromFile(input);

        //get the first sheet
        Worksheet sheet1 = workbook.getWorksheets().get(0);

        //get a cellRange
        sheet1.getCellRange("B10").setText("Here is a dataValidation example.");

        //get the second sheet
        Worksheet sheet2 = workbook.getWorksheets().get(1);

        //enable the data can be from different sheet.
        sheet2.getParentWorkbook().setAllow3DRangesInDataValidation(true);
        sheet1.getCellRange("B11").getDataValidation().setDataRange(sheet2.getCellRange("A1:A7"));

        //save the file
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
