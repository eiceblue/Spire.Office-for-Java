import com.spire.xls.*;

public class copyCellsRange {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the Excel document from disk
        workbook.loadFromFile("data/CreateTable.xlsx");

        //Get the first worksheet
        Worksheet sheet1 = workbook.getWorksheets().get(0);

        //Specify a destination range
        CellRange cells = sheet1.getRange().get("G1:H19");

        //Copy the selected range to destination range
        sheet1.getRange().get("B1:C19").copy(cells);

        //String for output file
        String outputFile = "output/copyCellsRange_result.xlsx";

        //Save the file
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
