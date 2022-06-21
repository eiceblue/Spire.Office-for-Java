import com.spire.xls.*;

import java.awt.*;

public class cloneExcelFontStyle {
    public static void main(String[] args) {
       //Create a workbook.
        Workbook workbook = new Workbook();

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Add the text to the Excel sheet cell range A1.
        sheet.get("A1").setText("Text1");

        //Set A1 cell range's CellStyle.
        CellStyle style = workbook.getStyles().addStyle("style");
        style.getFont().setFontName("Calibri");
        style.getFont().setColor(Color.red);
        style.getFont().setSize(12);
        style.getFont().isBold(true);
        style.getFont().isItalic(true);
        sheet.get("A1").setCellStyleName(style.getName());

        //Clone the same style for B2 cell range.
        CellStyle csO1 = style.clone();
        sheet.get("B2").setText("Text2");
        sheet.get("B2").setCellStyleName(csO1.getName());

        //Clone the same style for C3 cell range and then reset the font color for the text.
        CellStyle csGreen = style.clone();
        csGreen.getFont().setColor(Color.green);
        sheet.get("C3").setText("Text3");
        sheet.get("C3").setCellStyleName(csGreen.getName());

        String result = "output/cloneExcelFontStyle_result.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
