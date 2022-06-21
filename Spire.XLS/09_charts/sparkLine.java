import com.spire.xls.*;

public class sparkLine {
    public static void main(String[] args) throws Exception {
        String input = "data/SparkLine.xlsx";
        String output = "output/sparkLine_out.xlsx";

        //load a Workbook from disk
        Workbook workbook = new Workbook();
        workbook.loadFromFile(input);

        //get the first sheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //add sparkline
        SparklineGroup sparklineGroup = sheet.getSparklineGroups().addGroup(SparklineType.Line);
        SparklineCollection sparklines = sparklineGroup.add();
        sparklines.add(sheet.getCellRange("A2:D2"), sheet.getCellRange("E2"));
        sparklines.add(sheet.getCellRange("A3:D3"), sheet.getCellRange("E3"));
        sparklines.add(sheet.getCellRange("A4:D4"), sheet.getCellRange("E4"));
        sparklines.add(sheet.getCellRange("A5:D5"), sheet.getCellRange("E5"));
        sparklines.add(sheet.getCellRange("A6:D6"), sheet.getCellRange("E6"));
        sparklines.add(sheet.getCellRange("A7:D7"), sheet.getCellRange("E7"));
        sparklines.add(sheet.getCellRange("A8:D8"), sheet.getCellRange("E8"));
        sparklines.add(sheet.getCellRange("A9:D9"), sheet.getCellRange("E9"));
        sparklines.add(sheet.getCellRange("A10:D10"), sheet.getCellRange("E10"));
        sparklines.add(sheet.getCellRange("A11:D11"), sheet.getCellRange("E11"));

        //save the Excel file
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
