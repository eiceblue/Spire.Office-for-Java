import com.spire.xls.*;

public class copyWithOptions {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the Excel document from disk
        workbook.loadFromFile("data/Sample.xlsx");

        //Get the first worksheet
        Worksheet sheet1 = workbook.getWorksheets().get(0);

        //Add a new worksheet as destination sheet
        Worksheet destinationSheet = workbook.getWorksheets().add("DestSheet");

        //Specify a copy range of original sheet
        CellRange cellRange = sheet1.getRange().get("B2:D4");

        //Copy the specified range to added worksheet and keep original styles and update reference
        workbook.getWorksheets().get(0).copy(cellRange, destinationSheet, 2, 1, true, true);

        //String for output file
        String outputFile = "output/copyWithOptions_result.xlsx";

        //Save the file
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
