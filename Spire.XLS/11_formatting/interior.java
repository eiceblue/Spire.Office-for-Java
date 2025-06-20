import com.spire.xls.*;
import java.util.*;

public class interior {

    public static void main(String[] args) {
        // Create a new workbook
        Workbook workbook = new Workbook();

        // Set the version of the workbook to Excel 2007
        workbook.setVersion(ExcelVersion.Version2007);

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Determine the maximum number of colors available in Excel
        int maxColor = ExcelColors.values().length;

        // Create a random number generator with current time as the seed
        Random random = new Random((int) new Date().getTime());

        // Iterate over rows 2 to 39 (exclusive)
        for (int i = 2; i < 40; i++) {

            // Generate a random index to select a color from the first half of available colors
            ExcelColors backKnownColor = ExcelColors.fromValue(random.nextInt(maxColor / 2));

            // Set text in cells A1, B1, C1, and D1
            sheet.getCellRange("A1").setText("Color Name");
            sheet.getCellRange("B1").setText("Red");
            sheet.getCellRange("C1").setText("Green");
            sheet.getCellRange("D1").setText("Blue");

            // Merge cells E1 to K1 and set text
            sheet.getCellRange("E1:K1").merge();
            sheet.getCellRange("E1:K1").setText("Gradient");

            // Apply formatting to the header row
            sheet.getCellRange("A1:K1").getCellStyle().getExcelFont().isBold(true);
            sheet.getCellRange("A1:K1").getCellStyle().getExcelFont().setSize(11);

            // Get the color name for the selected color
            String colorName = backKnownColor.toString();

            // Set values in cells A{i}, B{i}, C{i}, and D{i}
            sheet.getCellRange("A" + i).setText(colorName);
            sheet.getCellRange("B" + i).setNumberValue(workbook.getPaletteColor(backKnownColor).getRed());
            sheet.getCellRange("C" + i).setNumberValue(workbook.getPaletteColor(backKnownColor).getGreen());
            sheet.getCellRange("D" + i).setNumberValue(workbook.getPaletteColor(backKnownColor).getBlue());

            // Merge cells E{i} to K{i} and set text
            sheet.getCellRange("E" + i + ":K" + i).merge();
            sheet.getCellRange("E" + i + ":K" + i).setText(colorName);

            // Apply gradient formatting to cells E{i} to K{i}
            sheet.getCellRange("E" + i + ":K" + i).getCellStyle().getInterior().setFillPattern(ExcelPatternType.Gradient);
            sheet.getCellRange("E" + i + ":K" + i).getCellStyle().getInterior().getGradient().setBackKnownColor(backKnownColor);
            sheet.getCellRange("E" + i + ":K" + i).getCellStyle().getInterior().getGradient().setForeKnownColor(ExcelColors.White);
            sheet.getCellRange("E" + i + ":K" + i).getCellStyle().getInterior().getGradient().setGradientStyle(GradientStyleType.Vertical);
            sheet.getCellRange("E" + i + ":K" + i).getCellStyle().getInterior().getGradient().setGradientVariant(GradientVariantsType.ShadingVariants1);
        }

        // Auto-fit the width of column 1
        sheet.autoFitColumn(1);

        // Specify the output file path
        String result = "output/interior_result.xlsx";

        // Save the workbook to the specified file path in Excel format
        workbook.saveToFile(result);

        //Release the resources used by the workbook
        workbook.dispose();
    }
}
