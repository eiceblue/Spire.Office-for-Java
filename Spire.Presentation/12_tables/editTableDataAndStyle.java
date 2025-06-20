
import com.spire.presentation.*;

import java.awt.*;

public class editTableDataAndStyle {
    public static void main(String[] args) throws Exception {

        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/Template_Ppt_1.pptx");

        //Store the data used in replacement in string [].
        String[] str = new String[] { "Germany", "Berlin", "Europe", "0152458", "20860000" };

        ITable table = null;

        //Get the table in PowerPoint document.
        for (int i = 0; i < presentation.getSlides().get(0).getShapes().getCount();i ++)
        {
            IShape shape = presentation.getSlides().get(0).getShapes().get(i);
            if (shape instanceof  ITable)
            {
                table = (ITable)shape;
                //Change the style of table.
                table.setStylePreset(TableStylePreset.LIGHT_STYLE_1_ACCENT_2);
                for (int j = 0; j < table.getColumnsList().getCount(); j++)
                {
                    //Replace the data in cell.
                    table.get(j,2).getTextFrame().setText(str[i]);

                    //Set the highlight color.
                    table.get(j,2).getTextFrame().getTextRange().getHighlightColor().setColor(Color.lightGray);
                }
            }

        }

        String result = "output/Result-EditTableDataAndStyle.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}

