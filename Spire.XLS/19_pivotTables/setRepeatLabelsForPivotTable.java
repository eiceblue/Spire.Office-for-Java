import com.spire.xls.*;
import com.spire.xls.core.IPivotField;

public class setRepeatLabelsForPivotTable {
    public static void main(String[] args) {
        // Create a new Workbook object
        Workbook workbook = new Workbook();

        // Load an existing Excel file into the Workbook
        workbook.loadFromFile("data/setRepeatLabelForPivotTable.xlsx");

        // Get the first worksheet from the Workbook
        Worksheet sheet = workbook.getWorksheets().get(0);

        // Create a new empty worksheet and set its name to "Pivot Table"
        Worksheet sheet2 = workbook.createEmptySheet();
        sheet2.setName("Pivot Table");

        // Get the range of cells from the original worksheet
        CellRange dataRange = sheet.getRange().get("A1:C9");

        // Create a PivotCache using the data range
        PivotCache cache = workbook.getPivotCaches().add(dataRange);

        // Add a PivotTable to the second worksheet using the PivotCache
        PivotTable pt = sheet2.getPivotTables().add("Pivot Table", sheet.getCellRange("A1"), cache);

        // Get the pivot field for "VendorNo"
        IPivotField r1 = pt.getPivotFields().get("VendorNo");

        // Set the axis for the pivot field to Row
        r1.setAxis(AxisTypes.Row);

        // Set the row header caption for the PivotTable to "VendorNo"
        pt.getOptions().setRowHeaderCaption("VendorNo");

        // Disable subtotals for the "VendorNo" field
        r1.setSubtotals(SubtotalTypes.None);

        // Enable repeating item labels for the "VendorNo" field
        r1.isRepeatItemLabels(true);

        // Get the pivot field for "Desc"
        IPivotField r2 = pt.getPivotFields().get("Desc");

        // Set the axis for the pivot field to Row
        r2.setAxis(AxisTypes.Row);

        // Set the row layout for the PivotTable to Tabular
        pt.getOptions().setRowLayout(PivotTableLayoutType.Tabular);

        // Add a data field to the PivotTable for "OnHand" with the caption "Sum of onHand" and summary type as Sum
        pt.getDataFields().add(pt.getPivotFields().get("OnHand"), "Sum of onHand", SubtotalTypes.Sum);

        // Set the built-in style of the PivotTable to PivotStyleMedium12
        pt.setBuiltInStyle(PivotBuiltInStyles.PivotStyleMedium12);

        // Save the Workbook to a file named "setRepeatLabelForPivotTable_result.xlsx" in Excel 2010 format
        workbook.saveToFile("output/setRepeatLabelForPivotTable_result.xlsx", ExcelVersion.Version2010);

        // Release resources associated with the Workbook
        workbook.dispose();
    }
}
