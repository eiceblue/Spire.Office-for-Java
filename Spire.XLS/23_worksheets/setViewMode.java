import com.spire.xls.*;

public class setViewMode {
    public static void main(String[] args) {
        // Create a new Workbook object.
        Workbook workbook = new Workbook();

        // Load the Excel file from the specified path.
        workbook.loadFromFile("data/setViewMode.xlsx");

        // Get the first worksheet from the workbook and set its view mode to Preview.
        workbook.getWorksheets().get(0).setViewMode(ViewMode.Preview);

        // Specify the output path for the modified workbook.
        String output = "output/setViewMode_result.xlsx";

        // Save the modified workbook to the specified output path in Excel 2013 format.
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Release any resources associated with the workbook.
        workbook.dispose();
    }
}
