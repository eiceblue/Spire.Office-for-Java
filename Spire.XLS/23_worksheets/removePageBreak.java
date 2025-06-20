import com.spire.xls.*;

public class removePageBreak {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the Excel file from the specified path
        workbook.loadFromFile("data/pageBreak.xlsx");

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Clear all vertical page breaks in the worksheet
        sheet.getVPageBreaks().clear();

        // Remove the horizontal page break at index 0 in the worksheet
        sheet.getHPageBreaks().removeAt(0);

        // Set the worksheet view mode to Preview
        sheet.setViewMode(ViewMode.Preview);

        // Specify the output file path for saving the modified workbook
        String output = "output/removePageBreak_result.xlsx";

        // Save the workbook to the specified output path in Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Dispose the workbook to release resources
        workbook.dispose();
    }
}
