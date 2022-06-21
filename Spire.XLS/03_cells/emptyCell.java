import com.spire.xls.*;

public class emptyCell {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile( "data/Template_Xls_1.xlsx");

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Set the value as null to remove the original content from the Excel Cell.
        sheet.getRange().get("C6").setValue("");

        //Clear the content to remove the original content from the Excel Cell.
        sheet.getRange().get("B6").clearContents();

        //Remove the contents with format from the Excel cell.
        sheet.getRange().get("D6").clearAll();

        String result = "output/emptyCell_result.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
