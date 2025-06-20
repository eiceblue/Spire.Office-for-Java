import com.spire.xls.*;

public class setSheetFitToPageProperty {
    public static void main(String[] args) {
        String inputFile="data/template_Xls_4.xlsx";
        String outputFile="output/setSheetFitToPageProperty_result.xlsx";

        // Create a new Workbook object
        Workbook workbook = new Workbook();

       // Load the workbook from the specified input file path
        workbook.loadFromFile(inputFile);

       // Get the first worksheet in the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

       // Set the number of pages tall to fit to 1 page
        sheet.getPageSetup().setFitToPagesTall(1);

       // Set the number of pages wide to fit to 1 page
        sheet.getPageSetup().setFitToPagesWide(1);

       // Save the modified workbook to the specified output file path in Excel 2013 format
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);

       // Release any resources used by the workbook
        workbook.dispose();
    }
}
