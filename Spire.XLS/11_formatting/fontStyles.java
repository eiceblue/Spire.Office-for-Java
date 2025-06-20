import com.spire.xls.*;
import java.awt.*;

public class fontStyles {
    public static void main(String[] args) throws Exception {
        String input = "data/FontStyles.xlsx";
        String output = "output/fontStyles_output.xlsx";

        //Create a new workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile(input);

        //Get the first worksheet in the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Set the font name for cell B1 to "Comic Sans MS"
        sheet.getCellRange("B1").getCellStyle().getExcelFont().setFontName("Comic Sans MS");
        //Set the font name for cells B2 to D2 to "Corbel"
        sheet.getCellRange("B2:D2").getCellStyle().getExcelFont().setFontName("Corbel");
        //Set the font name for cells B3 to D7 to "Aleo"
        sheet.getCellRange("B3:D7").getCellStyle().getExcelFont().setFontName("Aleo");

        //Set the font size for cell B1 to 45
        sheet.getCellRange("B1").getCellStyle().getExcelFont().setSize(45);
        //Set the font size for cells B2 to D3 to 25
        sheet.getCellRange("B2:D3").getCellStyle().getExcelFont().setSize(25);
        //Set the font size for cells B3 to D7 to 12
        sheet.getCellRange("B3:D7").getCellStyle().getExcelFont().setSize(12);

        //Set the font style of cells B2 to D2 to bold
        sheet.getCellRange("B2:D2").getCellStyle().getExcelFont().isBold(true);

        //Set the font style of cells B3 to B7 to underline
        sheet.getCellRange("B3:B7").getCellStyle().getExcelFont().setUnderline(FontUnderlineType.Single);

        //Set the font color of cell B1 to blue
        sheet.getCellRange("B1").getCellStyle().getExcelFont().setColor(Color.blue);
        //Set the font color of cells B2 to D2 to pink
        sheet.getCellRange("B2:D2").getCellStyle().getExcelFont().setColor(Color.pink);
        //Set the font color of cells B3 to D7 to darkGray
        sheet.getCellRange("B3:D7").getCellStyle().getExcelFont().setColor(Color.darkGray);

        //Set the font style of cells B3 to D7 to italic
        sheet.getCellRange("B3:D7").getCellStyle().getExcelFont().isItalic(true);

        //Save the workbook to the specified file with Excel 2013 format
        workbook.saveToFile(output, ExcelVersion.Version2013);

        //Release the resources used by the workbook
        workbook.dispose();
    }
}
