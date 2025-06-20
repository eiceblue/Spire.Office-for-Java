
import com.spire.presentation.*;


public class lockAspectRatio {
    public static void main(String[] args) throws Exception {

        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/template_Ppt_1.pptx");

        //Get the table in PowerPoint document.
        for (int i = 0; i < presentation.getSlides().get(0).getShapes().getCount();i ++) {
            IShape shape = presentation.getSlides().get(0).getShapes().get(i);
            if (shape instanceof ITable)
            {
                ITable table = (ITable) shape;
                //Lock aspect ratio
                table.getShapeLocking().setAspectRatioProtection(true);
            }

        }
        String result = "output/Result-lockAspectRatio.pptx";

       //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}

