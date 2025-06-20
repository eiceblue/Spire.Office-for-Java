
import com.spire.presentation.*;

import java.awt.*;

public class setBordersForNewlyTables {
    public static void main(String[] args) throws Exception {

        Presentation presentation = new Presentation();

        // Define columns with widths and rows with heights
        Double[] tableWidth = new Double[] { 100d, 100d, 100d,100d,100d };
        Double[] tableHeight = new Double[] {20d, 20d, 20d };

        for (TableBorderType e : TableBorderType.values()) {

            //Add a table to the presentation slide with the setting width and height
            ITable itable = presentation.getSlides().append().getShapes().appendTable(100, 100, tableWidth, tableHeight);

            //Add some text to the table cell.
            itable.getTableRows().get(0).get(0).getTextFrame().setText("Row");
            itable.getTableRows().get(1).get(0).getTextFrame().setText("Column");

            //Set the border type, border width and the border color for the table.
            itable.setTableBorder(TableBorderType.valueOf(e.toString()), 1.5, Color.red);
        }

        String result = "output/setBordersForNewlyTables_result.pptx";
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}

