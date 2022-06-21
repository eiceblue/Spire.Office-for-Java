import com.spire.xls.*;
import java.awt.*;

public class fontStyles {
    public static void main(String[] args) throws Exception {
        String input = "data/FontStyles.xlsx";
        String output = "output/fontStyles_output.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();

        //load the document from disk
        workbook.loadFromFile(input);

        //get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //set font style
        sheet.getCellRange("B1").getCellStyle().getExcelFont().setFontName("Comic Sans MS");
        sheet.getCellRange("B2:D2").getCellStyle().getExcelFont().setFontName("Corbel");
        sheet.getCellRange("B3:D7").getCellStyle().getExcelFont().setFontName("Aleo");

        //set font size
        sheet.getCellRange("B1").getCellStyle().getExcelFont().setSize(45);
        sheet.getCellRange("B2:D3").getCellStyle().getExcelFont().setSize(25);
        sheet.getCellRange("B3:D7").getCellStyle().getExcelFont().setSize(12);

        //set excel cell data to bold
        sheet.getCellRange("B2:D2").getCellStyle().getExcelFont().isBold(true);

        //set excel cell data to underline
        sheet.getCellRange("B3:B7").getCellStyle().getExcelFont().setUnderline(FontUnderlineType.Single);

        //set excel cell data color
        sheet.getCellRange("B1").getCellStyle().getExcelFont().setColor(Color.blue);
        sheet.getCellRange("B2:D2").getCellStyle().getExcelFont().setColor(Color.pink);
        sheet.getCellRange("B3:D7").getCellStyle().getExcelFont().setColor(Color.darkGray);

        //set excel cell data to italic
        sheet.getCellRange("B3:D7").getCellStyle().getExcelFont().isItalic(true);

        //save the result file
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
