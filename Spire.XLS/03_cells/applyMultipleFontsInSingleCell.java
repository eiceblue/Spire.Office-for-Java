import com.spire.xls.*;

public class applyMultipleFontsInSingleCell {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Create a font object in workbook, setting the font color, size and type.
        ExcelFont font1 = workbook.createFont();
        font1.setKnownColor(ExcelColors.LightBlue);
        font1.isBold(true);
        font1.setSize(10);

        //Create another font object specifying its properties.
        ExcelFont font2 = workbook.createFont();
        font2.setKnownColor(ExcelColors.Red);
        font2.isBold(true);
        font2.isItalic(true);
        font2.setFontName("Times New Roman");
        font2.setSize(11);

        //Write a RichText string to the cell 'A1', and set the font for it.
        RichText richText = sheet.getRange().get("B5").getRichText();
        richText.setText("This document was created with Spire.XLS for Java.");
        richText.setFont(0, 29, font1);
        richText.setFont(31, 48, font2);

        String result = "output/applyMultipleFontsInSingleCell_result.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
