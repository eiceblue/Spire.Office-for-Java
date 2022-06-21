import com.spire.xls.*;

import java.awt.*;

public class setDefaultRowAndColumnStyle {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Create a cell style and set the color
        CellStyle style = workbook.getStyles().addStyle("MyStyle");
        style.setColor(Color.yellow);

        //Set the default style for the first row and column
        sheet.setDefaultRowStyle(1, style);
        sheet.setDefaultColumnStyle(1, style);

        String result = "output/Result-SetDefaultRowAndColumnStyle.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);
        
    }
}
