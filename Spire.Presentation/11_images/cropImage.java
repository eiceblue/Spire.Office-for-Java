import com.spire.presentation.*;

public class cropImage {
    public static void main(String[] args) throws Exception {
        //Load PPT document from disk
        Presentation presentation = new Presentation();
        presentation.loadFromFile("data/CropImage.pptx");
        //Get first shape in first slide
        IShape shape=presentation.getSlides().get(0).getShapes().get(0);
        //If the shape is SlidePicture
        if(shape instanceof SlidePicture)
        {
            SlidePicture slidePicture= (SlidePicture) shape;
            //Crop the image
            slidePicture.crop(slidePicture.getLeft()+50f,slidePicture.getTop()+50f,100f,200f);
        }
        //Save the PPT document
        presentation.saveToFile("output/CropImage_out.pptx", FileFormat.PPTX_2013);
    }
}
