import com.spire.presentation.*;
import com.spire.presentation.Presentation;

public class extractVideo {
    public static void main(String[] args) throws Exception{
        //Create PPT document
        Presentation presentation = new Presentation();

        //Load the PPT document from disk.
        presentation.loadFromFile("data/video.pptx");

        //Define a variable
        int i = 0;

        //String for output file
        String result = String.format("output/Video{0}.avi", i);

        //Traverse all the slides of PPT file
        for (Object slideObj : presentation.getSlides())
        {
            ISlide slide=(ISlide)slideObj;
            //Traverse all the shapes of slides
            for (Object shapeObj : slide.getShapes())
            {
                IShape shape=(IShape)shapeObj;
                //If shape is IVideo
                if (shape instanceof IVideo)
                {
                    //Save the video
                    ((IVideo)shape).getEmbeddedVideoData().saveToFile(result);
                    i++;
                }
            }
        }
    }
}
