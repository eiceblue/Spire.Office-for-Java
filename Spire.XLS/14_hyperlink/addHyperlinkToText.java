import com.spire.xls.*;

public class addHyperlinkToText {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/CommonTemplate1.xlsx");

        //Get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Add url link
        HyperLink UrlLink = sheet.getHyperLinks().add(sheet.getCellRange("D10"));
        UrlLink.setTextToDisplay(sheet.getCellRange("D10").getText());
        UrlLink.setType(HyperLinkType.Url);
        UrlLink.setAddress("http://en.wikipedia.org/wiki/Chicago");

        //Add email link
        HyperLink MailLink = sheet.getHyperLinks().add(sheet.getCellRange("E10"));
        MailLink.setTextToDisplay(sheet.getCellRange("E10").getText());
        MailLink.setType(HyperLinkType.Url);
        MailLink.setAddress("mailto:Nancy.Aqua@gmail.com");
        //Save to file
        workbook.saveToFile("output/addHyperlinkToText.xlsx", ExcelVersion.Version2010);
        workbook.dispose();
    }
}
