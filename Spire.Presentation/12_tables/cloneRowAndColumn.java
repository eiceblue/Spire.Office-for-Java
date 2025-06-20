
import com.spire.presentation.*;

public class cloneRowAndColumn {
    public static void main(String[] args) throws Exception {

        Presentation presentation = new Presentation();

        // Define columns with widths and rows with heights
        Double[] widths = new Double[] { 100d, 100d, 100d };
        Double[] heights = new Double[] {50d, 30d, 30d, 30d,30d };

        // Add table shape to slide
        ITable table = presentation.getSlides().get(0).getShapes().appendTable((float) presentation.getSlideSize().getSize().getWidth()/ 2 - 275, 90, widths, heights);

        // Add text to the row 1 cell 1
        table.get(0,0).getTextFrame().setText("Row 1 Cell 1");

        // Add text to the row 1 cell 2
        table.get(1,0).getTextFrame().setText("Row 1 Cell 2");

        // Clone row 1 at end of table
        table.getTableRows().append(table.getTableRows().get(0));

        // Add text to the row 2 cell 1
        table.get(0,1).getTextFrame().setText("Row 2 Cell 1");

        // Add text to the row 2 cell 2
        table.get(1,1).getTextFrame().setText("Row 2 Cell 2");

        // Clone row 2 as the 4th row of table
        table.getTableRows().insert(3,table.getTableRows().get(1));

        //Clone column 1 at end of table
        table.getColumnsList().add(table.getColumnsList().get(0));

        //Clone the 2nd column at 4th column index
        table.getColumnsList().insert(3,table.getColumnsList().get(1));

        String result = "CloneRowAndColumn_result.pptx";
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}

