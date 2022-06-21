import com.spire.xls.*;

public class autoFitBasedOnCellValue {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Get first worksheet of the workbook
        Worksheet worksheet = workbook.getWorksheets().get(0);

        //Set value for B8
        CellRange cell = worksheet.getRange().get("B8");
        cell.setText("Welcome to Spire.XLS!");

        //Set the cell style
        CellStyle style = cell.getCellStyle();
        style.getFont().setSize(16);
        style.getFont().isBold(true);

        //Auto fit column width and row height based on cell value
        cell.autoFitColumns();
        cell.autoFitRows();

        //String for output file
        String outputFile = "output/autoFitBasedOnCellValue_result.xlsx";

        //Save the file
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}