import com.spire.xls.*;

public class addHyperlinkToText {
    public static void main(String[] args) {
        // Create a new instance of Workbook
        Workbook workbook = new Workbook();

        // Load the Excel file from the specified path
        workbook.loadFromFile("data/CommonTemplate1.xlsx");

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Add a hyperlink to a cell range (D10) in the worksheet
        HyperLink UrlLink = sheet.getHyperLinks().add(sheet.getCellRange("D10"));

        // Set the display text for the hyperlink using the text in cell D10
        UrlLink.setTextToDisplay(sheet.getCellRange("D10").getText());

        // Set the type of the hyperlink to URL
        UrlLink.setType(HyperLinkType.Url);

        // Set the URL address for the hyperlink
        UrlLink.setAddress("http://en.wikipedia.org/wiki/Chicago");

        // Add another hyperlink to a different cell range (E10) in the worksheet
        HyperLink MailLink = sheet.getHyperLinks().add(sheet.getCellRange("E10"));

        // Set the display text for the hyperlink using the text in cell E10
        MailLink.setTextToDisplay(sheet.getCellRange("E10").getText());

        // Set the type of the hyperlink to URL
        MailLink.setType(HyperLinkType.Url);

        // Set the email address for the hyperlink
        MailLink.setAddress("mailto:Nancy.Aqua@gmail.com");

        // Save the modified workbook to a new file
        workbook.saveToFile("output/addHyperlinkToText.xlsx", ExcelVersion.Version2010);

        // Dispose of the workbook object to release resources
        workbook.dispose();
    }
}
