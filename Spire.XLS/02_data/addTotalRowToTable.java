import com.spire.xls.*;
import com.spire.xls.core.IListObject;

public class addTotalRowToTable {
    public static void main(String[] args) {
         //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile("data/AddATotalRowToTable.xlsx");

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Create a table with the data from the specific cell range.
        IListObject table = sheet.getListObjects().create("Table", sheet.get("A1:D4"));

        //Display total row.
        table.setDisplayTotalRow(true);

        //Add a total row.
        table.getColumns().get(0).setTotalsRowLabel("Total");
        table.getColumns().get(1).setTotalsCalculation(ExcelTotalsCalculation.Sum);
        table.getColumns().get(2).setTotalsCalculation(ExcelTotalsCalculation.Sum);
        table.getColumns().get(3).setTotalsCalculation(ExcelTotalsCalculation.Sum);

        String result = "output/addATotalRowToTable_result.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);

    }
}
