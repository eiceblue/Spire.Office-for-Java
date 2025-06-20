import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import com.spire.doc.PictureWatermark;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class pictureWaterMarkWithBufferedImage {
    public static void main(String[] args) throws Exception{
        // Create a new instance of the Document class with the input file name
        Document document = new Document("data/sampleB_2.docx");

        // Insert the image watermark into the document
        insertImageWatermark(document);

        // Save the modified document as a docx file
        String output = "output/pictureWaterMarkWithBufferedImage.docx";
        document.saveToFile(output, FileFormat.Docx);

        // Dispose the document
        document.dispose();
    }

    public static void insertImageWatermark(Document document) throws Exception{

        File imageFile = new File("data/E-iceblue.png");
        BufferedImage bufferedImage = ImageIO.read(imageFile);

        // Create a new instance of the PictureWatermark class with the input BufferedImage, and set the scaling factor for the watermark image
        PictureWatermark picture = new PictureWatermark(bufferedImage,false);

        // Or another way to create PictureWatermark
        // PictureWatermark picture = new PictureWatermark();
        // picture.setPicture(bufferedImage);
        // picture.isWashout(false);

        // Set the scaling factor for the watermark image
        picture.setScaling(250);

        // Set the watermark to be applied to the document
        document.setWatermark(picture);
    }
}

