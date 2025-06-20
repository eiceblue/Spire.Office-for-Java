import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.slicer.*;

public class ModifySlicer {
    public static void main(String[] args) {
        // Create a new Workbook instance
        Workbook wb = new Workbook();

        // Load an existing Excel file from the specified path
        wb.loadFromFile("data/SlicerTemplate.xlsx");

        // Get the first worksheet in the workbook
        Worksheet worksheet = wb.getWorksheets().get(0);

        // Get the slicer collection from the worksheet
        XlsSlicerCollection slicers = worksheet.getSlicers();

        // Get the first slicer from the slicer collection
        XlsSlicer xlsSlicer = slicers.get(0);

        // Set the style of the slicer to a dark theme (style type 4)
        xlsSlicer.setStyleType(SlicerStyleType.SlicerStyleDark4);

        // Change the caption (title) of the slicer
        xlsSlicer.setCaption("Modified Slicer");

        // Lock the position of the slicer to prevent it from being moved in the worksheet
        xlsSlicer.isPositionLocked(true);

        // Get the collection of cache items associated with the slicer
        XlsSlicerCacheItemCollection slicerCacheItems = xlsSlicer.getSlicerCache().getSlicerCacheItems();

        // Get the first cache item in the collection
        XlsSlicerCacheItem xlsSlicerCacheItem = slicerCacheItems.get(0);

        // Deselect the cache item
        xlsSlicerCacheItem.isSelected(false);

        // Get the display value of the cache item
        String displayValue = xlsSlicerCacheItem.getDisplayValue();

        // Get the slicer cache associated with the slicer
        XlsSlicerCache slicerCache = xlsSlicer.getSlicerCache();

        // Set the cross-filter type to show items even if they have no associated data
        slicerCache.setCrossFilterType(SlicerCacheCrossFilterType.ShowItemsWithNoData);

        // Save the modified workbook to a new file with Excel 2013 version format
        wb.saveToFile("ModifySlicer.xlsx", ExcelVersion.Version2013);

        // Dispose of the workbook object to release resources
        wb.dispose();
    }
}
