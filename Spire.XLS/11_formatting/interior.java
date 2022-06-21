import com.spire.xls.*;
import java.util.*;

public class interior {

    public static void main(String[] args) {
        //Create a workbook
        Workbook workbook = new Workbook();

        //Specify the version
        workbook.setVersion(ExcelVersion.Version2007);

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        int maxColor = ExcelColors.values().length;

        //Create a random object
        Random random = new Random((int) new Date().getTime());

        for (int i = 2; i < 40; i++) {
            //Random backKnownColor
            ExcelColors backKnownColor = ExcelColors.fromValue(random.nextInt( maxColor / 2));

            //Add text
            sheet.getCellRange("A1").setText("Color Name");
            sheet.getCellRange("B1").setText("Red");
            sheet.getCellRange("C1").setText("Green");
            sheet.getCellRange("D1").setText("Blue");

            //Merge the cell"E1-K1"
            sheet.getCellRange("E1:K1").merge();
            sheet.getCellRange("E1:K1").setText("Gradient");
            sheet.getCellRange("A1:K1").getCellStyle().getExcelFont().isBold(true);
            sheet.getCellRange("A1:K1").getCellStyle().getExcelFont().setSize(11);

            //Set the text of color
            String colorName = backKnownColor.toString();

            sheet.getCellRange("A"+i).setText(colorName);
            sheet.getCellRange("B"+i).setNumberValue(workbook.getPaletteColor(backKnownColor).getRed());
            sheet.getCellRange("C"+i).setNumberValue(workbook.getPaletteColor(backKnownColor).getGreen());
            sheet.getCellRange("D"+i).setNumberValue(workbook.getPaletteColor(backKnownColor).getBlue());

            //Merge the cells
            sheet.getCellRange( "E"+i+":K"+ i).merge();

            //Set the text
            sheet.getCellRange("E"+i+":K"+ i).setText(colorName);

            //Set the interior of the color
            sheet.getCellRange("E"+i+":K"+ i).getCellStyle().getInterior().setFillPattern(ExcelPatternType.Gradient);
            sheet.getCellRange("E"+i+":K"+ i).getCellStyle().getInterior().getGradient().setBackKnownColor(backKnownColor);
            sheet.getCellRange("E"+i+":K"+ i).getCellStyle().getInterior().getGradient().setForeKnownColor(ExcelColors.White);
            sheet.getCellRange("E"+i+":K"+ i).getCellStyle().getInterior().getGradient().setGradientStyle(GradientStyleType.Vertical);
            sheet.getCellRange("E"+i+":K"+ i).getCellStyle().getInterior().getGradient().setGradientVariant(GradientVariantsType.ShadingVariants1);
        }

        //AutoFit column
        sheet.autoFitColumn(1);

        //Save the result file
        String result="output/interior_result.xlsx";
        workbook.saveToFile(result, ExcelVersion.Version2013);
    }
}
