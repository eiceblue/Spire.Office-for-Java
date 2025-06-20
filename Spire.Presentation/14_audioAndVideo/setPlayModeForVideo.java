import com.spire.presentation.*;

public class setPlayModeForVideo {
    public static void main(String[] args) throws Exception{
        //Create a PowerPoint document.
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/Template_Ppt_8.pptx");

        //Find the video by looping through all the slides and set its play mode as auto.
        for (Object slideObj : presentation.getSlides())
        {
            ISlide slide=(ISlide)slideObj;
            for (Object shapeObj : slide.getShapes())
            {
                IShape shape=(IShape)shapeObj;
                if (shape instanceof IVideo)
                {
                    ((IVideo)shape).setPlayMode(VideoPlayMode.AUTO);
                }
            }
        }

        String result = "output/setPlayModeForVideo.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
