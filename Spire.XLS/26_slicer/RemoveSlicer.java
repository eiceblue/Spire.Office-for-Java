import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.slicer.*;

public class RemoveSlicer {
    public static void main(String[] args) {
        // Create a new Workbook instance
        Workbook wb = new Workbook();

        // Load an existing Excel file from the specified path
        wb.loadFromFile("data/SlicerTemplate.xlsx");

        // Get the first worksheet in the workbook
        Worksheet worksheet = wb.getWorksheets().get(0);

        // Get the slicer collection from the worksheet
        XlsSlicerCollection slicers = worksheet.getSlicers();

        // Example: Remove the first slicer in the collection
        // if (slicers.getCount() > 0) {
        //     slicers.removeAt(0);
        // }
        
        // Clear all slicers from the collection
        slicers.clear();

        // Save the modified workbook to a new file with Excel 2013 version format
        wb.saveToFile("RemoveSlicer.xlsx", ExcelVersion.Version2013);

        // Dispose of the workbook object to release resources
        wb.dispose();
    }
}
