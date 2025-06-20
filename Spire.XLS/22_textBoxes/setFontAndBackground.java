import java.awt.*;
import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.shapes.*;

public class setFontAndBackground {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load an existing Excel file from the specified path
        workbook.loadFromFile("data/template_Xls_5.xlsx");

        // Get the first Worksheet from the Workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Get the TextBox shape at index 0 from the Worksheet
        XlsTextBoxShape shape = (XlsTextBoxShape) sheet.getTextBoxes().get(0);

        // Create a new ExcelFont object
        ExcelFont font = workbook.createFont();

        // Set the font properties
        font.setFontName("Century Gothic");
        font.setSize(10);
        font.isBold(true);
        font.setColor(Color.blue);

        // Apply the font to the text within the TextBox shape
        (new RichText(shape.getRichText())).setFont(0, shape.getText().length() - 1, font);

        // Set the fill type of the TextBox shape to SolidColor
        shape.getFill().setFillType(ShapeFillType.SolidColor);

        // Set the foreground color of the TextBox shape to BlueGray
        shape.getFill().setForeKnownColor(ExcelColors.BlueGray);

        // Specify the output file path
        String result = "output/setFontAndBackgroundForTextBox_result.xlsx";

        // Save the modified Workbook to a new file in Excel 2013 format
        workbook.saveToFile(result, ExcelVersion.Version2013);

        // Dispose the Workbook object
        workbook.dispose();
    }
}
