
import com.spire.presentation.*;

public class addRowToTable {
    public static void main(String[] args) throws Exception {

        //Create a PowerPoint document.
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/Template_Ppt_1.pptx");

        //Get the table within the PowerPoint document.
        ITable table = (ITable)presentation.getSlides().get(0).getShapes().get(0);

        //Get the second row.
        TableRow row = table.getTableRows().get(1);

        //Clone the row and add it to the end of table.
        table.getTableRows().append(row);
        int rowCount = table.getTableRows().getCount();

        //Get the last row.
        TableRow lastRow = table.getTableRows().get(rowCount-1);

        //Set new data of the first cell of last row.
        lastRow.get(0).getTextFrame().setText("The first added cell");

        //Set new data of the second cell of last row.
        lastRow.get(1).getTextFrame().setText("The second added cell");

        String result = "output/Result-AddRowToTable.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}

