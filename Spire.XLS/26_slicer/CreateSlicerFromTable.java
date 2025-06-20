import com.spire.xls.*;
import com.spire.xls.core.IListObject;
import com.spire.xls.core.spreadsheet.slicer.*;

public class CreateSlicerFromTable {
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

        // Get slicer collection
        XlsSlicerCollection slicers = worksheet.getSlicers();

        //Create a table with the data from the specific cell range.
        IListObject table = worksheet.getListObjects().create("Super Table", worksheet.getCellRange("A1:C9"));

        int count = 3;
        int index = 0;
        for(SlicerStyleType type : SlicerStyleType.values()) {
            count += 5;
            String range = "E" + count;
            index = slicers.add(table, range.toString(), 0);

            //Style setting
            XlsSlicer xlsSlicer = slicers.get(index);
            xlsSlicer.setName("slicers_" + count);
            xlsSlicer.setStyleType(type);
        }

        //Save to file
        wb.saveToFile("CreateSlicerFromTable.xlsx", ExcelVersion.Version2013);

        // Dispose of the workbook object to release resources
        wb.dispose();
    }
}
