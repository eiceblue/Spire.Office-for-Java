import com.spire.presentation.*;
import com.spire.presentation.drawing.*;

import java.io.FileInputStream;

public class appendImageStream {
    public static void main(String[] args) throws Exception {
        String inputFile = "data/AppendImageStream.pptx";
        String intputFile_Img = "data/imageStream.png";
        String outputFile = "out/result.pptx";
        Presentation ppt = new Presentation();
        ppt.loadFromFile(inputFile);
        FileInputStream fileInputStream=new FileInputStream(intputFile_Img);
        IImageData imageData=ppt.getImages().append(fileInputStream);
        SlidePicture slidePicture = (SlidePicture) ppt.getSlides().get(0).getShapes().get(0);
        slidePicture.getPictureFill().getPicture().setEmbedImage(imageData);
        ppt.saveToFile(outputFile, FileFormat.PPTX_2013);
    }
}
