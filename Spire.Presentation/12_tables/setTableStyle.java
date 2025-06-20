
import com.spire.presentation.*;

public class setTableStyle {
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
                //Set the style of table.
                table.setStylePreset(TableStylePreset.MEDIUM_STYLE_1_ACCENT_2);
            }
        }

        String result = "output/Result-setTableStyle.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}

