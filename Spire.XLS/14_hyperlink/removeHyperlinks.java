import com.spire.xls.*;
import com.spire.xls.collections.HyperLinksCollection;

public class removeHyperlinks {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load an existing Excel file from the specified path
        workbook.loadFromFile("data/HyperlinksSample1.xlsx");

        // Get the first worksheet from the Workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Get the collection of hyperlinks in the worksheet
        HyperLinksCollection links = sheet.getHyperLinks();

        // Clear the contents and formatting of cells B1, B2, and B3
        sheet.getCellRange("B1").clearAll();
        sheet.getCellRange("B2").clearAll();
        sheet.getCellRange("B3").clearAll();

        // Remove the hyperlinks at index 0, 0, and 0 from the HyperLinksCollection
        sheet.getHyperLinks().removeAt(0);
        sheet.getHyperLinks().removeAt(0);
        sheet.getHyperLinks().removeAt(0);

        // Specify the output file path for saving the modified Workbook
        String output = "output/RemoveHyperlinks_out.xlsx";

        // Save the Workbook to the specified output file path in Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        // Clean up system resources by disposing of the Workbook object
        workbook.dispose();
    }
}
