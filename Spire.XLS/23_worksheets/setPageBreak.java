import com.spire.xls.*;

public class setPageBreak {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the Excel file from the specified path
        workbook.loadFromFile("data/worksheetSample1.xlsx");

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Add horizontal page breaks at specific cell ranges in the worksheet
        sheet.getHPageBreaks().add(sheet.getRange().get("A8"));
        sheet.getHPageBreaks().add(sheet.getRange().get("A14"));

        // Uncomment the following lines to add vertical page breaks at specific cell ranges in the worksheet
        //sheet.getVPageBreaks().add(sheet.getRange().get("B1"));
        //sheet.getVPageBreaks().add(sheet.getRange().get("C1"));

        // Set the view mode of the first worksheet to Preview
        workbook.getWorksheets().get(0).setViewMode(ViewMode.Preview);

        // Specify the output file path for saving the modified workbook
        String output = "output/setPageBreak_result.xlsx";

        // Save the workbook to the specified output path in Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Dispose the workbook to release resources
        workbook.dispose();
    }
}
