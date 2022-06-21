import com.spire.xls.*;
import java.awt.*;

public class applyGradientFillEffects {
    public static void main(String[] args) throws Exception {
        String output = "output/applyGradientFillEffects.xlsx";

        //create a workbook
        Workbook workbook = new Workbook();
        workbook.setVersion(ExcelVersion.Version2010);

        //get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //get "B5" cell
        CellRange range =sheet.getCellRange("B5");

        //set row height and column width
        range.setRowHeight(50);
        range.setColumnWidth(30);
        range.setText( "Hello");

        //set alignment style
        range.getStyle().setHorizontalAlignment( HorizontalAlignType.Center);

        //set gradient filling effects
        range.getStyle().getInterior().setFillPattern( ExcelPatternType.Gradient);
        range.getStyle().getInterior().getGradient().setForeColor(Color.CYAN);
        range.getStyle().getInterior().getGradient().setBackColor( Color.BLUE);
        range.getStyle().getInterior().getGradient().twoColorGradient(GradientStyleType.Horizontal, GradientVariantsType.ShadingVariants1);

        //save to file
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
