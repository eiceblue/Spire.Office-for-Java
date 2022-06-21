import com.spire.xls.*;

public class setDBNumFormatting {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        workbook.createEmptySheets(1);

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Set value for cells
        sheet.getRange().get("A1").setNumberValue(123);
        sheet.getRange().get("A2").setNumberValue(456);
        sheet.getRange().get("A3").setNumberValue(789);

        //Get the cell range
        CellRange range = sheet.getRange().get("A1:A3");

        //Set the DB num format
        range.setNumberFormat("[DBNum2][$-804]General");

        //Auto fit columns
        range.autoFitColumns();

        //Save the document
        String output = "output/setDBNumFormatting_result.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
