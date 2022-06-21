import com.spire.xls.*;
import com.spire.xls.core.IPivotField;

public class setRepeatLabelsForPivotTable {
    public static void main(String[] args) {
        //Open an Excel file
        Workbook workbook = new Workbook();
        workbook.loadFromFile("data/setRepeatLabelForPivotTable.xlsx");

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Creat a new sheet
        Worksheet sheet2 = workbook.createEmptySheet();
        sheet2.setName("Pivot Table");

        //Creat a pivot chart in the new sheet with the data from the first sheet
        CellRange dataRange = sheet.getRange().get("A1:C9");
        PivotCache cache = workbook.getPivotCaches().add(dataRange);
        PivotTable pt = sheet2.getPivotTables().add("Pivot Table", sheet.getCellRange("A1"), cache);

        //Pivot the first column of data
        IPivotField r1 = pt.getPivotFields().get("VendorNo");
        r1.setAxis(AxisTypes.Row);
        pt.getOptions().setRowHeaderCaption("VendorNo");
        r1.setSubtotals(SubtotalTypes.None);

        //Set repeat labels for pivot table
        r1.isRepeatItemLabels(true);

        //Pivot the second column of data
        IPivotField r2 = pt.getPivotFields().get("Desc");
        r2.setAxis(AxisTypes.Row);
        pt.getOptions().setRowLayout(PivotTableLayoutType.Tabular);

        //Sum the third column of data
        pt.getDataFields().add(pt.getPivotFields().get("OnHand"), "Sum of onHand", SubtotalTypes.Sum);
        pt.setBuiltInStyle(PivotBuiltInStyles.PivotStyleMedium12);

        //save to file
        workbook.saveToFile("output/setRepeatLabelForPivotTable_result.xlsx", ExcelVersion.Version2010);
    }
}
