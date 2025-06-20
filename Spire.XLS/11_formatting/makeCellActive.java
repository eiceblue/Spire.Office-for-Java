import com.spire.xls.*;

public class makeCellActive {
    public static void main(String[] args) {
        String inputFile="data/templateAz.xlsx";
        String outputFile = "output/makeCellActive_result.xlsx";

        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the workbook from the input file
        workbook.loadFromFile(inputFile);

        // Get the second worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(1);

        // Activate the worksheet
        sheet.activate();

        // Set the active cell to cell range "B2"
        sheet.setActiveCell(sheet.getCellRange("B2"));

        // Set the first visible column to column index 1
        sheet.setFirstVisibleColumn(1);

        // Set the first visible row to row index 1
        sheet.setFirstVisibleRow(1);

        // Save the modified workbook to the output file in Excel 2013 format
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);

        //Release the resources used by the workbook
        workbook.dispose();
    }
}
