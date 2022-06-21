import com.spire.xls.*;

public class foregroundAndBackground {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Create a new style
        CellStyle style = workbook.getStyles().addStyle("newStyle1");

        //Set filling pattern type
        style.getInterior().setFillPattern(ExcelPatternType.VerticalStripe);

        //Set filling Background color
        style.getInterior().getGradient().setBackKnownColor(ExcelColors.Green);

        //Set filling Foreground color
        style.getInterior().getGradient().setForeKnownColor(ExcelColors.Yellow);

        //Apply the style to  "B2" cell
        sheet.getCellRange("B2").setCellStyleName(style.getName());
        sheet.getCellRange("B2").setText("Test");
        sheet.getCellRange("B2").setRowHeight(30);
        sheet.getCellRange("B2").setColumnWidth(50);


        //Create a new style
        style = workbook.getStyles().addStyle("newStyle2");

        //Set filling pattern type
        style.getInterior().setFillPattern(ExcelPatternType.ThinHorizontalStripe);
        //Set filling Foreground color
        style.getInterior().getGradient().setForeKnownColor(ExcelColors.Red);

        //Apply the style to  "B4" cell
        sheet.getCellRange("B4").setCellStyleName(style.getName());
        sheet.getCellRange("B4").setRowHeight(30);
        sheet.getCellRange("B4").setColumnWidth(60);

        String result = "output/ForegroundAndBackground_out.xlsx";

        //Save to file
        workbook.saveToFile(result, ExcelVersion.Version2010);
    }
}
