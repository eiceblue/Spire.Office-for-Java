import com.spire.xls.*;

public class copyWorksheet {
    public static void main(String[] args) {
        //Create a workbook
        Workbook sourceWorkbook = new Workbook();

        //Load the source Excel document from disk
        sourceWorkbook.loadFromFile("data/readImages.xlsx");

        //Get the first worksheet
        Worksheet srcWorksheet = sourceWorkbook.getWorksheets().get(0);

        //Create a workbook
        Workbook targetWorkbook = new Workbook();

        //Load the target Excel document from disk
        targetWorkbook.loadFromFile("data/sample.xlsx");

        //Add a new worksheet
        Worksheet targetWorksheet = targetWorkbook.getWorksheets().add("added");

        //Copy the first worksheet of source Excel document to the new added worksheet of target Excel document
        targetWorksheet.copyFrom(srcWorksheet);

        //String for output file 
        String outputFile = "output/copyWorksheet_result.xlsx";

        //Save the file
        targetWorkbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
