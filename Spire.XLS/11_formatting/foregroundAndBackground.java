import com.spire.xls.*;

public class foregroundAndBackground {
    public static void main(String[] args) {
        // Create a new workbook
        Workbook workbook = new Workbook();

        //Get the first worksheet in the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Add a new cell style named "newStyle1"
        CellStyle style = workbook.getStyles().addStyle("newStyle1");

        //Set the fill pattern of the interior to vertical stripes
        style.getInterior().setFillPattern(ExcelPatternType.VerticalStripe);

        //Set the background color of the gradient to green
        style.getInterior().getGradient().setBackKnownColor(ExcelColors.Green);

        //Set the foreground color of the gradient to yellow
        style.getInterior().getGradient().setForeKnownColor(ExcelColors.Yellow);

        //Apply the "newStyle1" cell style to cell B2
        sheet.getCellRange("B2").setCellStyleName(style.getName());

        //Set the text of cell B2 to "Test"
        sheet.getCellRange("B2").setText("Test");
        //Set the row height of cell B2 to 30
        sheet.getCellRange("B2").setRowHeight(30);
        //Set the column width of cell B2 to 50
        sheet.getCellRange("B2").setColumnWidth(50);


        //Add a new cell style named "newStyle2"
        style = workbook.getStyles().addStyle("newStyle2");

        //Set the fill pattern of the interior to thin horizontal stripes
        style.getInterior().setFillPattern(ExcelPatternType.ThinHorizontalStripe);
        //Set the foreground color of the gradient to red
        style.getInterior().getGradient().setForeKnownColor(ExcelColors.Red);

        //Apply the "newStyle2" cell style to cell B4
        sheet.getCellRange("B4").setCellStyleName(style.getName());
        //Set the row height of cell B4 to 30
        sheet.getCellRange("B4").setRowHeight(30);
        //Set the column width of cell B4 to 60
        sheet.getCellRange("B4").setColumnWidth(60);

        String result = "output/ForegroundAndBackground_out.xlsx";

        //Save the modified workbook to a new file named "ForegroundAndBackground_out.xlsx" using Excel 2010 format
        workbook.saveToFile(result, ExcelVersion.Version2010);

        //Release the resources used by the workbook
        workbook.dispose();
    }
}
