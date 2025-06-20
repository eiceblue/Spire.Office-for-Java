import com.spire.xls.*;
import java.awt.*;

public class applyGradientFillEffects {
    public static void main(String[] args) throws Exception {
        String output = "output/applyGradientFillEffects.xlsx";

        //Create a new Workbook object
        Workbook workbook = new Workbook();

        //Set the Excel version to 2010
        workbook.setVersion(ExcelVersion.Version2010);

        //Get the first Worksheet from the Workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Get the CellRange object for cell B5
        CellRange range =sheet.getCellRange("B5");

        //Set the row height of the range to 50
        range.setRowHeight(50);
        //Set the column width of the range to 30
        range.setColumnWidth(30);
        //Set the text in the range to "Hello"
        range.setText( "Hello");

        //Set the horizontal alignment of the range to center
        range.getStyle().setHorizontalAlignment( HorizontalAlignType.Center);

        //Set the fill pattern of the range to Gradient
        range.getStyle().getInterior().setFillPattern( ExcelPatternType.Gradient);
        //Set the fore color of the gradient
        range.getStyle().getInterior().getGradient().setForeColor(Color.CYAN);
        //Set the back color of the gradient
        range.getStyle().getInterior().getGradient().setBackColor( Color.BLUE);
        //Apply a two-color horizontal gradient shading effect to the gradient
        range.getStyle().getInterior().getGradient().twoColorGradient(GradientStyleType.Horizontal, GradientVariantsType.ShadingVariants1);

        //Save the workbook to the specified file with Excel 2010 format
        workbook.saveToFile(output, ExcelVersion.Version2010);

        //Release the resources used by the workbook
        workbook.dispose();
    }
}
