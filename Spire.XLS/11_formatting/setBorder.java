import com.spire.xls.*;
import java.awt.*;

public class setBorder {
    public static void main(String[] args) {
        String inputFile="data/setBorder.xlsx";
        String outputFile = "output/setBorder_result.xlsx";

        //Create a new Workbook object
        Workbook workbook = new Workbook();

        //Load the Excel file from the specified path
        workbook.loadFromFile(inputFile);

        //Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Define a CellRange object that includes all cells in the worksheet
        CellRange cr = sheet.getCellRange(sheet.getFirstRow(), sheet.getFirstColumn(), sheet.getLastRow(), sheet.getLastColumn());

        //Set the border style of the CellRange to Double line
        cr.getBorders().setLineStyle(LineStyleType.Double);
        //Set the diagonal down border style of the CellRange to None
        cr.getBorders().getByBordersLineType(BordersLineType.DiagonalDown).setLineStyle(LineStyleType.None);
        //Set the diagonal up border style of the CellRange to None
        cr.getBorders().getByBordersLineType(BordersLineType.DiagonalUp).setLineStyle(LineStyleType.None);
        //Set the border color of the CellRange to Blue
        cr.getBorders().setColor(Color.BLUE);

        //Save the modified workbook to the specified file path with Excel version 2010
        workbook.saveToFile(outputFile, ExcelVersion.Version2010);

        //Release the resources used by the workbook
        workbook.dispose();
    }
}
