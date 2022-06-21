import com.spire.xls.*;

public class writeFormulas {
    public static void main(String[] args) {
        Workbook workbook = new Workbook();
        Worksheet sheet = workbook.getWorksheets().get(0);

        int currentRow = 1;
        String currentFormula = "";

        sheet.setColumnWidth(1, 32);
        sheet.setColumnWidth(2, 16);
        sheet.setColumnWidth(3, 16);

        sheet.getCellRange(currentRow++,1).setValue("Examples of formulas :");
        sheet.getCellRange(++currentRow,1).setValue("Test data:");

        CellRange range = sheet.getCellRange("A1");
        range.getCellStyle().getExcelFont().isBold(true);
        range.getCellStyle().setFillPattern(ExcelPatternType.Solid);
        range.getCellStyle().setKnownColor(ExcelColors.LightGreen1);
        range.getCellStyle().getBorders().getByBordersLineType(BordersLineType.EdgeBottom).setLineStyle(LineStyleType.Medium);

        sheet.getCellRange(currentRow,2).setNumberValue(7.3);
        sheet.getCellRange(currentRow, 3).setNumberValue(5);
        sheet.getCellRange(currentRow, 4).setNumberValue(8.2);
        sheet.getCellRange(currentRow, 5).setNumberValue(4);
        sheet.getCellRange(currentRow, 6).setNumberValue(3);
        sheet.getCellRange(currentRow, 7).setNumberValue(11.3);

        sheet.getCellRange(++currentRow, 1).setValue("Formulas");
        sheet.getCellRange(currentRow, 2).setValue("Results");
        range = sheet.getCellRange(currentRow, 1, currentRow, 2);

        range.getCellStyle().getExcelFont().isBold(true);
        range.getCellStyle().setKnownColor(ExcelColors.LightGreen1);
        range.getCellStyle().setFillPattern(ExcelPatternType.Solid);
        range.getCellStyle().getBorders().getByBordersLineType(BordersLineType.EdgeBottom).setLineStyle(LineStyleType.Medium);

        currentFormula = "=\"hello\"";
        sheet.getCellRange(++currentRow, 1).setText("=\"hello\"");
        sheet.getCellRange(currentRow, 2).setFormula(currentFormula);
        sheet.getCellRange(currentRow, 3).setFormula("=\"" + new String(new char[] { '\u4f60', '\u597d' }) + "\"");

        currentFormula = "=300";
        sheet.getCellRange(++currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow, 2).setFormula(currentFormula);

        currentFormula = "=3389.639421";
        sheet.getCellRange(++currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow, 2).setFormula(currentFormula);

        currentFormula = "=false";
        sheet.getCellRange(++currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow, 2).setFormula(currentFormula);

        currentFormula = "=1+2+3+4+5-6-7+8-9";
        sheet.getCellRange(++currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow, 2).setFormula(currentFormula);

        currentFormula = "=33*3/4-2+10";
        sheet.getCellRange(++currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow, 2).setFormula(currentFormula);

        currentFormula = "=Sheet1!$B$3";
        sheet.getCellRange(++currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow, 2).setFormula(currentFormula);

        currentFormula = "=AVERAGE(Sheet1!$D$3:G$3)";
        sheet.getCellRange(++currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow, 2).setFormula(currentFormula);

        currentFormula = "=Count(3,5,8,10,2,34)";
        sheet.getCellRange(++currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow, 2).setFormula(currentFormula);

        currentFormula = "=NOW()";
        sheet.getCellRange(++currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow, 2).setFormula(currentFormula);
        sheet.getCellRange(currentRow, 2).getCellStyle().setNumberFormat("yyyy-MM-DD");

        currentFormula = "=SECOND(11)";
        sheet.getCellRange(++currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=MINUTE(12)";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=MONTH(9)";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=DAY(10)";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=TIME(4,5,7)";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=DATE(6,4,2)";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=RAND()";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=HOUR(12)";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=MOD(5,3)";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=WEEKDAY(3)";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=YEAR(23)";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=NOT(true)";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=OR(true)";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=AND(TRUE)";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=VALUE(30)";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=LEN(\"world\")";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=MID(\"world\",4,2)";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=ROUND(7,3)";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=SIGN(4)";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=INT(200)";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=ABS(-1.21)";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=LN(15)";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=EXP(20)";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=SQRT(40)";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=PI()";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=COS(9)";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=SIN(45)";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=MAX(10,30)";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=MIN(5,7)";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=AVERAGE(12,45)";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=SUM(18,29)";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=IF(4,2,2)";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        currentFormula = "=SUBTOTAL(3,Sheet1!B2:E3)";
        sheet.getCellRange(currentRow, 1).setText(currentFormula);
        sheet.getCellRange(currentRow++, 2).setFormula(currentFormula);

        String result="output/writeFormulas_result.xlsx";
        workbook.saveToFile(result,ExcelVersion.Version2013);
    }
}
