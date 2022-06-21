import java.awt.*;

import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.shapes.*;

public class setFontAndBackground {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the file from disk
        workbook.loadFromFile("data/template_Xls_5.xlsx");

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Get the textbox which will be edited
        XlsTextBoxShape shape = (XlsTextBoxShape) sheet.getTextBoxes().get(0);

        //Set the font and background color for the textbox
        //Set font
        ExcelFont font = workbook.createFont();
        //font.isStrikethrough(true);
        font.setFontName("Century Gothic");
        font.setSize(10);
        font.isBold(true);
        font.setColor(Color.blue);
        (new RichText(shape.getRichText())).setFont(0, shape.getText().length() - 1, font);

        //Set background color
        shape.getFill().setFillType(ShapeFillType.SolidColor);
        shape.getFill().setForeKnownColor(ExcelColors.BlueGray);

        String result = "output/setFontAndBackgroundForTextBox_result.xlsx";

        //Save to file
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
