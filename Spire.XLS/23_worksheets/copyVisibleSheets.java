import com.spire.xls.*;

public class copyVisibleSheets {
    public static void main(String[] args) {
        // Create a new workbook object
        Workbook workbook = new Workbook();

        // Load an existing workbook from the specified file path
        workbook.loadFromFile("data/copyVisibleSheets.xlsx");

        // Create a new workbook object for the copied sheets
        Workbook workbookNew = new Workbook();

        // Set the version of the new workbook to Excel 2013
        workbookNew.setVersion(ExcelVersion.Version2013);

        // Clear any existing worksheets in the new workbook
        workbookNew.getWorksheets().clear();

        // Iterate through each worksheet in the original workbook
        for (Object worksheet : workbook.getWorksheets()) {
            // Convert the object to Worksheet type
            Worksheet sheet = (Worksheet) worksheet;

            // Check if the visibility of the sheet is set to "Visible"
            if (sheet.getVisibility() == WorksheetVisibility.Visible) {
                // Add a copy of the visible sheet to the new workbook
                workbookNew.getWorksheets().addCopy(sheet);
            }
        }

        // Specify the file path for the resulting workbook
        String result = "output/copyVisibleSheets_result.xlsx";

        // Save the new workbook to the specified file path with Excel 2013 format
        workbookNew.saveToFile(result, ExcelVersion.Version2013);

        // Release resources associated with the original workbook
        workbook.dispose();

        // Release resources associated with the new workbook
        workbookNew.dispose();
    }
}
