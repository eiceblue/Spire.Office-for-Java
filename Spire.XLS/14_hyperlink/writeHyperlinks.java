import com.spire.xls.*;

public class writeHyperlinks {
    public static void main(String[] args) {
        String inputFile = "data/writeHyperlinks.xlsx";
        String outputFile = "output/writeHyperlinks_result.xlsx";

        // Create a new instance of Workbook
        Workbook workbook = new Workbook();

        // Load the workbook from the specified input file
        workbook.loadFromFile(inputFile);

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Set the text of cell B9 to "Home page"
        sheet.getCellRange("B9").setText("Home page");

        // Add a hyperlink to cell B10 with the address "http://www.e-iceblue.com"
        HyperLink hylink1 = sheet.getHyperLinks().add(sheet.getCellRange("B10"));
        hylink1.setAddress("http://www.e-iceblue.com");

        // Set the text of cell B11 to "Support"
        sheet.getCellRange("B11").setText("Support");

        // Add a hyperlink to cell B12 with the email address "support@e-iceblue.com"
        HyperLink hylink2 = sheet.getHyperLinks().add(sheet.getCellRange("B12"));
        hylink2.setAddress("mailto:support@e-iceblue.com");

        // Set the text of cell B13 to "Forum"
        sheet.getCellRange("B13").setText("Forum");

        // Add a hyperlink to cell B14 with the address "https://www.e-iceblue.com/forum/"
        HyperLink hylink3 = sheet.getHyperLinks().add(sheet.getCellRange("B14"));
        hylink3.setAddress("https://www.e-iceblue.com/forum/");

        // Save the modified workbook to the specified output file in Excel 2013 format
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);

        // Dispose of the workbook object to release resources
        workbook.dispose();
    }
}
