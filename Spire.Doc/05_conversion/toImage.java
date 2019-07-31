import com.spire.doc.Document;
import com.spire.doc.documents.ImageType;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class toImage {
    public static void main(String[] args) throws IOException {
        String input = "data/convertedTemplate.docx";
        String output = "output/toImage.png";

        //load Word document
        Document document= new Document();
        document.loadFromFile(input);

        //save to images
        BufferedImage image= document.saveToImages(0, ImageType.Bitmap);
        File file= new File(output);
        ImageIO.write(image, "PNG", file);
    }
}
