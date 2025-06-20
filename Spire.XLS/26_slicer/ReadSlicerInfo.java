import com.spire.xls.*;
import com.spire.xls.core.spreadsheet.slicer.*;

import java.io.FileWriter;
import java.io.IOException;

public class ReadSlicerInfo {
    public static void main(String[] args) {
        // Create a new Workbook instance
        Workbook wb = new Workbook();

        // Load an existing Excel file from the specified path
        wb.loadFromFile("data/SlicerTemplate.xlsx");

        // Get the first worksheet in the workbook
        Worksheet worksheet = wb.getWorksheets().get(0);

        // Get the slicer collection from the worksheet
        XlsSlicerCollection slicers = worksheet.getSlicers();

        StringBuilder builder = new StringBuilder();

        builder.append("slicers.getCount()：" + slicers.getCount() + "\n");

        for (int i = 0; i < slicers.getCount(); i++) {
            XlsSlicer xlsSlicer = slicers.get(i);
            builder.append("\n");
            builder.append("xlsSlicer.getName()：" + xlsSlicer.getName() + "\n");
            builder.append("xlsSlicer.getCaption()：" + xlsSlicer.getCaption() + "\n");
            builder.append("xlsSlicer.getNumberOfColumns()：" + xlsSlicer.getNumberOfColumns() + "\n");
            builder.append("xlsSlicer.getColumnWidth()：" + xlsSlicer.getColumnWidth() + "\n");
            builder.append("xlsSlicer.getRowHeight()：" + xlsSlicer.getRowHeight() + "\n");
            builder.append("xlsSlicer.getShowCaption()：" + xlsSlicer.isShowCaption() + "\n");
            builder.append("xlsSlicer.getPositionLocked()：" + xlsSlicer.isPositionLocked() + "\n");
            builder.append("xlsSlicer.getWidth()：" + xlsSlicer.getWidth() + "\n");
            builder.append("xlsSlicer.getHeight()：" + xlsSlicer.getHeight() + "\n");

            XlsSlicerCache slicerCache = xlsSlicer.getSlicerCache();

            builder.append("slicerCache.getSourceName()：" + slicerCache.getSourceName() + "\n");
            builder.append("slicerCache.isTabular()：" + slicerCache.isTabular() + "\n");
            builder.append("slicerCache.getName()：" + slicerCache.getName() + "\n");

            XlsSlicerCacheItemCollection slicerCacheItems = slicerCache.getSlicerCacheItems();
            XlsSlicerCacheItem xlsSlicerCacheItem = slicerCacheItems.get(1);

            builder.append("xlsSlicerCacheItem.getSelected()：" + xlsSlicerCacheItem.isSelected() + "\n");
        }

        // Write the result to a text file
        try (FileWriter writer = new FileWriter("ReadSlicerInfo.txt")) {
            writer.write(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Dispose of the workbook object to release resources
        wb.dispose();
    }
}
