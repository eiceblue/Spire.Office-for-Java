import com.spire.xls.*;

public class linkToExternalFile {
    public static void main(String[] args) {
        // Create a new instance of Workbook
        Workbook workbook = new Workbook();

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Get the cell range at row 1, column 1 (A1)
        CellRange range = sheet.getRange().get(1, 1);

        // Add a hyperlink to the cell range
        HyperLink hyperlink = sheet.getHyperLinks().add(range);

        // Set the type of the hyperlink to File
        hyperlink.setType(HyperLinkType.File);

        // Set the text to display for the hyperlink
        hyperlink.setTextToDisplay("Link To External File");

        // Set the file address for the hyperlink
        hyperlink.setAddress("data/AddDataTable.xlsx");

        // Save the modified workbook to "output/result.xlsx" in Excel 2010 format
        workbook.saveToFile("output/result.xlsx", ExcelVersion.Version2010);

        // Dispose of the workbook object to release resources
        workbook.dispose();
    }
}
