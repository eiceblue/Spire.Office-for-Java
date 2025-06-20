
import com.spire.presentation.*;

public class traverseThroughCells {
    public static void main(String[] args) throws Exception {

        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/Template_Ppt_1.pptx");


        ITable table = null;

        //Get the table in PowerPoint document.
        for (int i = 0; i < presentation.getSlides().get(0).getShapes().getCount();i ++)
        {
            IShape shape = presentation.getSlides().get(0).getShapes().get(i);
            if (shape instanceof  ITable)
            {
                table = (ITable)shape;

                for (int j = 0; j < table.getTableRows().getCount(); j++)
                {
                    TableRow row = table.getTableRows().get(j);
                    //Traverse through the cells of table.
                    for (int a = 0; a < row.getCount(); a ++)
                    {
                      Cell cell = row.get(a);
                      System.out.println(cell.getTextFrame().getText());
                    }

                }
            }

        }
    }
}

