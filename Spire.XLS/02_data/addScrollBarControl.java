import com.spire.xls.*;
import com.spire.xls.core.IScrollBarShape;

public class addScrollBarControl {
    public static void main(String[] args){
        //Create a workbook
        Workbook workbook = new Workbook();

        //Load the document from disk
        workbook.loadFromFile("data/ExcelSample_N1.xlsx");

        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);

        //Set a value for range B10
        sheet.getCellRange("B10").setValue("1");
        sheet.getCellRange("B10").getStyle().getFont().isBold(true);
        //Add scroll bar control
        IScrollBarShape scrollBar = sheet.getScrollBarShapes().addScrollBar(10, 3, 150, 20);
        scrollBar.setLinkedCell(sheet.getCellRange("B10"));
        scrollBar.setMin(1);
        scrollBar.setMax(150);
        scrollBar.setIncrementalChange(1);
        scrollBar.setDisplay3DShading(true);

        //Save the document
        String output = "output/AddScrollBarControl_out.xlsx";
        workbook.saveToFile(output, ExcelVersion.Version2013);
    }
}
