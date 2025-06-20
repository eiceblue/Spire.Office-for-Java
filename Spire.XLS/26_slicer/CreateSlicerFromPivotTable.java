import com.spire.xls.*;
import com.spire.xls.collections.PivotTablesCollection;
import com.spire.xls.core.IPivotField;
import com.spire.xls.core.spreadsheet.slicer.*;

public class CreateSlicerFromPivotTable {
    public static void main(String[] args) {
        Workbook wb = new Workbook();
        Worksheet worksheet = wb.getWorksheets().get(0);
        worksheet.getCellRange("A1").setValue("fruit");
        worksheet.getCellRange("A2").setValue("grape");
        worksheet.getCellRange("A3").setValue("blueberry");
        worksheet.getCellRange("A4").setValue("kiwi");
        worksheet.getCellRange("A5").setValue("cherry");
        worksheet.getCellRange("A6").setValue("grape");
        worksheet.getCellRange("A7").setValue("blueberry");
        worksheet.getCellRange("A8").setValue("kiwi");
        worksheet.getCellRange("A9").setValue("cherry");

        worksheet.getCellRange("B1").setValue("year");
        worksheet.getCellRange("B2").setValue2(2020);
        worksheet.getCellRange("B3").setValue2(2020);
        worksheet.getCellRange("B4").setValue2(2020);
        worksheet.getCellRange("B5").setValue2(2020);
        worksheet.getCellRange("B6").setValue2(2021);
        worksheet.getCellRange("B7").setValue2(2021);
        worksheet.getCellRange("B8").setValue2(2021);
        worksheet.getCellRange("B9").setValue2(2021);

        worksheet.getCellRange("C1").setValue("amount");
        worksheet.getCellRange("C2").setValue2(50);
        worksheet.getCellRange("C3").setValue2(60);
        worksheet.getCellRange("C4").setValue2(70);
        worksheet.getCellRange("C5").setValue2(80);
        worksheet.getCellRange("C6").setValue2(90);
        worksheet.getCellRange("C7").setValue2(100);
        worksheet.getCellRange("C8").setValue2(110);
        worksheet.getCellRange("C9").setValue2(120);

        // Get pivot table collection
        PivotTablesCollection pivotTables = worksheet.getPivotTables();

        //Add a PivotTable to the worksheet
        CellRange dataRange = worksheet.getCellRange("A1:C9");
        PivotCache cache = wb.getPivotCaches().add(dataRange);

        //Cell to put the pivot table
        PivotTable pt = worksheet.getPivotTables().add("TestPivotTable", worksheet.getCellRange("A12"), cache);

        //Drag the fields to the row area.
        PivotField pf = (PivotField)pt.getPivotFields().get("fruit");
        pf.setAxis(AxisTypes.Row);
        PivotField pf2 =  (PivotField)pt.getPivotFields().get("year");
        pf2.setAxis(AxisTypes.Column);

        //Drag the field to the data area.
        pt.getDataFields().add(pt.getPivotFields().get("amount"), "SUM of Count", SubtotalTypes.Sum);

        //Set PivotTable style
        pt.setBuiltInStyle(PivotBuiltInStyles.PivotStyleMedium10);

        pt.calculateData();

        //Get slicer collection
        XlsSlicerCollection slicers = worksheet.getSlicers();

        int index = slicers.add(pt, "E12", 0);

        XlsSlicer xlsSlicer = slicers.get(index);
        xlsSlicer.setName("xlsSlicer");
        xlsSlicer.setWidth(100);
        xlsSlicer.setHeight(120);
        xlsSlicer.setStyleType(SlicerStyleType.SlicerStyleLight2);
        xlsSlicer.isPositionLocked(true);

        //Get SlicerCache object of current slicer
        XlsSlicerCache slicerCache = xlsSlicer.getSlicerCache();
        slicerCache.setCrossFilterType(SlicerCacheCrossFilterType.ShowItemsWithNoData);

        //Style setting
        XlsSlicerCacheItemCollection slicerCacheItems = xlsSlicer.getSlicerCache().getSlicerCacheItems();
        XlsSlicerCacheItem xlsSlicerCacheItem = slicerCacheItems.get(0);
        xlsSlicerCacheItem.isSelected(false);

        XlsSlicerCollection slicers_2 = worksheet.getSlicers();

        IPivotField r1 = pt.getPivotFields().get("year");
        int index_2 = slicers_2.add(pt, "I12", r1);

        XlsSlicer xlsSlicer_2 = slicers.get(index_2);
        xlsSlicer_2.setRowHeight(40);
        xlsSlicer_2.setStyleType(SlicerStyleType.SlicerStyleLight3);
        xlsSlicer_2.isPositionLocked(false);

        //Get SlicerCache object of current slicer
        XlsSlicerCache slicerCache_2 = xlsSlicer_2.getSlicerCache();
        slicerCache_2.setCrossFilterType(SlicerCacheCrossFilterType.ShowItemsWithDataAtTop);

        //Style setting
        XlsSlicerCacheItemCollection slicerCacheItems_2 = xlsSlicer_2.getSlicerCache().getSlicerCacheItems();
        XlsSlicerCacheItem xlsSlicerCacheItem_2 = slicerCacheItems_2.get(1);
        xlsSlicerCacheItem_2.isSelected(false);
        pt.calculateData();

        //Save to file
        wb.saveToFile("CreateSlicerFromPivotTable.xlsx", ExcelVersion.Version2013);

        // Dispose of the workbook object to release resources
        wb.dispose();
    }
}
