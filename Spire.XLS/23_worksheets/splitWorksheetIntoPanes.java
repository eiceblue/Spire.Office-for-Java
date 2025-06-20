import com.spire.xls.*;

public class splitWorksheetIntoPanes {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load an Excel file from the specified path
        workbook.loadFromFile("data/worksheetSample1.xlsx");

        // Get the first worksheet from the Workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Set the index of the first visible column to 2
        sheet.setFirstVisibleColumn(2);
        // Set the index of the first visible row to 5
        sheet.setFirstVisibleRow(5);
        // Set the vertical split position at 4000th row
        sheet.setVerticalSplit(4000);
        // Set the horizontal split position at 5000th column
        sheet.setHorizontalSplit(5000);

        // Set the active pane to be the bottom right pane (pane 1)
        sheet.setActivePane(1);

        // Specify the output file path for saving the modified Workbook
        String output = "output/splitWorksheetIntoPanes_result.xlsx";
        // Save the Workbook to the specified file path in Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Release any resources used by the Workbook object
        workbook.dispose();
    }
}
