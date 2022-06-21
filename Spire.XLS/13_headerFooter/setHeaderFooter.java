import com.spire.xls.*;

public class setHeaderFooter {
    public static void main(String[] args) {
        String inputFile = "data/headerFooterSample.xlsx";
        String outputFile = "output/setHeaderFooter_result.xlsx";

        //Load a Workbook from disk
        Workbook workbook= new Workbook();
        workbook.loadFromFile(inputFile);

        //Get the first worksheet
        Worksheet Worksheet = workbook.getWorksheets().get(0);

        //Set left header,"Arial Unicode MS" is font name, "18" is font size.
        Worksheet.getPageSetup().setLeftHeader("&\"Arial Unicode MS\"&14 Spire.XLS for .NET ");

        //Set center footer
        Worksheet.getPageSetup().setCenterFooter("Footer Text");

        //Set the view mode as layout
        Worksheet.setViewMode(ViewMode.Layout);

        //Save the Excel file
        workbook.saveToFile(outputFile, ExcelVersion.Version2010);
    }
}
