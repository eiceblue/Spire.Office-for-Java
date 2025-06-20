import com.spire.presentation.*;
import com.spire.presentation.charts.*;

public class removeChartFromPptSlide {
    public static void main(String[] args) throws Exception {
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/Template_Ppt_3.pptx");

        //Get the first slide from the document.
        ISlide slide = presentation.getSlides().get(0);

        //Remove chart from the slide.
        for (int i = 0; i < slide.getShapes().getCount(); i++) {
            IShape shape =(IShape)slide.getShapes().get(i);
            if (shape instanceof IChart)
            {
                slide.getShapes().remove(shape);
            }
        }

        String result = "output/removeChartFromPptSlide_result.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
