import com.spire.xls.*;

public class moreFormulas {

    public static void main(String[] args) {
        // Create a new workbook object
        Workbook workbook = new Workbook();
        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Set the number format of the first column to text format
        sheet.getColumns()[0].setNumberFormat("@");

        // Set the value of cell A1 as a text formula "=CEILING.MATH(-2.78, 5, -1)"
        sheet.getCellRange("A1").setText("=CEILING.MATH(-2.78, 5, -1)");
        // Set the value of cell A2 as a text formula "=BITOR(23,10)"
        sheet.getCellRange("A2").setText("=BITOR(23,10)");
        // Set the value of cell A3 as a text formula "=BITAND(23,10)"
        sheet.getCellRange("A3").setText("=BITAND(23,10)");
        // Set the value of cell A4 as a text formula "=BITLSHIFT(23,2)"
        sheet.getCellRange("A4").setText("=BITLSHIFT(23,2)");
        // Set the value of cell A5 as a text formula "=BITRSHIFT(23,2)"
        sheet.getCellRange("A5").setText("=BITRSHIFT(23,2)");
        // Set the value of cell A6 as a text formula "=FLOOR.MATH(12.758, 2, -1)"
        sheet.getCellRange("A6").setText("=FLOOR.MATH(12.758, 2, -1)");
        // Set the value of cell A7 as a text formula "=ISOWEEKNUM(DATE(2012, 1, 1))"
        sheet.getCellRange("A7").setText("=ISOWEEKNUM(DATE(2012, 1, 1))");
        // Set the value of cell A8 as a text formula "=CEILING.PRECISE(-4.6, 3)"
        sheet.getCellRange("A8").setText("=CEILING.PRECISE(-4.6, 3)");
        // Set the value of cell A9 as a text formula "=ENCODEURL(\"https://www.e-iceblue.com\")"
        sheet.getCellRange("A9").setText("=ENCODEURL(\"https://www.e-iceblue.com\")");

        // Set the formula of cell B1 to "=CEILING.MATH(-2.78, 5, -1)"
        sheet.getCellRange("B1").setFormula("=CEILING.MATH(-2.78, 5, -1)");
        // Set the formula of cell B2 to "=BITOR(23,10)"
        sheet.getCellRange("B2").setFormula("=BITOR(23,10)");
        // Set the formula of cell B3 to "=BITAND(23,10)"
        sheet.getCellRange("B3").setFormula("=BITAND(23,10)");
        // Set the formula of cell B4 to "=BITLSHIFT(23,2)"
        sheet.getCellRange("B4").setFormula("=BITLSHIFT(23,2)");
        // Set the formula of cell B5 to "=BITRSHIFT(23,2)"
        sheet.getCellRange("B5").setFormula("=BITRSHIFT(23,2)");
        // Set the formula of cell B6 to "=FLOOR.MATH(12.758, 2, -1)"
        sheet.getCellRange("B6").setFormula("=FLOOR.MATH(12.758, 2, -1)");
        // Set the formula of cell B7 to "=ISOWEEKNUM(DATE(2012, 1, 1))"
        sheet.getCellRange("B7").setFormula("=ISOWEEKNUM(DATE(2012, 1, 1))");
        // Set the formula of cell B8 to "=CEILING.PRECISE(-4.6, 3)"
        sheet.getCellRange("B8").setFormula("=CEILING.PRECISE(-4.6, 3)");
        // Set the formula of cell B9 to "=ENCODEURL(\"https://www.e-iceblue.com\")"
        sheet.getCellRange("B9").setFormula("=ENCODEURL(\"https://www.e-iceblue.com\")");

        // Calculate all the formulas in the workbook
        workbook.calculateAllValue();

        // Auto-fit the columns in the allocated range of the worksheet
        sheet.getAllocatedRange().autoFitColumns();

        // Specify the file path where the result will be saved
        String result = "MoreFormulas.xlsx";
        // Save the workbook to the specified file path in Excel 2016 format
        workbook.saveToFile(result, ExcelVersion.Version2016);

        // Release resources used by the workbook
        workbook.dispose();
    }
}
