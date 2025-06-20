
import com.spire.presentation.*;

public class removeTableFromPptSlide {
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
                //Remove the table form the slide.
                presentation.getSlides().get(0).getShapes().remove(table);
            }
        }
        String result = "output/Result-removeTableFromPptSlide.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}

