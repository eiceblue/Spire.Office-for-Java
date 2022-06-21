import com.spire.xls.*;

import java.awt.*;

public class getCellDataType {
    public static void main(String[] args) {
        //Create a workbook.
        Workbook workbook = new Workbook();

        //Load the file from disk.
        workbook.loadFromFile( "data/Template_Xls_2.xlsx");

        //Get the first worksheet.
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Get the cell types of the cells in range C13:F13
        for(CellRange range : sheet.getRange().get("H2:H7").getCellList()){
            Object cellType = sheet.getCellType(range.getRow(), range.getColumn(), false);
            sheet.getRange().get(range.getRow(), range.getColumn() + 1).setText(cellType.toString());
            sheet.getRange().get(range.getRow(), range.getColumn() + 1).getStyle().getFont().setColor(Color.red);
            sheet.getRange().get(range.getRow(), range.getColumn() + 1).getStyle().getFont().isBold(true);
        }

        String result = "output/getCellDataType_result.xlsx";

        //Save to file.
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}