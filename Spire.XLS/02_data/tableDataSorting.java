import com.spire.xls.*;
import com.spire.xls.core.IListObject;

public class tableDataSorting {
    public static void main(String[] args) {
        String input = "data/CreateTable.xlsx";
        String output = "output/tableDataSorting_output.xlsx";

        //create a Workbook
        Workbook workbook = new Workbook();

        //load the document from disk
        workbook.loadFromFile(input);

        //get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //add a new List Object to the worksheet
        IListObject listObject = sheet.getListObjects().create("table", sheet.getCellRange(1,1,19,5));

        //add default Style to the table
        listObject.setBuiltInTableStyle(TableBuiltInStyles.TableStyleLight9);

        //sorting
        listObject.getAutoFilters().getSorter().getSortColumns().add(2, OrderBy.Ascending);
        listObject.getAutoFilters().getSorter().sort(sheet.getCellRange(1,1,19,5));

        //save to file
        workbook.saveToFile(output);
    }
}
