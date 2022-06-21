import com.spire.xls.*;

public class unmergeCells {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile("data/Template_Xls_1.xlsx");

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Unmerge the cells.
        sheet.getRange().get("F2").unMerge();

        //Unmerge the cells.
        sheet.getRange().get("F7").unMerge();

        String result = "output/unmergeCells_result.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);

    }
}
