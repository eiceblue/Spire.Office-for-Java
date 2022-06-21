import com.spire.xls.*;

public class splitWorksheetIntoPanes {
    public static void main(String[] args) {
        // Create a workbook
        Workbook workbook = new Workbook();

        // Load the document from disk
        workbook.loadFromFile("data/worksheetSample1.xlsx");

        // Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Vertical and horizontal split the worksheet into four panes
        sheet.setFirstVisibleColumn(2);
        sheet.setFirstVisibleRow(5);
        sheet.setVerticalSplit(4000);
        sheet.setHorizontalSplit(5000);

        // Set the active pane
        sheet.setActivePane(1);

        // Save the document
        String output = "output/splitWorksheetIntoPanes_result.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
