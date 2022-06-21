import com.spire.xls.*;
import java.awt.*;

public class setBorder {
    public static void main(String[] args) {
        String inputFile="data/setBorder.xlsx";
        String outputFile = "output/setBorder_result.xlsx";

        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile(inputFile);

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Get the cell range where you want to apply border style
        CellRange cr = sheet.getCellRange(sheet.getFirstRow(), sheet.getFirstColumn(), sheet.getLastRow(), sheet.getLastColumn());

        //Apply border style
        cr.getBorders().setLineStyle(LineStyleType.Double);
        cr.getBorders().getByBordersLineType(BordersLineType.DiagonalDown).setLineStyle(LineStyleType.None);
        cr.getBorders().getByBordersLineType(BordersLineType.DiagonalUp).setLineStyle(LineStyleType.None);
        cr.getBorders().setColor(Color.BLUE);

        //Save the document
        workbook.saveToFile(outputFile, ExcelVersion.Version2010);
    }
}
