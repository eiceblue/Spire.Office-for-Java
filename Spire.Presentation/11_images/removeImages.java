import com.spire.presentation.*;

public class removeImages {
    public static void main(String[] args) throws Exception {
        //Create PPT document and load file
        Presentation presentation = new Presentation();
        presentation.loadFromFile("data/RemoveImages.pptx");
        //Get the first slide
        ISlide slide = presentation.getSlides().get(0);

        for (int i = slide.getShapes().getCount()-1; i >=0; i--)
        {
            //It is the SlidePicture object
            if (slide.getShapes().get(i) instanceof SlidePicture)
            {
                slide.getShapes().removeAt(i);
            }
        }

        String result = "output/RemoveImages_result.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
