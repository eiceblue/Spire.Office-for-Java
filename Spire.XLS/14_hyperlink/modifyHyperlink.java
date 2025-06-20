import com.spire.xls.*;
import com.spire.xls.collections.HyperLinksCollection;

public class modifyHyperlink {
    public static void main(String[] args) {
        String inputFile = "data/modifyHyperlink.xlsx";
        String outputFile = "output/modifyHyperlink_result.xlsx";

        // Create a new instance of Workbook
        Workbook workbook = new Workbook();

        // Load the workbook from the specified input file
        workbook.loadFromFile(inputFile);

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Get the collection of hyperlinks in the worksheet
        HyperLinksCollection links = sheet.getHyperLinks();

        // Set the text to display for the first hyperlink to "Spire.XLS for JAVA"
        links.get(0).setTextToDisplay("Spire.XLS for JAVA");

        // Set the address of the first hyperlink to "https://www.e-iceblue.com/Introduce/xls-for-java.html"
        links.get(0).setAddress("https://www.e-iceblue.com/Introduce/xls-for-java.html");

        // Save the modified workbook to the specified output file in Excel 2013 format
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);

        // Dispose of the workbook object to release resources
        workbook.dispose();
    }
}
