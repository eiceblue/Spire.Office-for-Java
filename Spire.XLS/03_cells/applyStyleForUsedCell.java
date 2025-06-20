import com.spire.xls.*;
import java.awt.*;

public class applyStyleForUsedCell {
    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/SampleB_2.xlsx");

        //Create a cell style and set the parameter
        CellStyle cellStyle = workbook.getStyles().addStyle("Mystyle");
        cellStyle.setColor(Color.white);
        cellStyle.getBorders().setKnownColor(ExcelColors.Black);
        cellStyle.getBorders().setLineStyle(LineStyleType.Thin);
        cellStyle.getBorders().getByBordersLineType(BordersLineType.DiagonalDown).setLineStyle(LineStyleType.None);
        cellStyle.getBorders().getByBordersLineType(BordersLineType.DiagonalUp).setLineStyle(LineStyleType.None);

        //Apply style for used cell
        for (int i = 0; i < workbook.getWorksheets().size(); i++) {
            //false--false means only apply style to the used cells
            workbook.getWorksheets().get(i).applyStyle(cellStyle, false, false);
        }
        String result = "output/ApplyStyle_result.xlsx";
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
