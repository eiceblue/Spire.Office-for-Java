import com.spire.xls.*;

public class pageBreakPreview {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load the Excel file from the specified path
        workbook.loadFromFile("data/template_Xls_4.xlsx");

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Set the zoom scale for page break preview to 80%
        sheet.setZoomScalePageBreakView(80);

        // Specify the output file path for saving the modified workbook
        String result = "output/pageBreakPreview_result.xlsx";

        // Save the workbook to the specified output path in Excel 2013 format
        workbook.saveToFile(result, ExcelVersion.Version2013);

        // Dispose the workbook to release resources
        workbook.dispose();
    }
}
