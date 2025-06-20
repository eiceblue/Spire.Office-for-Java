import com.spire.presentation.*;
import com.spire.presentation.collections.ImageCollection;
import com.spire.presentation.drawing.IImageData;

public class getImageRelativePath {
    public static void main(String[] args) throws Exception {
        //Create PPT document
        Presentation ppt = new Presentation();
        //Load document from disk
        ppt.loadFromFile("data/RemoveImages.pptx");
        //Get image collection
        ImageCollection images = ppt.getImages();
        for (int i = 0; i < images.size(); i++){
            IImageData imageData = images.get(i);
            //Get image relative path
            String path = imageData.getRelativePath();
            System.out.println(path);
        }
    }
}
