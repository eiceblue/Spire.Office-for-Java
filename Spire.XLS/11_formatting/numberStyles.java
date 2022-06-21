import com.spire.xls.*;

public class numberStyles {
    public static void main(String[] args) {
        String inputFile="data/numberStyles.xlsx";
        String outputFile = "output/numberStyles_result.xlsx";

        //Create a workbook
        Workbook workbook = new Workbook();
        workbook.loadFromFile(inputFile);

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Input a number value for the specified cell and set the number format
        sheet.getCellRange("B10").setText("NUMBER FORMATTING");
        sheet.getCellRange("B10").getCellStyle().getExcelFont().isBold(true);

        sheet.getCellRange("B13").setText("0");
        sheet.getCellRange("C13").setNumberValue(1234.5678);
        sheet.getCellRange("C13").setNumberFormat("0");

        sheet.getCellRange("B14").setText("0.00");
        sheet.getCellRange("C14").setNumberValue(1234.5678);
        sheet.getCellRange("C14").setNumberFormat("0.00");

        sheet.getCellRange("B15").setText("#,##0.00");
        sheet.getCellRange("C15").setNumberValue(1234.5678);
        sheet.getCellRange("C15").setNumberFormat("#,##0.00");

        sheet.getCellRange("B16").setText("$#,##0.00");
        sheet.getCellRange("C16").setNumberValue(1234.5678);
        sheet.getCellRange("C16").setNumberFormat("$#,##0.00");

        sheet.getCellRange("B17").setText("0;[Red]-0");
        sheet.getCellRange("C17").setNumberValue(-1234.5678);
        sheet.getCellRange("C17").setNumberFormat("0;[Red]-0");

        sheet.getCellRange("B18").setText("0.00;[Red]-0.00");
        sheet.getCellRange("C18").setNumberValue(-1234.5678);
        sheet.getCellRange("C18").setNumberFormat("0.00;[Red]-0.00");

        sheet.getCellRange("B19").setText("#,##0;[Red]-#,##0");
        sheet.getCellRange("C19").setNumberValue(-1234.5678);
        sheet.getCellRange("C19").setNumberFormat("#,##0;[Red]-#,##0");

        sheet.getCellRange("B20").setText("#,##0.00;[Red]-#,##0.000");
        sheet.getCellRange("C20").setNumberValue(-1234.5678);
        sheet.getCellRange("C20").setNumberFormat("#,##0.00;[Red]-#,##0.00");

        sheet.getCellRange("B21").setText("0.00E+00");
        sheet.getCellRange("C21").setNumberValue(1234.5678);
        sheet.getCellRange("C21").setNumberFormat("0.00E+00");

        sheet.getCellRange("B22").setText("0.00%");
        sheet.getCellRange("C22").setNumberValue(1234.5678);
        sheet.getCellRange("C22").setNumberFormat("0.00%");

        sheet.getCellRange("B13:B22").getCellStyle().setKnownColor(ExcelColors.Gray25Percent);

        //AutoFit column
        sheet.autoFitColumn(2);
        sheet.autoFitColumn(3);

        //Save the result file
        workbook.saveToFile(outputFile, ExcelVersion.Version2013);
    }
}
