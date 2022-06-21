import com.spire.xls.*;

public class detectMergedCells {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile( "data/Template_Xls_1.xlsx");

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Get the merged cell ranges in the first worksheet and put them into a CellRange array.
        CellRange[] range = sheet.getMergedCells();

        //Traverse through the array and unmerge the merged cells.
        for(CellRange cell : range){
            cell.unMerge();
        }

        String result = "output/detectMergedCells_result.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
