
import com.spire.presentation.*;
import com.spire.presentation.drawing.FillFormatType;

public class removeTableBorderStyle {
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
                    for (int a = 0; a < row.getCount(); a ++)
                    {
                        row.get(a).getBorderTop().setFillType(FillFormatType.NONE);
                        row.get(a).getBorderBottom().setFillType(FillFormatType.NONE);
                        row.get(a).getBorderLeft().setFillType(FillFormatType.NONE);
                        row.get(a).getBorderRight().setFillType(FillFormatType.NONE);

                    }

                }
            }

        }

        String result = "output/Result-removeTableBorderStyle.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}

