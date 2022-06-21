import com.spire.xls.*;

public class linkToOtherSheetCell {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);
        CellRange range = sheet.getRange().get("A1");
        //Add hyperlink in the range
        HyperLink hyperlink =sheet.getHyperLinks().add(range);
        //Set the link type
        hyperlink.setType(HyperLinkType.Workbook);

        //Set the display text
        hyperlink.setTextToDisplay("Link to Sheet2 cell C5");
        //Set the address
        hyperlink.setAddress( "Sheet2!C5");
        //Save to file
        workbook.saveToFile("output/linkToOtherSheetCell.xlsx", ExcelVersion.Version2010);
        workbook.dispose();
    }
}
