import com.spire.xls.*;

public class writeHyperlinks {
    public static void main(String[] args) {
        String inputFile = "data/writeHyperlinks.xlsx";
        String outputFile = "output/writeHyperlinks_result.xlsx";

        //Open Excel document
        Workbook workbook = new Workbook();
        workbook.loadFromFile(inputFile);

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Add text in B9
        sheet.getCellRange("B9").setText("Home page");

        //Add the first hyperlink in B10
        HyperLink hylink1 = sheet.getHyperLinks().add(sheet.getCellRange("B10"));
        hylink1.setAddress("http://www.e-iceblue.com");

        //Add text in B11
        sheet.getCellRange("B11").setText("Support");

        //Add the second hyperlink in B12
        HyperLink hylink2 = sheet.getHyperLinks().add(sheet.getCellRange("B12"));
        hylink2.setAddress("mailto:support@e-iceblue.com");

        //Add text in B13
        sheet.getCellRange("B13").setText("Forum");

        //Add the third hyperlink in B14
        HyperLink hylink3 = sheet.getHyperLinks().add(sheet.getCellRange("B14"));
        hylink3.setAddress("https://www.e-iceblue.com/forum/");

        //Save a file
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
