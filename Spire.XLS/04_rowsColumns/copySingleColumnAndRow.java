import com.spire.xls.*;

public class copySingleColumnAndRow {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the Excel document from disk
        workbook.loadFromFile("data/CreateTable.xlsx");

        //Get the first worksheet
        Worksheet sheet1 = workbook.getWorksheets().get(0);

        //Specify a destination range to copy one column
        CellRange columnCells = sheet1.getRange().get("G1:G19");

        //Copy the second column to destination range
        sheet1.getColumns()[1].copy(columnCells);

        //Specify a destination range to copy one row
        CellRange rowCells = sheet1.getRange().get("A21:E21");

        //Copy the first row to destination range
        sheet1.getRows()[0].copy(rowCells);

        //String for output file
        String outputFile = "output/copySingleColumnAndRow_output.xlsx";

        //Save the file
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
