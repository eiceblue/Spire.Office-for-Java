import com.spire.xls.*;

public class numberStyles {
    public static void main(String[] args) {
        String inputFile="data/numberStyles.xlsx";
        String outputFile = "output/numberStyles_result.xlsx";

        // Create a new workbook
        Workbook workbook = new Workbook();

        // Load the workbook from the input file
        workbook.loadFromFile(inputFile);

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Set text and formatting for cell B10
        sheet.getCellRange("B10").setText("NUMBER FORMATTING");
        sheet.getCellRange("B10").getCellStyle().getExcelFont().isBold(true);

        // Set text, value, and number format for cell B13
        sheet.getCellRange("B13").setText("0");
        sheet.getCellRange("C13").setNumberValue(1234.5678);
        sheet.getCellRange("C13").setNumberFormat("0");

        // Set text, value, and number format for cell B14
        sheet.getCellRange("B14").setText("0.00");
        sheet.getCellRange("C14").setNumberValue(1234.5678);
        sheet.getCellRange("C14").setNumberFormat("0.00");

        // Set text, value, and number format for cell B15
        sheet.getCellRange("B15").setText("#,##0.00");
        sheet.getCellRange("C15").setNumberValue(1234.5678);
        sheet.getCellRange("C15").setNumberFormat("#,##0.00");

        // Set text, value, and number format for cell B16
        sheet.getCellRange("B16").setText("$#,##0.00");
        sheet.getCellRange("C16").setNumberValue(1234.5678);
        sheet.getCellRange("C16").setNumberFormat("$#,##0.00");

        // Set text, value, and number format for cell B17
        sheet.getCellRange("B17").setText("0;[Red]-0");
        sheet.getCellRange("C17").setNumberValue(-1234.5678);
        sheet.getCellRange("C17").setNumberFormat("0;[Red]-0");

        // Set text, value, and number format for cell B18
        sheet.getCellRange("B18").setText("0.00;[Red]-0.00");
        sheet.getCellRange("C18").setNumberValue(-1234.5678);
        sheet.getCellRange("C18").setNumberFormat("0.00;[Red]-0.00");

        // Set text, value, and number format for cell B19
        sheet.getCellRange("B19").setText("#,##0;[Red]-#,##0");
        sheet.getCellRange("C19").setNumberValue(-1234.5678);
        sheet.getCellRange("C19").setNumberFormat("#,##0;[Red]-#,##0");

        // Set text, value, and number format for cell B20
        sheet.getCellRange("B20").setText("#,##0.00;[Red]-#,##0.000");
        sheet.getCellRange("C20").setNumberValue(-1234.5678);
        sheet.getCellRange("C20").setNumberFormat("#,##0.00;[Red]-#,##0.00");

        // Set text, value, and number format for cell B21
        sheet.getCellRange("B21").setText("0.00E+00");
        sheet.getCellRange("C21").setNumberValue(1234.5678);
        sheet.getCellRange("C21").setNumberFormat("0.00E+00");

        // Set text, value, and number format for cell B22
        sheet.getCellRange("B22").setText("0.00%");
        sheet.getCellRange("C22").setNumberValue(1234.5678);
        sheet.getCellRange("C22").setNumberFormat("0.00%");

        // Apply known color Gray25Percent to cells B13:B22
        sheet.getCellRange("B13:B22").getCellStyle().setKnownColor(ExcelColors.Gray25Percent);

        // Auto-fit the width of columns 2 and 3
        sheet.autoFitColumn(2);
        sheet.autoFitColumn(3);

        // Save the workbook to the output file in Excel 2013 format
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);

        //Release the resources used by the workbook
        workbook.dispose();
    }
}
