import com.spire.xls.*;

public class cutCellsToOtherPosition {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile( "data/SampleB_2.xlsx");

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        CellRange Ori = sheet.getRange().get("A1:C5");
        CellRange Dest = sheet.getRange().get("A26:C30");

        //Copy the range to other position
        sheet.copy(Ori, Dest, true, true, true);

        //Remove all content in original cells
        for(CellRange cr : Ori.getCellList()) {
            cr.clearAll();
        }

        //Save and launch result file
        String result = "output/cutCellsToOtherPosition_result.xlsx";
        workbook.saveToFile(result, ExcelVersion.Version2010);
    }
}
