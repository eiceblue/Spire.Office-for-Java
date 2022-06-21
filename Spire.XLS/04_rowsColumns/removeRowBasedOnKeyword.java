import com.spire.xls.*;

public class removeRowBasedOnKeyword {
    public static void main(String[] args) {
        String inputFile = "data/WorkbookToHTML.xlsx";

        //Create a workbook
        Workbook workbook = new Workbook();

        //Load a file
        workbook.loadFromFile(inputFile);

        Worksheet sheet  = workbook.getWorksheets().get(0);

        //Find the string
        CellRange cr = sheet.findString("Address", false, false);

        //Delete the row which includes the string
        sheet.deleteRow(cr.getRow());

        //Save the document
        String output = "output/removeRowBasedOnKeyword.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
