import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.autofilter.*;

import java.awt.*;

public class filterCellsByCellColor {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile("data/Template_Xls_3.xlsx");

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Create an auto filter in the sheet and specify the range to be filterd
        sheet.getAutoFilters().setRange(sheet.getRange().get("G1:G19"));

        //Get the column to be filter
        FilterColumn filtercolumn = sheet.getAutoFilters().get(0);

        //Add a color filter to filter the column based on cell color
        sheet.getAutoFilters().addFillColorFilter(filtercolumn, Color.red);

        //Filter the data.
        sheet.getAutoFilters().filter();

        String result = "output/filterCellsByCellColor_result.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
