import com.spire.xls.*;
import com.spire.xls.core.*;

import java.awt.*;

public class applySubscriptAndSuperscript {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        sheet.get("B2").setText("This is an example of Subscript:");
        sheet.get("D2").setText("This is an example of Superscript:");

        //Set the rtf value of "B3" to "R100-0.06".
        IXLSRange range = sheet.get("B3");
        range.getRichText().setText("R100-0.06");

        //Create a font. Set the IsSubscript property of the font to "true".
        ExcelFont font = workbook.createFont();
        font.isSubscript(true);
        font.setColor(Color.green);

        //Set font for specified range of the text in "B3".
        range.getRichText().setFont(4, 8, font);

        //Set the rtf value of "D3" to "a2 + b2 = c2".
        range = sheet.get("D3");
        range.getRichText().setText("a2 + b2 = c2");

        //Create a font. Set the IsSuperscript property of the font to "true".
        font = workbook.createFont();
        font.isSuperscript(true);

        //Set font for specified range of the text in "D3".
        range.getRichText().setFont(1, 1, font);
        range.getRichText().setFont(6, 6, font);
        range.getRichText().setFont(11, 11, font);

        sheet.getAllocatedRange().autoFitColumns();

        String result = "output/applySubscriptAndSuperscript_result.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);

    }
}
