import com.spire.xls.*;

public class createPivotTable {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Get the first worksheet from the workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Set values in cells A1, B1, and C1
        sheet.getCellRange("A1").setValue("Product");
        sheet.getCellRange("B1").setValue("Month");
        sheet.getCellRange("C1").setValue("Count");

        // Set values in cells A2 to A7
        sheet.getCellRange("A2").setValue("SpireDoc");
        sheet.getCellRange("A3").setValue("SpireDoc");
        sheet.getCellRange("A4").setValue("SpireXls");
        sheet.getCellRange("A5").setValue("SpireDoc");
        sheet.getCellRange("A6").setValue("SpireXls");
        sheet.getCellRange("A7").setValue("SpireXls");

        // Set values in cells B2 to B7
        sheet.getCellRange("B2").setValue("January");
        sheet.getCellRange("B3").setValue("February");
        sheet.getCellRange("B4").setValue("January");
        sheet.getCellRange("B5").setValue("January");
        sheet.getCellRange("B6").setValue("February");
        sheet.getCellRange("B7").setValue("February");

        // Set values in cells C2 to C7
        sheet.getCellRange("C2").setValue("10");
        sheet.getCellRange("C3").setValue("15");
        sheet.getCellRange("C4").setValue("9");
        sheet.getCellRange("C5").setValue("7");
        sheet.getCellRange("C6").setValue("8");
        sheet.getCellRange("C7").setValue("10");

        // Define a CellRange object for the data range A1:C7
        CellRange dataRange = sheet.getCellRange("A1:C7");

        // Add a PivotCache with the data range to the workbook
        PivotCache cache = workbook.getPivotCaches().add(dataRange);

        // Add a PivotTable with the cache to the worksheet at cell E10
        PivotTable pt = sheet.getPivotTables().add("Pivot Table", sheet.getCellRange("E10"), cache);

        // Get the PivotField for "Product"
        PivotField pf = null;
        if (pt.getPivotFields().get("Product") instanceof PivotField) {
            pf = (PivotField) pt.getPivotFields().get("Product");
        }
        pf.setAxis(AxisTypes.Row);

        // Get the PivotField for "Month"
        PivotField pf2 = null;
        if (pt.getPivotFields().get("Month") instanceof PivotField) {
            pf2 = (PivotField) pt.getPivotFields().get("Month");
        }
        pf2.setAxis(AxisTypes.Row);

        // Add a data field to the PivotTable for "Count" with a custom name, subtotal type "Sum"
        pt.getDataFields().add(pt.getPivotFields().get("Count"), "SUM of Count", SubtotalTypes.Sum);

        // Set the built-in style of the PivotTable to PivotStyleMedium12
        pt.setBuiltInStyle(PivotBuiltInStyles.PivotStyleMedium12);

        // Calculate the data in the PivotTable
        pt.calculateData();

        // Autofit columns 5 and 6 in the worksheet
        sheet.autoFitColumn(5);
        sheet.autoFitColumn(6);

        // Save the workbook to the specified file in Excel 2013 format
        workbook.saveToFile("output/createPivotTable_result.xlsx", ExcelVersion.Version2013);

        // Dispose the workbook object to release resources
        workbook.dispose();
    }
}
