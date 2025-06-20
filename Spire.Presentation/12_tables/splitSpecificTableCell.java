
import com.spire.presentation.*;

public class splitSpecificTableCell {
    public static void main(String[] args) throws Exception {

        //Create a PowerPoint document.
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/Template_Ppt_1.pptx");

        //Get the table within the PowerPoint document.
        ITable table = (ITable)presentation.getSlides().get(0).getShapes().get(0);

        //Split cell [1, 2] into 3 rows and 2 columns.
        table.getTableRows().get(1).get(2).split(3,2);

        String result = "output/Result-splitSpecificTableCell.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}

