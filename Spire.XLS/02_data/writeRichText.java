import com.spire.xls.*;

public class writeRichText {
    public static void main(String[] args) {
        //Create a workbook and load file
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/WriteRichText.xlsx");
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Create font
        ExcelFont fontBold = workbook.createFont();
        fontBold.isBold(true);

        ExcelFont fontUnderline = workbook.createFont();
        fontUnderline.setUnderline(FontUnderlineType.Single);

        ExcelFont fontItalic = workbook.createFont();
        fontItalic.isItalic(true);

        ExcelFont fontColor = workbook.createFont();
        fontColor.setKnownColor(ExcelColors.Green);

        //Set rich text format
        RichText richText = sheet.getCellRange("B11").getRichText();
        richText.setText("Bold and underlined and italic and colored text.");
        richText.setFont(0,3,fontBold);
        richText.setFont(9,18,fontUnderline);
        richText.setFont(24, 29, fontItalic);
        richText.setFont(35,41,fontColor);

        //Save to file
        workbook.saveToFile("output/writeRichText_result.xlsx",ExcelVersion.Version2013);
    }
}
