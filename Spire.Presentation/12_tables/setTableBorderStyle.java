
import com.spire.presentation.*;
import com.spire.presentation.drawing.FillFormatType;

public class setTableBorderStyle {
    public static void main(String[] args) throws Exception {

        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/Template_Ppt_1.pptx");

        ITable table = null;

        //Find the table by looping through all the slides, and then set borders for it.
        for (int b = 0; b < presentation.getSlides().getCount(); b ++)
        {
           ISlide slide = presentation.getSlides().get(b);
            for (int i = 0; i < slide.getShapes().getCount();i ++)
            {
                IShape shape = slide.getShapes().get(i);
                if (shape instanceof  ITable)
                {
                    table = (ITable)shape;

                    for (int j = 0; j < table.getTableRows().getCount(); j++)
                    {
                        TableRow row = table.getTableRows().get(j);
                        for (int a = 0; a < row.getCount(); a ++)
                        {
                            Cell cell = row.get(a);
                            cell.getBorderTop().setFillType(FillFormatType.SOLID);
                            cell.getBorderBottom().setFillType(FillFormatType.SOLID);
                            cell.getBorderLeft().setFillType(FillFormatType.SOLID);
                            cell.getBorderRight().setFillType(FillFormatType.SOLID);
                        }
                    }
                }

            }
        }


        String result = "output/Result-setTableBorderStyle.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}

