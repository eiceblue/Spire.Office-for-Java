
import com.spire.presentation.*;
import java.awt.*;

public class setBordersForExistingTable {
    public static void main(String[] args) throws Exception {

        //Create a PowerPoint document.
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/Template_Ppt_1.pptx");

        //Get the table within the PowerPoint document.
        ITable table = (ITable)presentation.getSlides().get(0).getShapes().get(0);

        //Set the border type as Inside and the border color as blue.
        table.setTableBorder(TableBorderType.Inside, 1, Color.blue);

        String result = "output/Result-setBordersForExistingTable.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}

