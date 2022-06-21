import com.spire.xls.*;

public class showOrHideGridLine {
    public static void main(String[] args) {
        // Create a workbook
        Workbook workbook = new Workbook();

        // Load the document from disk
        workbook.loadFromFile("data/worksheetSample2.xlsx");

        // Get the first and second worksheet
        Worksheet sheet1 = workbook.getWorksheets().get(0);
        Worksheet sheet2 = workbook.getWorksheets().get(1);

        // Hide grid line in the first worksheet
        sheet1.setGridLinesVisible(false);
        // Show grid line in the first worksheet
        sheet2.setGridLinesVisible(true);

        // Save the document
        String output = "output/showOrHideGridLine_result.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
