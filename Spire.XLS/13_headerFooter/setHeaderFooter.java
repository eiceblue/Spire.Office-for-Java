import com.spire.xls.*;

public class setHeaderFooter {
    public static void main(String[] args) {
        String inputFile = "data/headerFooterSample.xlsx";
        String outputFile = "output/setHeaderFooter_result.xlsx";

        // Create a new Workbook object
        Workbook workbook= new Workbook();
        // Load the Excel file from the specified path
        workbook.loadFromFile(inputFile);

        // Get the first worksheet from the Workbook
        Worksheet Worksheet = workbook.getWorksheets().get(0);

        // Set the left header of the page to a specific text with a specific font
        Worksheet.getPageSetup().setLeftHeader("&\"Arial Unicode MS\"&14 Spire.XLS for .NET ");

        // Set the center footer of the page to a specific text
        Worksheet.getPageSetup().setCenterFooter("Footer Text");

        // Set the view mode of the worksheet to layout
        Worksheet.setViewMode(ViewMode.Layout);

        // Save the Workbook object to the specified file path in Excel 2010 format
        workbook.saveToFile(outputFile, ExcelVersion.Version2010);

        // Release the resources used by the workbook
        workbook.dispose();
    }
}
