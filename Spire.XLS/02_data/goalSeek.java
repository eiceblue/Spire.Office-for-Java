import com.spire.xls.*;

public class goalSeek {
    public static void main(String[] args) throws Exception {
        //create a workbook.
        Workbook workbook = new Workbook();

        //get the first worksheet.
        Worksheet worksheet = workbook.getWorksheets().get(0);

        //set value
        worksheet.getRange().get("A1").setValue("100");

        //target cell
        CellRange targetCell = worksheet.getCellRange("A2");
        targetCell.setFormula("=SUM(A1+B1)");

        //variable cell
        CellRange gussCell = worksheet.getCellRange("B1");

        //trial solution
        com.spire.xls.GoalSeek goalSeek = new com.spire.xls.GoalSeek();
        GoalSeekResult result = goalSeek.TryCalculate(targetCell, 500, gussCell);

        //determine the solution
        result.Determine();

        //save the file
        workbook.saveToFile("GoalSeek.xlsx", ExcelVersion.Version2013);

    }
}
