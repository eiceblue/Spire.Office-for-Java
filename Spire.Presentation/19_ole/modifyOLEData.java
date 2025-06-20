import com.spire.presentation.*;
import java.awt.*;
import java.io.*;

public class modifyOLEData {
    public static void main(String[] args) throws Exception{
        //Create a PPT document
        Presentation presentation = new Presentation();

        //Load document from disk
        presentation.loadFromFile("data/ModifyOLEData.pptx");

        //Loop through the slides and shapes
        for (Object slideObj : presentation.getSlides())
        {
            ISlide slide=(ISlide)slideObj;
            for (Object shapeObj : slide.getShapes())
            {
                IShape shape=(IShape)shapeObj;
                if (shape instanceof IOleObject)
                {
                    //Find OLE object
                    IOleObject oleObject = (IOleObject)shape;

                    //Get its data and write to file
                    byte[] bytes = oleObject.getData();
                    ByteArrayInputStream pptStream = new ByteArrayInputStream(bytes);
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    if (oleObject.getProgId().equals("PowerPoint.Show.12"))
                    {
                        //Load the PPT stream
                        Presentation ppt = new Presentation();
                        ppt.loadFromStream(pptStream, FileFormat.AUTO);

                        //Append an image in slide
                        ppt.getSlides().get(0).getShapes().appendEmbedImage(ShapeType.RECTANGLE, "data/Logo.png", new Rectangle(50, 50, 100, 100));
                        ppt.saveToFile(stream, FileFormat.PPTX_2013);

                        //Modify the data
                        oleObject.setData(stream.toByteArray());
                    }
                }
            }
        }

        //Save the document
        String result = "output/modifyOLEData.pptx";
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
