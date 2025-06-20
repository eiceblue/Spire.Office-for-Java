import com.spire.xls.*;

public class linkToOtherSheetCell {
    public static void main(String[] args) {
        // Create a new instance of Workbook
        Workbook workbook = new Workbook();

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Get the cell range A1 in the worksheet
        CellRange range = sheet.getRange().get("A1");

        // Add a hyperlink to the cell range A1
        HyperLink hyperlink = sheet.getHyperLinks().add(range);

        // Set the type of the hyperlink to Workbook
        hyperlink.setType(HyperLinkType.Workbook);

        // Set the text to display for the hyperlink as "Link to Sheet2 cell C5"
        hyperlink.setTextToDisplay("Link to Sheet2 cell C5");

        // Set the address of the hyperlink to "Sheet2!C5" to link to cell C5 in Sheet2
        hyperlink.setAddress("Sheet2!C5");

        // Save the modified workbook to the file "output/linkToOtherSheetCell.xlsx" in Excel 2010 format
        workbook.saveToFile("output/linkToOtherSheetCell.xlsx", ExcelVersion.Version2010);

        // Dispose of the workbook object to release resources
        workbook.dispose();
    }
}
