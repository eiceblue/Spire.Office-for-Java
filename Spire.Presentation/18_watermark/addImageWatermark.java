import com.spire.presentation.*;
import com.spire.presentation.drawing.*;
import javax.imageio.ImageIO;
import java.io.File;

public class addImageWatermark {
    public static void main(String[] args) throws Exception{
        //Create a PowerPoint document.
        Presentation presentation = new Presentation();

        //Load the file from disk.
        presentation.loadFromFile("data/Template_Ppt_1.pptx");

        //Get the image you want to add as image watermark.
        File file =new File("data/Logo.png");
        IImageData image = presentation.getImages().append(ImageIO.read(file));

        //Set the properties of SlideBackground, and then fill the image as watermark.
        presentation.getSlides().get(0).getSlideBackground().setType(BackgroundType.CUSTOM);
        presentation.getSlides().get(0).getSlideBackground().getFill().setFillType(FillFormatType.PICTURE);
        presentation.getSlides().get(0).getSlideBackground().getFill().getPictureFill().setFillType(PictureFillType.STRETCH);
        presentation.getSlides().get(0).getSlideBackground().getFill().getPictureFill().getPicture().setEmbedImage(image);

        String result = "output/addImageWatermark.pptx";

        //Save to file.
        presentation.saveToFile(result, FileFormat.PPTX_2013);
    }
}
