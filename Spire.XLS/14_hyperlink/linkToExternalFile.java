import com.spire.xls.*;

public class linkToExternalFile {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);
        CellRange range = sheet.getRange().get(1, 1);
        //Add hyperlink in the range
        HyperLink hyperlink = sheet.getHyperLinks().add(range);
        //Set the link type
        hyperlink.setType(HyperLinkType.File);
        //Set the display text
        hyperlink.setTextToDisplay("Link To External File");

        //Set file address
        hyperlink.setAddress( "data/AddDataTable.xlsx");
        //Save to file
        workbook.saveToFile("output/result.xlsx", ExcelVersion.Version2010);
        workbook.dispose();
    }
}
